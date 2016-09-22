
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
	public void handleLogin(String username) {
		TiePersister persister = TieController.getController().getPersister();

		// -------- populate for header pane --------------
		String appName = persister.getTieAppDao().findTieAppById(1).getName();

		// find the id of the user who's login ()
		TieUser user = persister.getTieUserDao().findTieUserByCode(username);
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
		List<TieMsg> msgList = new ArrayList<TieMsg>();
		msgList = persister.getTieMsgDao().findTieMsgByOwnerId(user.getTieUserId());// (user.getTieUserId());
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
		TieMainPage.getTieMainPage().setTaxEntitylist(taxEntitylist);

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

		TieMainPage.getTieMainPage().setCurrentMsg(tieMsg);
		return tieMsg;
	}// end handleSelectCurrentMsg(.)
	
	public TieDoc handleSelectCurrentDoc(int tieDocId) {
		TiePersister persister = TieController.getController().getPersister();
		TieDoc tieDoc = (TieDoc) persister.getTieDocDao().findTieDocByTieDocId(tieDocId);

		populateDoc(tieDoc);

		//TieMainPage.getTieMainPage().setCurrentMsg(tieMsg);
		return tieDoc;
	}// end handleSelectCurrentMsg(.)

	/**
	 * Populate all elements of the given message from the given object,
	 * including its entities, docs, etc
	 * 
	 * @param tieMsg
	 */
	private void populateMsg(TieMsg tieMsg) {
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

	}// end populateMsg(.)
	private void populateDoc(TieDoc tieDoc) {
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

}// end class TieSessionContrller
