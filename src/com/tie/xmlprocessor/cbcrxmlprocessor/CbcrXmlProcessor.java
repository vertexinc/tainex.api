package com.tie.xmlprocessor.cbcrxmlprocessor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import com.tie.model.CbcrTable1;
import com.tie.model.CbcrTable2;
import com.tie.model.CbcrTable3;
//import com.test.rss.ObjectFactory;
import com.tie.model.TieDoc;
import com.tie.model.TieDocType;
import com.tie.model.TieMsg;
import com.tie.model.TieTaxEntity;
import com.tie.xmlprocessor.cbcrxmlprocessor.cbcrxmljaxb.*;
import com.tie.xmlprocessor.cbcrxmlprocessor.cbcrxmljaxb.CorrectableCbcReportType.Summary;
import com.tie.xmlprocessor.cbcrxmlprocessor.cbcrxmljaxb.CorrectableCbcReportType.Summary.Revenues;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

// Determine whether root exist or not
// explore sub content to generate more jaxb
// put 'em into the root
// [JaxbCbcrXml root object] createJaxbObjectsFrom( TieMsg tieMsg );
// this method creates new jaxb objects, one level at a time, starting from
// the root, drawing data fields from the given msg )
// Likely to call many private methods to set attributes on jaxb objects,
// one method for each jaxb class.
public class CbcrXmlProcessor {

	/**
	 * Compose the xml string from the given TIE message object
	 * 
	 * @param tieMsg
	 * @return
	 * @throws JAXBException
	 */
	// TODO:read and reverse
	public String composeXmlString(TieMsg tieMsg) throws JAXBException {
		String retval = null;
		if (tieMsg == null)
			return retval;

		// factory,
		ObjectFactory factory = new ObjectFactory();

		// composeCBCOECD
		CBCOECD cbcoecd = composeCBCOECD(factory, tieMsg);

		// marshalling to string
		java.io.StringWriter sw = new StringWriter();
		JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);

		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
		marshaller.marshal(cbcoecd, sw);
		retval = sw.toString();

		// validation
		File file = new File("C:/CBCR_Files/simpleFile.xml");
		marshaller.marshal(cbcoecd, file);

