package com.tie.app;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.xml.bind.JAXBException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tie.dao.TiePersister;
import com.tie.model.TieMsg;
import com.tie.model.TieMsgEnvelope;
import com.tie.model.TieMsgPackage;
import com.tie.model.TieUser;
import com.tie.ui.TieMainPage;
import com.tie.xmlprocessor.cbcrxmlprocessor.CbcrXmlProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UcControllerSendTieMsg extends TieControllerBase {
	final Logger logger = LoggerFactory.getLogger(TaxDocParser.class);
	TieSessionController sessionController;
	private Map<Long, TieMsgPackage> msgPackages;

	public UcControllerSendTieMsg() {

	}

	public UcControllerSendTieMsg(TieSessionController sessionController) {
		this.sessionController = sessionController;
	}

	public void sendTieMsg(long msgId) throws JAXBException, InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
		List<TieMsgPackage> packageList = prepareTieMsg(msgId);
	}// sendTieMsg(.)

	// prepare one blank package for each intended recipient.
	// Logic going through initPackages inside tieMsg class
	public List<TieMsgPackage> prepareTieMsg(long msgId)
			throws JAXBException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
			NoSuchAlgorithmException, NoSuchPaddingException, IOException {
		logger.debug("Message to be sent with ID {}.", msgId);

		// Build TIE message
		TieMsg tieMsg = buildTieMsg(msgId);

		// Process XML
		String xmlString = composeTieMsg(tieMsg);

		// loop through the recipient list to create a blank package list
		List<TieMsgPackage> packageList = prepareTieMsgPackage(tieMsg);

		// loop through packageList to generate each indivial package
		for (TieMsgPackage tieMsgPackage : packageList) {

			tieMsgPackage.setPayload(xmlString);
			tieMsgPackage.setPayloadEncrypted(encryptMsgBody(xmlString, tieMsgPackage));
			
			//compose Envelop
			composeMsgEnvelop(tieMsgPackage);
		}
		

		return packageList;
	}// prepareTieMsg(.)

	// loop through the recipient list to create a blank package list
	public List<TieMsgPackage> prepareTieMsgPackage(TieMsg tieMsg) {
		List<TieMsgPackage> retval = new ArrayList<TieMsgPackage>();
		// start a blank package for each recipient
		tieMsg.initPackages();
		
		Map<Long, TieMsgPackage> msgPackagesMap = tieMsg.getMsgPackages();
		for (Object Key : msgPackagesMap.keySet()) {
			System.out.println("Handle package with key: " + Key);
			TieMsgPackage tieMsgPackage = msgPackagesMap.get(Key);
			tieMsgPackage.setTiemsg(tieMsg);
			retval.add(tieMsgPackage);
		}
		return retval;

	}

	/*
	 * check the type of msg, it is CBCR (the initial target), delegate to the
	 * method specific for composing CBCR msg.
	 */
	public String composeTieMsg(TieMsg tieMsg) throws JAXBException {
		String CbcrMsgPayload = null;
		CbcrMsgPayload = composeCbcrMsg(tieMsg);
		return CbcrMsgPayload;
	}// end composeTieMsg(.)

	public String composeCbcrMsg(TieMsg tieMsg) throws JAXBException {
		CbcrXmlProcessor cbcrXmlProcessor = new CbcrXmlProcessor();
		String xmlString = cbcrXmlProcessor.composeXmlString(tieMsg);
		logger.info("Message built successfully: {}", xmlString);
		cbcrXmlProcessor.validateXML(tieMsg);
		return xmlString;
	}// end composeCbcrMsg(.)

	/*
	 * TODO Delegate to the main persister, to read all records, by invoking
	 * individual table persisters and assemble all the resulting objects
	 * together.
	 */
	public TieMsg buildTieMsg(long msgId) throws JsonProcessingException, JAXBException {
		// TieMsg currMsg = TieMainPage.getTieMainPage().getCurrentMsg();
		TiePersister persister = TieController.getController().getPersister();
		TieMsg tieMsg = persister.buildTieMsg(msgId);
		return tieMsg;
	}// end buildTieMsg(.)

	/*
	 * Encrypt and set the encrypted byte[] into the given package The
	 * encryption will delegate to TieSecurityManager class, which will further
	 * use ICts for key management functionality
	 */
	public byte[] encryptMsgBody(String msgBody, TieMsgPackage tieMsgPkg)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException,
			NoSuchPaddingException, IOException {
		TieSecurityManager tieSecurityManager = new TieSecurityManager();
		byte[] encryptedMsgBody = tieSecurityManager.encryptMsgBody(msgBody, tieMsgPkg);
		return encryptedMsgBody;
	}// end encryptMsgBody(..)

	public Byte[] packageMsg(TieMsgPackage tieMsgPkg) {
		return null;
	}// end packageMsg(.)

	public String sendTaxMsgPackage(TieMsgPackage tieMsgPkg) {
		return null;
	}// end sendTaxMsgPackage(.)

	public boolean recordTaxMsgStatus() {
		return false;
	}// end recordTaxMsgStatus()
	
	//Set msgEnvelop (byte[]) to TieMsgPackage object
	public void composeMsgEnvelop(TieMsgPackage msgPkg) throws IOException{
		//TODO: recipient String
		String recipientString = msgPkg.getSingleRecipient();
		TieMsgEnvelope tieMsgEnvelope = createEnvelopeForPackage(recipientString,msgPkg);
		byte[] envelopeByte = byteEnvelope(tieMsgEnvelope);
		System.out.println("tieMsgEnvelope in byte: " + Arrays.toString(envelopeByte));
		msgPkg.setPackageBytes(envelopeByte);
	}//end composeMsgEnvelop(.)
	
	public TieMsgEnvelope createEnvelopeForPackage( String recipient, TieMsgPackage msgPkg ){
		TieMsgEnvelope tieMsgEnvelope = new TieMsgEnvelope();
		TiePersister persister = TieController.getController().getPersister();
		//Set tieMsgEnvelope properties
		
		//Set Sender
		int senderId = msgPkg.getTiemsg().getSenderId();
		TieUser sender = persister.getTieUserDao().findTieUserById(senderId);
		tieMsgEnvelope.setSender(sender);
		
		//Set Receiver
		String[] recipientString = recipient.split("@", -1);
		String userCode = recipientString[0];
		TieUser receiver = persister.getTieUserDao().findTieUserByCode(userCode);
		tieMsgEnvelope.setReceiver(receiver);
		
		//Set Time
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY,17);
		cal.set(Calendar.MINUTE,30);
		cal.set(Calendar.SECOND,0);
		cal.set(Calendar.MILLISECOND,0);
		Date date = cal.getTime();
		tieMsgEnvelope.setSendTime(date);
		
		return tieMsgEnvelope;		
	};//end createEnvelopeForPackage(..)
	
	//convert TieMsgEnvelope into Byte[]
	//TODO: obj to byte problem
	public byte[] byteEnvelope(TieMsgEnvelope tieMsgEnvelope) throws IOException{
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(out);
		System.out.println("tieMsgEnvelope: " + tieMsgEnvelope.toString());
		os.writeObject(tieMsgEnvelope);	
		return out.toByteArray();
//		return null;
	}
	
	//byte to obj
	public  Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
	    ByteArrayInputStream in = new ByteArrayInputStream(data);
	    ObjectInputStream is = new ObjectInputStream(in);
	    return is.readObject();
	}

}
