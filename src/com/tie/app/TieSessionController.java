
package com.tie.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tie.dao.TiePersister;
import com.tie.model.CbcrTable1;
import com.tie.model.CbcrTable2;
import com.tie.model.CbcrTable3;
import com.tie.model.TieDoc;
import com.tie.model.TieMsg;
import com.tie.model.TieMsgReceiver;
import com.tie.model.TieMsgState;
import com.tie.model.TieUser;
import com.tie.model.TieTaxEntity;
import com.tie.ui.Header;
import com.tie.ui.TieMainPage;

/**
 * @author awang Respond to requests from one user session
 */
public class TieSessionController extends TieControllerBase {

	private String userCode;
	// point to ui class

	// TieMainPage mainPage;
	// TiePersister persister = null;

	// The key to access session controller
	public static String sesssionControllerName = "theSessionController";
	public TieUser currUser;
	public List<TieMsg> msgList = new ArrayList<TieMsg>();

	public void init() {

	}

	public TieSessionController() {
		init();
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}
	/*
	 * public TieMainPage getMainPage() { return mainPage; }
	 * 
	 * public void setMainPage(TieMainPage mainPage) { this.mainPage = mainPage;
	 * }
	 */

	// populate the mainPage's every object
	// get the persister first
	// from the persister get the Dao and invoke method insides it to populate
	/* over to mainPage */
	// everything in one time
	public void handleMsgList() {
		TiePersister persister = TieController.getController().getPersister();
		List<TieMsg> msgList = new ArrayList<TieMsg>();
		msgList = persister.getTieMsgDao().findTieMsgByOwnerId(currUser.getTieUserId());// (user.getTieUserId());
		for (TieMsg msg : msgList) {
			int msgId = msg.getTieMsgId();
			int senderId = msg.getSenderId();
			int statusId = msg.getTieMsgStateId();
			TieMsgState tieMsgState = TieMsgState.findById(statusId);
			String msgState = tieMsgState.getName();
			TieUser sender = persister.getTieUserDao().findTieUserById(senderId);
			String userName = sender.getName();
			List<TieMsgReceiver> tiemsgReceiverList = new ArrayList<TieMsgReceiver>();
			tiemsgReceiverList = persister.getTieMsgReceiverDao().findTieMsgReceiverById(msgId);

			// Populate toListString
			StringBuilder toListString = new StringBuilder("");
			for (TieMsgReceiver tieMsgReceiver : tiemsgReceiverList) {
				toListString.append(tieMsgReceiver.getSenderCode()).append("@")
						.append(tieMsgReceiver.getReceivingCountry()).append(";");
			}
			msg.setMsgReceiverList(toListString.toString());
			msg.setSender(sender);
			msg.setTieMsgState(tieMsgState);
			msg.setUserName(userName);
			msg.setMsgState(msgState);
		}

		TieMainPage.getTieMainPage().setMsgList(msgList);
	}