		boolean valid = validateXMLSchema("C:/CBCR_Files/CbcXML_v1.0.xsd", "C:/CBCR_Files/file.xml");
		System.out.println();
		System.out.println("========Validation result========");
		System.out.println(valid);
		return retval;
	}

	public TieMsg deComposeXmlString(String tieMsgXMLString) throws JAXBException {
		TieMsg retval = null;

		JAXBContext jaxbContext = JAXBContext.newInstance(CBCOECD.class);
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		StringReader reader = new StringReader(tieMsgXMLString);

		CBCOECD cbcoecd = (CBCOECD) unmarshaller.unmarshal(reader);
		TieMsg tieMsg = new TieMsg();
		// TODO Implement the decomposing functions
		tieMsg = decomposeCBCOECD(cbcoecd, tieMsg);
		System.out.println("Mapped CBCOECD : " + cbcoecd.getCbcBody().toString());
		return retval;
	}

	public void validateXML(TieMsg tieMsg) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
		Marshaller marshaller = context.createMarshaller();
		ObjectFactory factory = new ObjectFactory();
		CBCOECD cbcoecd = composeCBCOECD(factory, tieMsg);
		// validation
		File file = new File("C:/CBCR_Files/file.xml");
		marshaller.marshal(cbcoecd, file);

		boolean valid = validateXMLSchema("C:/CBCR_Files/CbcXML_v1.0.xsd", "C:/CBCR_Files/file.xml");
		System.out.println();
		System.out.println("========Validation result========");
		System.out.println(valid);

	}

	/**
	 * Compose the room CBCOECD element from the given Tie message object.
	 * 
	 * @param objFactory
	 * @param tieMsg
	 * @return
	 */
	protected CBCOECD composeCBCOECD(ObjectFactory objFactory, TieMsg tieMsg) {
		CBCOECD retval = null;

		// 1. Need how many element?
		// only one CBCOECD is necessary, since it is the root
		retval = objFactory.createCBCOECD();

		// 2. Populate all its attributes and simple sub element

		// 3. Compose all child sub elements
		MessageSpecType msgSpec = composeMessageSpec(objFactory, tieMsg);
		// add msgSpec to CBCOECD retval object
		retval.setMessageSpec(msgSpec);

		// Compose a list a CbcBody
		List<CbcBodyType> cbcBodyList = composeCbcBodyList(objFactory, tieMsg);

		// add body list to retval
		// Check documentation in CBCOECD.java, the set func was removed
		// purposely
		if (!cbcBodyList.isEmpty()) {
			for (CbcBodyType CbcBody : cbcBodyList) {
				retval.getCbcBody().add(CbcBody);
			}
		}
		return retval;
	}

	protected TieMsg decomposeCBCOECD(CBCOECD cbcOECD, TieMsg tieMsg) {
		// Decompose messageSpec
		tieMsg = deComposeMessageSpec(cbcOECD, tieMsg);
		// Decompose cbcBody
		tieMsg = deComposeCbcBodyList(cbcOECD, tieMsg);
		return tieMsg;
	}

	/**
	 * Compose MessageSpec tag from the given message.
	 * 
	 * @param objFactory
	 * @param tieMsg
	 * @return
	 */
	private MessageSpecType composeMessageSpec(ObjectFactory objFactory, TieMsg tieMsg) {
		MessageSpecType retval = null;

		// 1. Need how many element?
		// only one is necessary, as specified in xsd
		retval = objFactory.createMessageSpecType();

		// 2. Populate all its attributes and simple sub element
		String sendingEntityIdNum = tieMsg.getSendingEntityIdNum();
		// Set as a blank space here
		retval.setSendingEntityIN(" ");

		if (tieMsg.getTransmittingCountry() != null) {
			CountryCodeType transmittingCountry = CountryCodeType.fromValue(tieMsg.getTransmittingCountry());
			retval.setTransmittingCountry(transmittingCountry);
		}

		composeReceivingCountry(tieMsg, retval);
		MessageTypeEnumType messageTypeEnum = MessageTypeEnumType.fromValue("CBC");
		retval.setMessageType(messageTypeEnum);
		//
		if (tieMsg.getLanguage() != null) {
			LanguageCodeType languageCode = LanguageCodeType.fromValue(tieMsg.getLanguage().toUpperCase());
			retval.setLanguage(languageCode);
		}

		if (tieMsg.getWarning() != null) {
			retval.setWarning(tieMsg.getWarning());
		}

		if (tieMsg.getContact() != null) {
			retval.setContact(tieMsg.getContact());
		}

		if (tieMsg.getMessageRefId() != null) {
			retval.setMessageRefId(tieMsg.getMessageRefId());
		}

		if (tieMsg.getMessageTypeIndic() != null) {
			CbcMessageTypeIndicEnumType cbcMessageTypeIndicEnum = CbcMessageTypeIndicEnumType
					.fromValue(tieMsg.getMessageTypeIndic());
			retval.setMessageTypeIndic(cbcMessageTypeIndicEnum);
		}
		//
		// CorrMessageRefId: Must point to 1 or more previous message
		composeCorrMessageRefId(tieMsg, retval);
		//
		// The reporting YEAR
		retval.setReportingPeriod(XMLdate(tieMsg.getReportingPeriod(), "reportingPeriod"));
		//
		retval.setTimestamp(XMLdate(tieMsg.getTimestamp(), "timestamp"));
		System.out.println(tieMsg.getReportingPeriod() + " & " + tieMsg.getTimestamp());
		// 3. Compose all child sub elements
		// no sub element found

		return retval;
	}

	protected TieMsg deComposeMessageSpec(CBCOECD cbcOECD, TieMsg tieMsg) {
		// TODO Auto-generated method stub
		MessageSpecType msgSpecType = cbcOECD.getMessageSpec();
		// Map sendingEntityId
		String sendingEntityIdNum = msgSpecType.getSendingEntityIN();
		tieMsg.setSendingEntityIdNum(sendingEntityIdNum);

		// Map transmittingCountry
		if (msgSpecType.getTransmittingCountry() != null) {
			String transmittingCountryString = msgSpecType.getTransmittingCountry().toString();
			tieMsg.setTransmittingCountry(transmittingCountryString);
		}

		// Map receivingCountry
		decomposeReceivingCountry(tieMsg, msgSpecType);

		// Map messageType
		if (msgSpecType.getMessageType() != null) {
			String messageType = msgSpecType.getMessageType().toString();
			tieMsg.setMessageType(messageType);
		}

		// Map language
		if (msgSpecType.getLanguage() != null) {
			String language = msgSpecType.getLanguage().toString();
			tieMsg.setLanguage(language);
		}

		// Map warning
		if (msgSpecType.getWarning() != null) {
			String warning = msgSpecType.getMessageType().toString();
			tieMsg.setWarning(warning);
		}

		// Map contact
		if (msgSpecType.getContact() != null) {
			String contact = msgSpecType.getContact().toString();
			tieMsg.setContact(contact);
		}

		// Map messageRefId
		if (msgSpecType.getMessageRefId() != null) {
			String messageRefId = msgSpecType.getMessageRefId();
		}

		// Map messageTypeIndic
		if (msgSpecType.getMessageTypeIndic() != null) {
			String messageTypeIndic = msgSpecType.getMessageTypeIndic().toString();
			tieMsg.setMessageTypeIndic(messageTypeIndic);
		}
		// TODO CorrMessageRefId: Must point to 1 or more previous message
		// composeCorrMessageRefId(tieMsg, retval);
		// Map reportingPeriod
		if (msgSpecType.getReportingPeriod() != null) {
			String reportingPeriod = msgSpecType.getReportingPeriod().toString();
			tieMsg.setReportingPeriod(reportingPeriod);
		}

		// Map timeStamp
		if (msgSpecType.getTimestamp() != null) {
			String timestamp = msgSpecType.getTimestamp().toString();
			tieMsg.setTimestamp(timestamp);
		}
		return tieMsg;
	}

	private XMLGregorianCalendar XMLdate(String dateString, String dateFormat) {
		Date dfDate = null;
		DateFormat df = null;
		XMLGregorianCalendar xmlDate = null;
		if (dateFormat.equals("reportingPeriod")) {
			System.out.println("Directing to reporting period");
			df = new SimpleDateFormat("yyyy");
		} else if (dateFormat.equals("timestamp")) {
			df = new SimpleDateFormat("MM/dd/yyyy, HH:mm a");
		}
		try {
			dfDate = df.parse(dateString);
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(dfDate);
			xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (ParseException | DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return xmlDate;
	}

	private void composeCorrMessageRefId(TieMsg tieMsg, MessageSpecType retval) {
		// TODO Auto-generated method stub
		if (tieMsg.getCorrMessageRefIds() != null) {
			List<String> CorrMessageRefIdList = retval.getCorrMessageRefId();
			String corrMessageRefIdListString = tieMsg.getCorrMessageRefIds();
			String[] corrMessageRefIdListStringSplit = corrMessageRefIdListString.split("\\s*,\\s*");
			for (String CorrMessageRefId : corrMessageRefIdListStringSplit) {
				CorrMessageRefIdList.add(CorrMessageRefId);
			}
		}
	}

	/**
	 * Compose a list of CbcBody elements
	 * 
	 * @param objFactory
	 * @param tieMsg
	 * @return
	 */
	private List<CbcBodyType> composeCbcBodyList(ObjectFactory objFactory, TieMsg tieMsg) {
		List<CbcBodyType> retval = null;

		// 1. Need how many element?
		// same as # of docs in tieMsg
		int numOfDocs = tieMsg.getNumOfDocs();
		// The doc defined in xsd shows its quantity has to be greater than 0
		if (numOfDocs > 0) {
			retval = new ArrayList<CbcBodyType>();

			// 2. Populate all its attributes and simple sub element
			// loop over each doc in tie message
			for (TieDoc doc : tieMsg.getTieDocList()) {

				CbcBodyType cbcBody = composeCbcBody(objFactory, tieMsg, doc);
				// add cbcBody to retval.add( cbcBody )
				retval.add(cbcBody);
			}
		}

		// 3. Compose all child sub elements
		// No need for element list

		return retval;
	}

	private TieMsg deComposeCbcBodyList(CBCOECD cbcOECD, TieMsg tieMsg) {
		// TODO Auto-generated method stub
		if (cbcOECD.getCbcBody() != null) {
			for (CbcBodyType cbcBody : cbcOECD.getCbcBody()) {
				TieDoc doc = deComposeCbcBody(cbcBody,tieMsg);
				tieMsg.getTieDocList().add(doc);
			}
		}
		return null;
	}


	/**
	 * Compose one CbcBody for the given doc in the message
	 * 
	 * @param objFactory
	 * @param tieMsg
	 * @param doc
	 * @return
	 */
	private CbcBodyType composeCbcBody(ObjectFactory objFactory, TieMsg tieMsg, TieDoc doc) {

		CbcBodyType retval = null;
		retval = objFactory.createCbcBodyType();
		// 1. Need how many element?

		// 2. Populate all its attributes and simple sub element
		CorrectableReportingEntityType reportingEntity = composeReportingEntity(objFactory, tieMsg, doc);

		List<CorrectableCbcReportType> cbcReportList = composeCbcReport(objFactory, tieMsg, doc);

		// 3. Compose all child sub elements
		retval.setReportingEntity(reportingEntity);

		for (CorrectableCbcReportType cbcreport : cbcReportList) {
			retval.getCbcReports().add(cbcreport);
		}
		//
		for (CbcrTable3 cbcrTable3 : doc.getCbcrTable3List()) {
			CorrectableAdditionalInfoType additionalInfo = composeAdditionalInfo(objFactory, tieMsg, doc, cbcrTable3);
			retval.getAdditionalInfo().add(additionalInfo);
		}

		return retval;
	}
	
	private TieDoc deComposeCbcBody(CbcBodyType cbcBody,TieMsg tieMsg) {
		// TODO Auto-generated method stub
		TieDoc doc = new TieDoc();
		deComposeReportingEntity(cbcBody.getReportingEntity(),doc,tieMsg);

		return null;
	}

	private CorrectableAdditionalInfoType composeAdditionalInfo(ObjectFactory objFactory, TieMsg tieMsg, TieDoc doc,
			CbcrTable3 cbcrTable3) {
		// TODO Auto-generated method stub
		CorrectableAdditionalInfoType retval = objFactory.createCorrectableAdditionalInfoType();
		DocSpecType docSpec = composeDocSpec(objFactory, tieMsg, doc);
		String otherInfo = cbcrTable3.getAdditionalInfo();
		retval.setOtherInfo(otherInfo);
		retval.setDocSpec(docSpec);
		return retval;
	}

	// Right now we only have cbcrDoc, this list should contain only one doc
	@SuppressWarnings("null")
	private List<CorrectableCbcReportType> composeCbcReport(ObjectFactory objFactory, TieMsg tieMsg, TieDoc doc) {
		// TODO Auto-generated method stub
		// 1. Need how many element?
		List<CorrectableCbcReportType> retval = new ArrayList<CorrectableCbcReportType>();

		// 2. Populate all its attributes and simple sub element
		for (CbcrTable1 table1 : doc.getCbcrTable1List()) {
			CorrectableCbcReportType cbcReport = objFactory.createCorrectableCbcReportType();
			DocSpecType docSpec = composeDocSpec(objFactory, tieMsg, doc);

			// set ResCountryCode
			String resCountryCode = doc.getResCountryCode();
			CountryCodeType resCtyCode = CountryCodeType.fromValue(resCountryCode);

			// set cbc:summary
			Summary summary = composeSummary(objFactory, tieMsg, doc, table1);

			// set table2
			List<ConstituentEntityType> constEntities = new ArrayList<ConstituentEntityType>();
			List<CbcrTable2> table2List = doc.getCbcrTable2List();
			for (CbcrTable2 table2 : table2List) {
				if (table1.getTaxJurisdiction().equals(table2.getTaxJurisdiction())) {
					ConstituentEntityType constEntitiy = composeConstEntities(objFactory, tieMsg, table2, doc);
					constEntities.add(constEntitiy);
				}
			}

			// TODO: Need to figure out the business role of table2 MNE group
			// List<ConstituentEntityType> constEntityList =
			// composeEntityList(objFactory, tieMsg, doc,);
			// 3. Compose all child sub elements
			cbcReport.setDocSpec(docSpec);
			cbcReport.setResCountryCode(resCtyCode);
			cbcReport.setSummary(summary);
			for (ConstituentEntityType constEntitiy : constEntities) {
				cbcReport.getConstEntities().add(constEntitiy);
			}

			if (cbcReport != null) {
				retval.add(cbcReport);
			}
		}
		return retval;
	}

	private ConstituentEntityType composeConstEntities(ObjectFactory objFactory, TieMsg tieMsg, CbcrTable2 table2,
			TieDoc doc) {
		// TODO Auto-generated method stub
		ConstituentEntityType retval = objFactory.createConstituentEntityType();
		// Set ConstEntity
		OrganisationPartyType constEntity = composeEntity(objFactory, tieMsg, doc);
		retval.setConstEntity(constEntity);

		// Set IncorpCountryCode
		retval.setIncorpCountryCode(CountryCodeType.fromValue(table2.getTaxJurisOfIncorporation()));

		// Set BizActivities
		List<CbcBizActivityTypeEnumType> cbcBizActivityList = retval.getBizActivities();
		if (table2.getMainBusRAndD() == 1) {
			cbcBizActivityList.add(CbcBizActivityTypeEnumType.fromValue("CBC501"));
		}
		if (table2.getMainBusHoldingIp() == 1) {
			cbcBizActivityList.add(CbcBizActivityTypeEnumType.fromValue("CBC502"));
		}
		if (table2.getMainBusPurchasing() == 1) {
			cbcBizActivityList.add(CbcBizActivityTypeEnumType.fromValue("CBC503"));
		}
		if (table2.getMainBusMfctOrPrdn() == 1) {
			cbcBizActivityList.add(CbcBizActivityTypeEnumType.fromValue("CBC504"));
		}
		if (table2.getMainBusSaleMktDistr() == 1) {
			cbcBizActivityList.add(CbcBizActivityTypeEnumType.fromValue("CBC505"));
		}

		if (table2.getMainBusAdminMgmtSupportSvc() == 1) {
			cbcBizActivityList.add(CbcBizActivityTypeEnumType.fromValue("CBC506"));
		}
		if (table2.getMainBusProvSvcToUnrelatedParti() == 1) {
			cbcBizActivityList.add(CbcBizActivityTypeEnumType.fromValue("CBC507"));
		}
		if (table2.getMainBusInternalGroupFinance() == 1) {
			cbcBizActivityList.add(CbcBizActivityTypeEnumType.fromValue("CBC508"));
		}
		if (table2.getMainBusRegulatedFinSvc() == 1) {
			cbcBizActivityList.add(CbcBizActivityTypeEnumType.fromValue("CBC509"));
		}
		if (table2.getMainBusInsurance() == 1) {
			cbcBizActivityList.add(CbcBizActivityTypeEnumType.fromValue("CBC510"));
		}
		if (table2.getMainBusHoldingEquityInstrument() == 1) {
			cbcBizActivityList.add(CbcBizActivityTypeEnumType.fromValue("CBC511"));
		}
		if (table2.getMainBusDormant() == 1) {
			cbcBizActivityList.add(CbcBizActivityTypeEnumType.fromValue("CBC512"));
		}
		cbcBizActivityList.add(CbcBizActivityTypeEnumType.fromValue("CBC513"));
		// Set OtherEntityInfo

		retval.setOtherEntityInfo(table2.getMainBusOtherNotes());
		return retval;
	}

	private Summary composeSummary(ObjectFactory objFactory, TieMsg tieMsg, TieDoc doc, CbcrTable1 table1) {
		// TODO Auto-generated method stub
		Summary retval = new Summary();
		// set revenues
		Revenues revenues = new Revenues();
		MonAmntType unrelated = new MonAmntType();
		unrelated.setValue(new BigDecimal(table1.getRevenueUnrelatedParty()).toBigInteger());
		unrelated.setCurrCode(CurrCodeType.fromValue(doc.getCurrencyCode()));

		MonAmntType related = new MonAmntType();
		related.setValue(new BigDecimal(table1.getRevenueRelatedParty()).toBigInteger());
		related.setCurrCode(CurrCodeType.fromValue(doc.getCurrencyCode()));

		MonAmntType total = new MonAmntType();
		total.setValue(new BigDecimal(table1.getRevenueTotal()).toBigInteger());
		total.setCurrCode(CurrCodeType.fromValue(doc.getCurrencyCode()));

		revenues.setUnrelated(unrelated);
		revenues.setRelated(related);
		revenues.setTotal(total);

		MonAmntType profitOrLoss = new MonAmntType();
		profitOrLoss.setValue(new BigDecimal(table1.getPlBeforeIncomeTax()).toBigInteger());
		profitOrLoss.setCurrCode(CurrCodeType.fromValue(doc.getCurrencyCode()));

		MonAmntType taxPaid = new MonAmntType();
		taxPaid.setValue(new BigDecimal(table1.getIncomeTaxPaid()).toBigInteger());
		taxPaid.setCurrCode(CurrCodeType.fromValue(doc.getCurrencyCode()));

		MonAmntType taxAccrued = new MonAmntType();
		taxAccrued.setValue(new BigDecimal(table1.getIncomeTaxAccrued()).toBigInteger());
		taxAccrued.setCurrCode(CurrCodeType.fromValue(doc.getCurrencyCode()));

		MonAmntType capital = new MonAmntType();
		capital.setValue(new BigDecimal(table1.getStatedCapital()).toBigInteger());
		capital.setCurrCode(CurrCodeType.fromValue(doc.getCurrencyCode()));

		MonAmntType earnings = new MonAmntType();
		earnings.setValue(new BigDecimal(table1.getAccumulatedEarnings()).toBigInteger());
		earnings.setCurrCode(CurrCodeType.fromValue(doc.getCurrencyCode()));

		BigInteger NbEmployees = BigInteger.valueOf(table1.getNumberOfEmployees());

		MonAmntType assets = new MonAmntType();
		assets.setValue(new BigDecimal(table1.getTangibleAssetsNonCash()).toBigInteger());
		assets.setCurrCode(CurrCodeType.fromValue(doc.getCurrencyCode()));

		retval.setRevenues(revenues);
		retval.setProfitOrLoss(profitOrLoss);
		retval.setTaxPaid(taxPaid);
		retval.setTaxAccrued(taxAccrued);
		retval.setCapital(capital);
		retval.setEarnings(earnings);
		retval.setNbEmployees(NbEmployees);
		retval.setAssets(assets);
		return retval;
	}

	private CorrectableReportingEntityType composeReportingEntity(ObjectFactory objFactory, TieMsg tieMsg, TieDoc doc) {
		// TODO Auto-generated method stub
		// 1. Need how many element?

		// 2. Populate all its attributes and simple sub element
		CorrectableReportingEntityType retval = new CorrectableReportingEntityType();
		retval = objFactory.createCorrectableReportingEntityType();

		OrganisationPartyType cbcEntity = composeEntity(objFactory, tieMsg, doc);
		String reportingEntityRoleString = doc.getReportingEntityRole();
		CbcReportingRoleEnumType reportingRole = CbcReportingRoleEnumType.fromValue(reportingEntityRoleString);
		DocSpecType docSpec = composeDocSpec(objFactory, tieMsg, doc);

		// 3. Compose all child sub elements
		retval.setEntity(cbcEntity);
		retval.setReportingRole(reportingRole);
		retval.setDocSpec(docSpec);

		return retval;
	}

	private void deComposeReportingEntity(CorrectableReportingEntityType reportingEntity,TieDoc tieDoc,TieMsg tieMsg) {
		// TODO Auto-generated method stub
		TieTaxEntity tieTaxEntity = new TieTaxEntity();
		String reportEntityRole = reportingEntity.getReportingRole().toString();
		tieDoc.setReportingEntityRole(reportEntityRole);
		//Decompose entitySpec
		decomposeEntity(tieMsg,reportingEntity,tieDoc);
		
		//Decompose docSpec
	}


	//Iterate through the entityList to map the entity obj
	private void decomposeEntity(TieMsg tieMsg, CorrectableReportingEntityType reportingEntity, TieDoc tieDoc) {
		// TODO Auto-generated method stub
		
	}

	private DocSpecType composeDocSpec(ObjectFactory objFactory, TieMsg tieMsg, TieDoc doc) {
		// TODO Auto-generated method stub
		// 1. Need how many element?
		DocSpecType retval = new DocSpecType();
		retval = objFactory.createDocSpecType();
		// Set DocType
		int docTypeId = doc.getTieDocTypeId();
		TieDocType tieDocType = new TieDocType();
		String docTypeString = tieDocType.findDocTypeById(docTypeId);
		// Set OECDDocType
		retval.setDocTypeIndic(OECDDocTypeIndicEnumType.fromValue(docTypeString));
		// Set docRefId, i.e.,sender Id
		String senderId = new Integer(tieMsg.getSenderId()).toString();
		retval.setDocRefId(senderId);

		// **********Made blank space as default value here***********
		// CorrMsgRefId
		retval.setCorrMessageRefId(" ");
		// CorrDocRefId
		retval.setCorrDocRefId(" ");
		// 2. Populate all its attributes and simple sub element

		// 3. Compose all child sub elements
		return retval;
	}

	private OrganisationPartyType composeEntity(ObjectFactory objFactory, TieMsg tieMsg, TieDoc doc) {
		// TODO Auto-generated method stub
		// 1. Need how many element?

		// 2. Populate all its attributes and simple sub element
		OrganisationPartyType retval = new OrganisationPartyType();
		retval = objFactory.createOrganisationPartyType();

		// 3. Compose all child sub elements
		// Set ResCountyCode
		if (tieMsg.getReceivingCountries() != null) {
			List<CountryCodeType> receivingCounty = retval.getResCountryCode();// messageSpecType.getReceivingCountry();
			String recivingCountryString = tieMsg.getReceivingCountries();
			String[] recivingCountryList = recivingCountryString.split("\\s*,\\s*");
			for (String country : recivingCountryList) {
				receivingCounty.add(CountryCodeType.fromValue(country));
			}
		}
		// Set tax Entity
		// Set TIN
		TINType TIN = objFactory.createTINType();
		// TODO:fix this
		String tin = "xyz";
		if (tin != null) {
			TIN.setValue(tin);
			retval.setTIN(TIN);
		}

		// Set tax EntityList
		for (TieTaxEntity taxEntity : doc.getTaxEntityList()) {
			OrganisationINType IN = objFactory.createOrganisationINType();
			String in = taxEntity.getTaxIdNum();
			if (in != null) {
				IN.setValue(in);
				retval.getIN().add(IN);

				NameOrganisationType name = objFactory.createNameOrganisationType();
				name.setValue(taxEntity.getName());
				retval.getName().add(name);
				// address left black here
				AddressType address = objFactory.createAddressType();
			}
		}
		return retval;
	}

	// Receiving countries should be a list
	private void composeReceivingCountry(TieMsg tieMsg, MessageSpecType messageSpecType) {
		// TODO Auto-generated method stub
		if (tieMsg.getReceivingCountries() != null) {
			List<CountryCodeType> receivingCounty = messageSpecType.getReceivingCountry();
			String recivingCountryString = tieMsg.getReceivingCountries();
			String[] recivingCountryList = recivingCountryString.split("\\s*,\\s*");
			for (String country : recivingCountryList) {
				receivingCounty.add(CountryCodeType.fromValue(country));
			}
		}
	}

	private void decomposeReceivingCountry(TieMsg tieMsg, MessageSpecType messageSpecType) {
		if (messageSpecType.getReceivingCountry() != null) {
			List<CountryCodeType> receivingCounty = messageSpecType.getReceivingCountry();
			int receivingCountyListSize = receivingCounty.size();
			int index = 0;
			StringBuilder receivingCountyString = new StringBuilder();
			while (index < receivingCountyListSize) {
				receivingCountyString.append(receivingCounty.get(index).toString());
				if (index < receivingCountyListSize - 1) {
					receivingCountyString.append(",");
				}
				index++;
			}
			String receivingCountry = receivingCountyString.toString();
			tieMsg.setReceivingCountries(receivingCountry);
		}
	}

	public CountryCodeType handleCountryCode(String country) {
		CountryCodeType countryCodeType = CountryCodeType.fromValue(country);
		return countryCodeType;
	}

	public static boolean validateXMLSchema(String xsdPath, String xmlPath) {
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(xsdPath));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(xmlPath)));
		} catch (IOException e) {
			System.out.println("Exception: " + e.getMessage());
			return false;
		} catch (SAXException e1) {
			System.out.println("SAX Exception: " + e1.getMessage());
			return false;
		}
		return true;
	}
}

// Marshaller marshaller = context.createMarshaller();
// marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
// marshaller.marshal(cbcoecd, System.out);
// marshaller.marshal(cbcoecd, file);

// *****Validation*****
// boolean valid = validateXMLSchema("src/main/xsd/complex.xsd",
// "src/main/xml/file.xml");
// System.out.println();
// System.out.println("========Validation result========");
// System.out.println(valid);