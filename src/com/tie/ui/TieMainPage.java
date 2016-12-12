/**
 * 
 */
package com.tie.ui;

import java.util.ArrayList;
import java.util.List;

import com.tie.model.CbcrTable1;
import com.tie.model.CbcrTable2;
import com.tie.model.TieDoc;
import com.tie.model.TieMsg;
import com.tie.model.TieMsgReceiver;
import com.tie.model.TieMsgState;
import com.tie.model.TieTaxEntity;

/**
 * @author awang
 *
 */
public class TieMainPage {
	private String appName;
	private String username;
	//supported language list each is a String 
	private List<String> language = new ArrayList<String>();
	private SelectionCriteria selectionCriteria;
	//Dont make it static, the 2nd user login will see the override values
	private static TieMainPage tieMainPage = new TieMainPage();
	//list of all the msg
	public List<TieMsg> msgList = new ArrayList<TieMsg>();
	public List<TieMsgReceiver> tiemsgReceiverList = new ArrayList<TieMsgReceiver>();
	public TieMsgState tieMsgState = new TieMsgState();
	public List<TieTaxEntity> taxEntitylist = new ArrayList<TieTaxEntity>();
	public String toListString;
	public String table3String;
	//current tieMsg
	private TieMsg currentMsg;
	
	//docList
	private List<TieDoc> tieDocList;
	public List<TieDoc> getTieDocList() {
		return tieDocList;
	}

	public void setTieDocList(List<TieDoc> tieDocList) {
		this.tieDocList = tieDocList;
	}


	//current Doc
	private TieDoc currentTieDoc;
	
	//store list of table1 records
	public List<CbcrTable1> cbcrTable1RecordList = new ArrayList<CbcrTable1>();
	
	public List<CbcrTable2> cbcrTable2RecordList = new ArrayList<CbcrTable2>();
	
	
	public String getTable3String() {
		return table3String;
	}

	public void setTable3String(String table3String) {
		this.table3String = table3String;
	}

	public String getToListString() {
		return toListString;
	}

	public void setToListString(String toListString) {
		this.toListString = toListString;
	}

	public TieDoc getCurrentTieDoc() {
		return currentTieDoc;
	}

	public void setCurrentTieDoc(TieDoc currentTieDoc) {
		this.currentTieDoc = currentTieDoc;
	}

	public List<TieTaxEntity> getTaxEntitylist() {
		return taxEntitylist;
	}

	public void setTaxEntitylist(List<TieTaxEntity> taxEntitylist) {
		this.taxEntitylist = taxEntitylist;
	}

	public TieMsgState getTieMsgState() {
		return tieMsgState;
	}

	public void setTieMsgState(TieMsgState tieMsgState) {
		this.tieMsgState = tieMsgState;
	}

	public List<TieMsgReceiver> getTiemsgReceiverList() {
		return tiemsgReceiverList;
	}

	public void setTiemsgReceiverList(List<TieMsgReceiver> tiemsgReceiverList) {
		this.tiemsgReceiverList = tiemsgReceiverList;
	}

	
	
	public TieMsg getCurrentMsg() {
		return currentMsg;
	}

	public void setCurrentMsg(TieMsg currentMsg) {
		this.currentMsg = currentMsg;
	}

	public List<TieMsg> getMsgList() {
		return msgList;
	}

	public void setMsgList(List<TieMsg> msgList) {
		this.msgList = msgList;
	}

	public TieMainPage() {
		init();
	}

	public void init() {
		selectionCriteria = new SelectionCriteria();
		language.add("en");
		language.add("zh");
		language.add("es");
		language.add("fr");
		setLanguage(language);
		//tieMsgState.setTieMsgStateId(currentMsg.getTieMsgId());
	}
	
	public static TieMainPage getTieMainPage(){
		return tieMainPage;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<String> getLanguage() {
		return language;
	}

	public void setLanguage( List<String> language) {
		this.language = language;
	}

	public SelectionCriteria getSelectionCriteria() {
		return selectionCriteria;
	}

	public void setSelectionCriteria(SelectionCriteria selectionCriteria) {
		this.selectionCriteria = selectionCriteria;
	}
	
	
	/**
	 * composeReceiverNames()
	 */
	public String composeReceiverNameList()
	{
		String retval = "";
		
		//TODO compose from the receiver list
		
		return retval;
	}//end composeReceiverNames()
	
	
}//end class TieMainPage