	public void handleLogin(String username) {
		TiePersister persister = TieController.getController().getPersister();

		// -------- populate for header pane --------------
		String appName = persister.getTieAppDao().findTieAppById(1).getName();

		// find the id of the user who's login ()
		TieUser user = persister.getTieUserDao().findTieUserByCode(username);
		currUser = user;
		// System.out.println("User:" + user.toString());
		String userNameOnBoard = user.getName();

		getMainPage().setAppName(appName);
		TieMainPage.getTieMainPage().setAppName(appName);
		TieMainPage.getTieMainPage().setUsername(userNameOnBoard);

		// TODO language and language list

		// ToDo List<TieMsg> TieMsgDao.findMessageBsyOwner( long ownerId )
		// ToDo add findTieMsgById in tieMsgDao
		// msgList = persister.getTieMsgDao().findTieMsgByCode(code);
		// TieMainPage.getTieMainPage().setMsgList(msgList);

		// ------- populate for msg pane --------
		// List<TieMsg> msgList = new ArrayList<TieMsg>();
		msgList = persister.getTieMsgDao().findTieMsgByOwnerId(user.getTieUserId());// (user.getTieUserId());
		for (TieMsg msg : msgList) {
			int msgId = msg.getTieMsgId();
			int senderId = msg.getSenderId();
			int statusId = msg.getTieMsgStateId();

			// int currentDocId = msg.getTieDocList().get(0).getTieDocId();

			// List<TieTaxEntity> taxEntitylist = new ArrayList<TieTaxEntity>();
			// taxEntitylist =
			// persister.getTieEntityDao().findTieEntityByTieDocId(currentDocId);
			// TieMainPage.getTieMainPage().setTaxEntitylist(taxEntitylist);

			TieMsgState tieMsgState = TieMsgState.findById(statusId);
			String msgState = tieMsgState.getName();
			TieUser sender = persister.getTieUserDao().findTieUserById(senderId);
			String userName = sender.getName();
			List<TieMsgReceiver> tiemsgReceiverList = new ArrayList<TieMsgReceiver>();
			tiemsgReceiverList = persister.getTieMsgReceiverDao().findTieMsgReceiverById(msgId);

			// Populate toListString
			StringBuilder toListString = new StringBuilder("");
			for (TieMsgReceiver tieMsgReceiver : tiemsgReceiverList) {
				toListString.append(tieMsgReceiver.getSenderCode()).append("@")
						.append(tieMsgReceiver.getReceivingCountry()).append(";");
			}
			msg.setMsgReceiverList(toListString.toString());
			msg.setSender(sender);
			msg.setTieMsgState(tieMsgState);
			msg.setUserName(userName);
			msg.setMsgState(msgState);
		}

		TieMainPage.getTieMainPage().setMsgList(msgList);

		// TODO
		// ------ populate current msg pane, msg tab -------
		// pick the first msg from msgList as the current msg
		// currentMsg =
		// all current msg attributes are now available to jsp
		TieMsg currentmsg = msgList.get(0);
		// TieMainPage.getTieMainPage().setCurrentMsg(currentmsg);
		TieMainPage.getTieMainPage().setCurrentMsg(currentmsg);
		// Populate sender of the current msg
		int senderId = currentmsg.getSenderId();

		TieUser sender = persister.getTieUserDao().findTieUserById(senderId);
		currentmsg.setSender(sender);
		// Populate receivers of the current msg
		int currentTieMsgId = currentmsg.getTieMsgId();
		List<TieMsgReceiver> tiemsgReceiverList = new ArrayList<TieMsgReceiver>();
		tiemsgReceiverList = persister.getTieMsgReceiverDao().findTieMsgReceiverById(currentTieMsgId);
		TieMainPage.getTieMainPage().setTiemsgReceiverList(tiemsgReceiverList);

		// Populate toListString
		StringBuilder toListString = new StringBuilder("");
		for (TieMsgReceiver tieMsgReceiver : tiemsgReceiverList) {
			toListString.append(tieMsgReceiver.getSenderCode()).append("@").append(tieMsgReceiver.getReceivingCountry())
					.append(";");
		}
		TieMainPage.getTieMainPage().setToListString(toListString.toString());
		// Populate the state of current msg
		TieMsgState tieMsgState = TieMsgState.findById(currentmsg.getTieMsgStateId());
		TieMainPage.getTieMainPage().setTieMsgState(tieMsgState);

		// ------ populate current msg pane, doc tab, docs of the currentMsg
		List<TieDoc> tieDocList = new ArrayList<TieDoc>();
		tieDocList = persister.getTieDocDao().findTieDocByTieMsgId(currentTieMsgId);
		TieMainPage.getTieMainPage().setTieDocList(tieDocList);
		currentmsg.setTieDocList(tieDocList);

		// populate current doc
		// TODO: Handle current doc situation
		TieDoc currentDoc = tieDocList.get(0);
		TieMainPage.getTieMainPage().setCurrentTieDoc(currentDoc);

		// TODO: Populate reporting entity object (findbyCode)
		TieTaxEntity tieTaxEntity = new TieTaxEntity();
		tieTaxEntity = persister.getTieEntityDao().findTieEntityByCode(currentDoc.getReportingEntityCode());
		currentDoc.setReportingEntity(tieTaxEntity);

		// ------ populate current msg pane, entity tab -------
		int currentDocId = currentDoc.getTieDocId();
		List<TieTaxEntity> taxEntitylist = new ArrayList<TieTaxEntity>();
		taxEntitylist = persister.getTieEntityDao().findTieEntityByTieDocId(currentDocId);
		currentDoc.setTaxEntityList(taxEntitylist);

		// ------ populate current msg pane, table1 tab -------
		List<CbcrTable1> cbcrTable1List = persister.getCbcrTable1Dao().findCbcrTable1ByTieDocId(currentDocId);
		currentDoc.setCbcrTable1List(cbcrTable1List);

		// ------ populate current msg pane, table2 tab -------
		List<CbcrTable2> cbcrTable2List = persister.getCbcrTable2Dao().findCbcrTable2ByTieDocId(currentDocId);
		currentDoc.setCbcrTable2List(cbcrTable2List);
		// ------ populate current msg pane, table3 tab -------
		List<CbcrTable3> cbcrTable3List = persister.getCbcrTable3Dao().findCbcrTable3ByTieDocId(currentDocId);
		currentDoc.setCbcrTable3List(cbcrTable3List);

		StringBuilder table3String = new StringBuilder("");
		for (CbcrTable3 cbcrTable3 : cbcrTable3List) {
			table3String.append(cbcrTable3.getAdditionalInfo()).append(";").append("\n");
		}
		TieMainPage.getTieMainPage().setTable3String(table3String.toString());

	}// end handleLogin()

