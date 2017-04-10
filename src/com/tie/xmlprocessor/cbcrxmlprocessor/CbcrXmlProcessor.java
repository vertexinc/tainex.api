package com.tie.xmlprocessor.cbcrxmlprocessor;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import com.tie.model.TieDoc;
import com.tie.model.TieMsg;
import com.tie.xmlprocessor.cbcrxmlprocessor.cbcrxmljaxb.*;

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
		JAXBContext context = null;
		Marshaller marshaller = context.createMarshaller();
		marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
		marshaller.marshal(cbcoecd, sw);
		retval = sw.toString();
		return retval;
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

		List<CbcBodyType> cbcBodyList = composeCbcBodyList(objFactory, tieMsg);

		// add body list to retval
		// Check documentation in CBCOECD.java, the set func was removed
		// purposely
		for (CbcBodyType CbcBody : cbcBodyList) {
			retval.getCbcBody().add(CbcBody);
		}

		return retval;
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

		String sendingEntityIdNum = tieMsg.getSendingEntityIdNum();
		retval.setSendingEntityIN(sendingEntityIdNum);

		CountryCodeType transmittingCountry = CountryCodeType.fromValue(tieMsg.getTransmittingCountry());
		retval.setTransmittingCountry(transmittingCountry);

		handleReceivingCountry(tieMsg, retval);

		// 2. Populate all its attributes and simple sub element

		// 3. Compose all child sub elements
		// no sub element found

		return retval;
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

		retval = new ArrayList<CbcBodyType>();

		// 2. Populate all its attributes and simple sub element
		// loop over each doc in tie message
		// CbcBodyType cbcBody = composeCbcBody( objFactory, tieMsg, doc )
		// add cbcBody to retval.add( cbcBody )

		// 3. Compose all child sub elements
		// No need for element list

		return retval;
	}

	/**
	 * Compose one CbcBody for the given doc in the message
	 * 
	 * @param objFactory
	 * @param tieMsg
	 * @return
	 */
	private CbcBodyType composeCbcBody(ObjectFactory objFactory, TieMsg tieMsg, DocSpecType doc) {
		CbcBodyType retval = null;

		// 1. Need how many element?

		// 2. Populate all its attributes and simple sub element

		// 3. Compose all child sub elements

		return retval;
	}

	void handleCbcBody(ObjectFactory factory, List<TieDoc> tieDocList) {
		// TODO Auto-generated method stub

	}

	// private void handleMessageSpec(ObjectFactory factory, TieMsg tieMsg) {
	// // TODO Auto-generated method stub
	// CBCOECD cbcoecd = factory.createCBCOECD();
	// cbcoecd.setVersion("1.0");
	// MessageSpecType messageSpecType = new MessageSpecType();
	// messageSpecType.setSendingEntityIN(tieMsg.getSendingEntityIdNum());
	// handleTransmittingCountry(tieMsg, messageSpecType);
	// handleReceivingCountry(tieMsg, messageSpecType);
	// }

	// Receiving countries should be a list
	private void handleReceivingCountry(TieMsg tieMsg, MessageSpecType messageSpecType) {
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

	// TransmittingCountry should be only one country
	private void handleTransmittingCountry(TieMsg tieMsg, MessageSpecType messageSpecType) {
		// TODO Auto-generated method stub
		if (tieMsg.getTransmittingCountry() != null) {
			messageSpecType.setTransmittingCountry(handleCountryCode(tieMsg.getTransmittingCountry()));
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