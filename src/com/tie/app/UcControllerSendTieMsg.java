package com.tie.app;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tie.app.cts.ICtsException;
import com.tie.app.cts.TieCtsStub;
import com.tie.dao.TiePersister;
import com.tie.model.TieMsg;
import com.tie.model.TieMsgEnvelope;
import com.tie.model.TieMsgPackage;
import com.tie.model.TieMsgState;
import com.tie.model.TieMsgTrackingLog;
import com.tie.model.TieMsgTrackingStatus;
import com.tie.model.TieUser;
import com.tie.ui.TieMainPage;
import com.tie.xmlprocessor.cbcrxmlprocessor.CbcrXmlProcessor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UcControllerSendTieMsg extends TieControllerBase {
	final Logger logger = LoggerFactory.getLogger(TaxDocParser.class);
	TieSessionController sessionController;
	HttpServletRequest request;
	HttpServletResponse response;
	private Map<Long, TieMsgPackage> msgPackages;

	// public UcControllerSendTieMsg(TieSessionController sessionController,
	// HttpServletRequest request, HttpServletResponse response) {
	//
	// }

	public UcControllerSendTieMsg(TieSessionController sessionController, HttpServletRequest request,
			HttpServletResponse response) {
		this.sessionController = sessionController;
		this.request = request;
		this.response = response;
	}

	public void sendTieMsg(long msgId) throws JAXBException, InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
		// List<TieMsgPackage> packageList = prepareTieMsg(msgId);
		TieMsg preparedTieMsg = prepareTieMsg(msgId);

		try {
			// For CTS demo only, manually set a bad request

			TieCtsStub tieCtsStub = new TieCtsStub();
			tieCtsStub.sendTieMsg(preparedTieMsg);
			String msgString = "";
			TieMsgState tieMsgState = new TieMsgState(2, "name", msgString, "", "");
			recordMsgState(preparedTieMsg, msgString, tieMsgState);
			//recordAllPackageStatus(preparedTieMsg);

			// Record sending as success
		} catch (Exception e) {
			// Record sending as fail
			System.out.println(e.toString());
			e.printStackTrace();
			String msgString = "";
			TieMsgState tieMsgState = new TieMsgState(6, "name", msgString, "", "");
			// Need to handle error status, but could only send the errorUI body
			recordMsgState(preparedTieMsg, msgString, tieMsgState);
		}
		// forwardToFront();
	}// sendTieMsg(.)

	private void recordAllPackageStatus(TieMsg tieMsg) throws ICtsException {
		// TODO Auto-generated method stub

		System.out.println("Started to record sending status!");
		Map<Long, TieMsgPackage> msgPackagesMap = tieMsg.getMsgPackages();
		for (Object Key : msgPackagesMap.keySet()) {

			TieMsgPackage tieMsgPackage = msgPackagesMap.get(Key);
			try {
				String msgString = "";
				// Create TieMsgTrackingStatus log at package level
				TieMsgTrackingStatus trkStatus = new TieMsgTrackingStatus();
				// Record message status at package level
				recordPackageStatus(tieMsgPackage, msgString, trkStatus);
			} catch (Exception e) {
				throw new ICtsException(tieMsgPackage.getSingleRecipient() + " - ");
			}
		}
	}

	// Create a dialog box at front end showing the message sending status
	private void createFrontEndDialog() {
		// TODO Auto-generated method stub

	}

	// prepare one blank package for each intended recipient.
	// Logic going through initPackages inside tieMsg class
	// public List<TieMsgPackage> prepareTieMsg(long msgId)
	public TieMsg prepareTieMsg(long msgId) throws JAXBException, InvalidKeyException, IllegalBlockSizeException,
			BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException, IOException {
		logger.debug("Message to be sent with ID {}.", msgId);

		// Build TIE message
		TieMsg tieMsg = buildTieMsg(msgId);
		// Process XML
		String xmlString = composeTieMsg(tieMsg);
		// loop through the recipient list to create a blank package list
		tieMsg = prepareTieMsgPackage(tieMsg);
		Map<Long, TieMsgPackage> msgPackagesMap = tieMsg.getMsgPackages();
		// loop through packageList to generate each indivial package
		for (Object Key : msgPackagesMap.keySet()) {
			TieMsgPackage tieMsgPackage = msgPackagesMap.get(Key);
			tieMsgPackage.setPayload(xmlString);
			tieMsgPackage.setPayloadEncrypted(encryptMsgBody(xmlString, tieMsgPackage));
			// compose Envelop
			composeMsgEnvelop(tieMsgPackage);
		}
		return tieMsg;
	}// prepareTieMsg(.)

	// loop through the recipient list to create a blank package list
	public TieMsg prepareTieMsgPackage(TieMsg tieMsg) {
		// List<TieMsgPackage> retval = new ArrayList<TieMsgPackage>();
		// start a blank package for each recipient
		tieMsg.initPackages();
		Map<Long, TieMsgPackage> msgPackagesMap = tieMsg.getMsgPackages();
		for (Object Key : msgPackagesMap.keySet()) {
			System.out.println("Handle package with key: " + Key);
			TieMsgPackage tieMsgPackage = msgPackagesMap.get(Key);
			tieMsgPackage.setTiemsg(tieMsg);
			// retval.add(tieMsgPackage);
		}
		return tieMsg;

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
	 * Delegate to the main persister, to read all records, by invoking
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

	// Set msgEnvelop (byte[]) to TieMsgPackage object
	public void composeMsgEnvelop(TieMsgPackage msgPkg) throws IOException {
		// TODO: recipient String
		String recipientString = msgPkg.getSingleRecipient();
		TieMsgEnvelope tieMsgEnvelope = createEnvelopeForPackage(recipientString, msgPkg);
		byte[] envelopeByte = byteEnvelope(tieMsgEnvelope);
		System.out.println("tieMsgEnvelope in byte: " + Arrays.toString(envelopeByte));
		msgPkg.setPackageBytes(envelopeByte);
	}// end composeMsgEnvelop(.)

	public TieMsgEnvelope createEnvelopeForPackage(String recipient, TieMsgPackage msgPkg) {
		TieMsgEnvelope tieMsgEnvelope = new TieMsgEnvelope();
		TiePersister persister = TieController.getController().getPersister();
		// Set tieMsgEnvelope properties

		// Set Sender
		int senderId = msgPkg.getTiemsg().getSenderId();
		TieUser sender = persister.getTieUserDao().findTieUserById(senderId);
		tieMsgEnvelope.setSender(sender);

		// Set Receiver
		String[] recipientString = recipient.split("@", -1);
		String userCode = recipientString[0];
		TieUser receiver = persister.getTieUserDao().findTieUserByCode(userCode);
		tieMsgEnvelope.setReceiver(receiver);

		// Set Time
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		tieMsgEnvelope.setSendTime(timeStamp);

		return tieMsgEnvelope;
	};// end createEnvelopeForPackage(..)

	// convert TieMsgEnvelope into Byte[]
	public byte[] byteEnvelope(TieMsgEnvelope tieMsgEnvelope) throws IOException {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream os = new ObjectOutputStream(out);
		System.out.println("tieMsgEnvelope: " + tieMsgEnvelope.toString());
		os.writeObject(tieMsgEnvelope);
		return out.toByteArray();
		// return null;
	}

	// byte to obj
	public Object deserialize(byte[] data) throws IOException, ClassNotFoundException {
		ByteArrayInputStream in = new ByteArrayInputStream(data);
		ObjectInputStream is = new ObjectInputStream(in);
		return is.readObject();
	}

	// Track the message status
	public void recordPackageStatus(TieMsgPackage msgPkg, String msg, TieMsgTrackingStatus trkStatus) {
		TieMsgTrackingLog tieMsgTrackingLog = new TieMsgTrackingLog();
		String TRACKING_NOTE = "Tracking note at current package.";
		String CTS_TRACKING_ID = "ctsId";
		tieMsgTrackingLog.setCtsTrackingId(CTS_TRACKING_ID);
		tieMsgTrackingLog.setReceiverCode(msgPkg.getSingleRecipient());
		tieMsgTrackingLog.setReceivingCountry(msgPkg.getSingleRecipient());
		// tieMsgTrackingLog.setSenderCode(msgPkg.getTiemsg().getSender().getCode());
		tieMsgTrackingLog.setSenderCode(msgPkg.getSingleRecipient());
		tieMsgTrackingLog.setTieMsgId(msgPkg.getTiemsg().getTieMsgId());
		tieMsgTrackingLog.setTieMsgTrackingStatusId(2);
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new java.util.Date());
		tieMsgTrackingLog.setTimeStamp(timeStamp);
		tieMsgTrackingLog.setTrackingNote(TRACKING_NOTE);
		TiePersister persister = TieController.getController().getPersister();
		persister.getTieMsgTrackingLogDao().updateTieMsgTrackingLog(tieMsgTrackingLog);
		// Call persister to save the message status

	}

	// Update the message status at the message level
	// If all are successful, then the msg state is set to "Send".
	// If any pkg is error, then "Error".
	public void recordMsgState(TieMsg tieMsg, String msg, TieMsgState msgState) throws IOException {
		// Update in the database
		TiePersister persister = TieController.getController().getPersister();
		TieMsg retTieMsg = persister.getTieMsgDao().recordTieMsgStatus(tieMsg, msg, msgState);
		TieMainPage.getTieMainPage().setCurrentMsg(retTieMsg);
		// Update the status in the message list
		sessionController.handleMsgList();
		// Forward to the front end
		System.out.println("Message Sent");
		//updateFrontEnd();
	}

	private void updateFrontEnd() throws IOException {
		// TODO Auto-generated method stub

		TieMainPage retval = null;

		retval = TieMainPage.getTieMainPage();

		ObjectMapper ma = new ObjectMapper();
		String sentMsgReturnJson = ma.writeValueAsString(retval);

		System.out.println("saveMsgReturnJson" + sentMsgReturnJson);

		response.setContentType("text/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(sentMsgReturnJson);
	}

}