	/**
	 * 
	 * @return The main page for the user session.
	 */
	public TieMainPage getMainPage() {
		TieMainPage retval = null;

		retval = TieMainPage.getTieMainPage();

		return retval;
	}// end getMainPage()

	/*
	 * Init object when user first login
	 */
	public Header initMainPage() {
		Header header = new Header();
		header.setAppName(TieMainPage.getTieMainPage().getAppName());
		header.setUserName(TieMainPage.getTieMainPage().getUsername());
		ArrayList<String> language = new ArrayList<String>();
		language.add("en");
		language.add("zh");
		language.add("es");
		language.add("fr");
		header.setLanguage(language);
		return header;
	}

	/**
	 * Select the msg object for the given id. Set it to the main page as the
	 * current msg object.
	 * 
	 * @param msgId
	 * @return
	 */
	public TieMsg handleSelectCurrentMsg(int msgId) {
		TiePersister persister = TieController.getController().getPersister();
		TieMsg tieMsg = persister.getTieMsgDao().findTieMsgByTieMsgId(msgId);

		populateMsg(tieMsg);
		int senderId = tieMsg.getSenderId();
		int statusId = tieMsg.getTieMsgStateId();
		TieMsgState tieMsgState = TieMsgState.findById(statusId);
		String msgState = tieMsgState.getName();
		TieUser sender = persister.getTieUserDao().findTieUserById(senderId);
		String userName = sender.getName();
		tieMsg.setUserName(userName);
		tieMsg.setMsgState(msgState);
		if (!tieMsg.getTieDocList().isEmpty()) {
			int currenttieDocId = tieMsg.getTieDocList().get(0).getTieDocId();
			handleSelectCurrentDoc(currenttieDocId);
		}else{
			TieMainPage.getTieMainPage().setCurrentTieDoc(null);
		}
		TieMainPage.getTieMainPage().setCurrentMsg(tieMsg);

		return tieMsg;
	}// end handleSelectCurrentMsg(.)0

	public TieDoc handleSelectCurrentDoc(int tieDocId) {
		TiePersister persister = TieController.getController().getPersister();
		TieDoc tieDoc = (TieDoc) persister.getTieDocDao().findTieDocByTieDocId(tieDocId);

		populateDoc(tieDoc);
		TieMainPage.getTieMainPage().setCurrentTieDoc(tieDoc);
		// TieMainPage.getTieMainPage().setCurrentMsg(tieMsg);
		return tieDoc;
	}// end handleSelectCurrentDoc(.)

	/**
	 * Populate all elements of the given message from the given object,
	 * including its entities, docs, etc
	 * 
	 * @param tieMsg
	 */
	public void populateMsg(TieMsg tieMsg) {
		if (tieMsg == null)
			return;

		TieMsg currentmsg = tieMsg;
		TiePersister persister = TieController.getController().getPersister();

		// Populate sender
		int senderId = currentmsg.getSenderId();
		TieUser sender = persister.getTieUserDao().findTieUserById(senderId);
		currentmsg.setSender(sender);

		// Populate receivers of the current msg
		int currentTieMsgId = currentmsg.getTieMsgId();
		List<TieMsgReceiver> tiemsgReceiverList = new ArrayList<TieMsgReceiver>();
		tiemsgReceiverList = persister.getTieMsgReceiverDao().findTieMsgReceiverById(currentTieMsgId);
		StringBuilder toListString = new StringBuilder("");
		for (TieMsgReceiver tieMsgReceiver : tiemsgReceiverList) {
			toListString.append(tieMsgReceiver.getSenderCode()).append("@").append(tieMsgReceiver.getReceivingCountry())
					.append(";");
		}
		currentmsg.setMsgReceiverList(toListString.toString());

		// Populate the state of current msg
		TieMsgState tieMsgState = TieMsgState.findById(currentmsg.getTieMsgStateId());
		currentmsg.setTieMsgState(tieMsgState);

		// populate current msg pane, doc tab, docs of the currentMsg
		List<TieDoc> tieDocList = new ArrayList<TieDoc>();
		tieDocList = persister.getTieDocDao().findTieDocByTieMsgId(currentTieMsgId);
		if (!tieDocList.isEmpty()) {
			currentmsg.setTieDocList(tieDocList);

			// populate current doc
			// Handle current doc situation

			// CurrentDoc Problem - > we only set the first doc as currentDoc

			TieDoc currentDoc = tieDocList.get(0);

			// Populate reporting entity object (findbyCode) TieTaxEntity
			int currentDocId = currentDoc.getTieDocId();
			TieTaxEntity tieTaxEntity = new TieTaxEntity();
			tieTaxEntity = persister.getTieEntityDao().findTieEntityByCode(currentDoc.getReportingEntityCode());
			currentDoc.setReportingEntity(tieTaxEntity);

			// populate current msg pane, entity tab----
			currentDocId = currentDoc.getTieDocId();
			List<TieTaxEntity> taxEntitylist = new ArrayList<TieTaxEntity>();
			taxEntitylist = persister.getTieEntityDao().findTieEntityByTieDocId(currentDocId);
			currentDoc.setTaxEntityList(taxEntitylist);

			// populate current msg pane, table1 tab -------
			List<CbcrTable1> cbcrTable1List = persister.getCbcrTable1Dao().findCbcrTable1ByTieDocId(currentDocId);
			currentDoc.setCbcrTable1List(cbcrTable1List);

			// populate current msg pane, table2 tab -------
			List<CbcrTable2> cbcrTable2List = persister.getCbcrTable2Dao().findCbcrTable2ByTieDocId(currentDocId);
			currentDoc.setCbcrTable2List(cbcrTable2List);

			// populate current msg pane, table3 tab -------
			List<CbcrTable3> cbcrTable3List = persister.getCbcrTable3Dao().findCbcrTable3ByTieDocId(currentDocId);
			currentDoc.setCbcrTable3List(cbcrTable3List);

			StringBuilder table3String = new StringBuilder("");
			for (CbcrTable3 cbcrTable3 : cbcrTable3List) {
				table3String.append(cbcrTable3.getAdditionalInfo()).append(";").append("\n");
			}
			currentDoc.setTable3String(table3String.toString());
		} else {

			TieDoc currentDoc = new TieDoc();
		}
	}// end populateMsg(.)

	public void populateDoc(TieDoc tieDoc) {
		if (tieDoc == null)
			return;

		TieDoc currentDoc = tieDoc;
		TiePersister persister = TieController.getController().getPersister();

		// Populate reporting entity object (findbyCode) TieTaxEntity
		int currentDocId = currentDoc.getTieDocId();
		TieTaxEntity tieTaxEntity = new TieTaxEntity();
		tieTaxEntity = persister.getTieEntityDao().findTieEntityByCode(currentDoc.getReportingEntityCode());
		currentDoc.setReportingEntity(tieTaxEntity);

		// populate current msg pane, entity tab----
		currentDocId = currentDoc.getTieDocId();
		List<TieTaxEntity> taxEntitylist = new ArrayList<TieTaxEntity>();
		taxEntitylist = persister.getTieEntityDao().findTieEntityByTieDocId(currentDocId);
		currentDoc.setTaxEntityList(taxEntitylist);

		// populate current msg pane, table1 tab -------
		List<CbcrTable1> cbcrTable1List = persister.getCbcrTable1Dao().findCbcrTable1ByTieDocId(currentDocId);
		currentDoc.setCbcrTable1List(cbcrTable1List);

		// populate current msg pane, table2 tab -------
		List<CbcrTable2> cbcrTable2List = persister.getCbcrTable2Dao().findCbcrTable2ByTieDocId(currentDocId);
		currentDoc.setCbcrTable2List(cbcrTable2List);

		// populate current msg pane, table3 tab -------
		List<CbcrTable3> cbcrTable3List = persister.getCbcrTable3Dao().findCbcrTable3ByTieDocId(currentDocId);
		currentDoc.setCbcrTable3List(cbcrTable3List);

		StringBuilder table3String = new StringBuilder("");
		for (CbcrTable3 cbcrTable3 : cbcrTable3List) {
			table3String.append(cbcrTable3.getAdditionalInfo()).append(";").append("\n");
		}
		currentDoc.setTable3String(table3String.toString());

	}// end populateDoc(.)

	public TieMsg handleSaveMessage(TieMsg msg, String sessionId) {
		TiePersister persister = TieController.getController().getPersister();
		return persister.getTieMsgDao().saveTieMessage(msg, sessionId);

	}

	public TieDoc handleAttachDoc(String tieDocString, TieMsg currentMsg, String sessionId) {
		TieDoc returnDoc = new TieDoc();

		CbcrTable1 returnTable1 = new CbcrTable1();
		CbcrTable2 returnTable2 = new CbcrTable2();
		CbcrTable3 returnTable3 = new CbcrTable3();

		TaxDocParser taxDocParser = new TaxDocParser();
		// Attache the doc to the current selected message
		int currentMsgId = TieMainPage.getTieMainPage().getCurrentMsg().getTieMsgId();

		TieDoc parsedDoc = taxDocParser.parse(tieDocString, currentMsg);
		TiePersister persister = TieController.getController().getPersister();

		returnDoc = persister.getTieDocDao().saveAttachedDoc(parsedDoc, sessionId, currentMsgId);
		List<TieTaxEntity> returnTaxEntityList = persister.getTieEntityDao().saveAttachedDocEntity(parsedDoc,
				returnDoc.getTieDocId());
		List<CbcrTable1> returnCbcrTable1 = persister.getCbcrTable1Dao().saveAttachedCbcrTable1(parsedDoc,
				returnDoc.getTieDocId());
		List<CbcrTable2> returnCbcrTable2 = persister.getCbcrTable2Dao().saveAttachedCbcrTable2(parsedDoc,
				returnDoc.getTieDocId());
		List<CbcrTable3> returnCbcrTable3 = persister.getCbcrTable3Dao().saveAttachedCbcrTable3(parsedDoc,
				returnDoc.getTieDocId());

		returnDoc.setTaxEntityList(returnTaxEntityList);
		returnDoc.setCbcrTable1List(returnCbcrTable1);
		returnDoc.setCbcrTable2List(returnCbcrTable2);
		returnDoc.setCbcrTable3List(returnCbcrTable3);

		currentMsg.getTieDocList().add(returnDoc);
		System.out.println("What would return in currentTieMessage from tieMainPage : " + returnDoc.toString());
		TieMainPage.getTieMainPage().setCurrentTieDoc(returnDoc);
		return returnDoc;
	}

	public void handleDetachDoc(List<String> docIdListArray) {
		TiePersister persister = TieController.getController().getPersister();
		for (String idString : docIdListArray) {
			int docId = Integer.parseInt(String.valueOf(idString));
			persister.getTieEntityDao().deleteEntityByDocId(docId);
			persister.getCbcrTable1Dao().deleteCbcrTable1ByDocId(docId);
			persister.getCbcrTable2Dao().deleteCbcrTable2ByDocId(docId);
			persister.getCbcrTable3Dao().deleteCbcrTable3ByDocId(docId);
			persister.getTieDocDao().deleteTieDocDocId(docId);
		}
		int currentTieMsgId = TieMainPage.getTieMainPage().getCurrentMsg().getTieMsgId();
		// TieMsg currentMsg =
		// persister.getTieMsgDao().findTieMsgByTieMsgId(currentTieMsgId);
		TieMainPage.getTieMainPage().setCurrentMsg(handleSelectCurrentMsg(currentTieMsgId));
		// TODO Auto-generated method stub
		// handleSelectCurrentMsg(currentTieMsgId);
		List<TieDoc> tieDocList = new ArrayList<TieDoc>();
		tieDocList = persister.getTieDocDao().findTieDocByTieMsgId(currentTieMsgId);
		if (!tieDocList.isEmpty()) {
			int currentDocId = tieDocList.get(0).getTieDocId();
			handleSelectCurrentDoc(currentDocId);
		}else{
			TieMainPage.getTieMainPage().setCurrentTieDoc(null);
		}
	}

	public void handleDeleteMsg(int messageId) {
		// TODO Auto-generated method stub
		TiePersister persister = TieController.getController().getPersister();

		// 1 get the doc list of currentMessage
		List<TieDoc> docListOfCurrentMessage = persister.getTieDocDao().findTieDocByTieMsgId(messageId);
		List<String> docIdListArray = new ArrayList<String>();
		for (TieDoc tieDoc : docListOfCurrentMessage) {
			docIdListArray.add(Integer.toString(tieDoc.getTieDocId()));
		}

		// 2 call handleDetachDoc to delete all docs from the currentMessage
		handleDetachDoc(docIdListArray);

		// 3 delete current message
		persister.getTieMsgDao().deleteMessageById(messageId);
		handleMsgList();

		// 4 Reset current message
		int currentMsgId = msgList.get(0).getTieMsgId();
		handleSelectCurrentMsg(currentMsgId);

		// 5 Reset current doc
		List<TieDoc> tieDocList = new ArrayList<TieDoc>();
		tieDocList = persister.getTieDocDao().findTieDocByTieMsgId(currentMsgId);
		int currentDocId = tieDocList.get(0).getTieDocId();
		handleSelectCurrentDoc(currentDocId);
	}

}// end class TieSessionContrller
