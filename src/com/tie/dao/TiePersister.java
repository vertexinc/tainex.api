/**
 * 
 */
package com.tie.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tie.app.TaxDocParser;
import com.tie.model.CbcrDoc;
import com.tie.model.CbcrTable1;
import com.tie.model.CbcrTable2;
import com.tie.model.CbcrTable3;
import com.tie.model.TieDoc;
import com.tie.model.TieMsg;
import com.tie.model.TieTaxEntity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author awang Holding all connection information Control all other daos 15
 *         attributes one for each DAO Attributes for the connection info 15
 *         helpers one for each table COnnections prop
 */
public class TiePersister {
	final Logger logger = LoggerFactory.getLogger(TaxDocParser.class);
	TieAppDao tieAppDao;
	LoginDao loginDao;
	TieMsgDao tieMsgDao;
	TieUserDao tieUserDao;
	TieDocDao tieDocDao;
	TieMsgReceiverDao tieMsgReceiverDao;
	TieEntityDao tieEntityDao;
	CbcrTable1Dao cbcrTable1Dao;
	CbcrTable2Dao cbcrTable2Dao;
	CbcrTable3Dao cbcrTable3Dao;

	public TiePersister() {
		init();
	}

	public void init() {
		tieAppDao = new TieAppDao();
		loginDao = new LoginDao();
		tieMsgDao = new TieMsgDao();
		tieUserDao = new TieUserDao();
		tieDocDao = new TieDocDao();
		tieMsgReceiverDao = new TieMsgReceiverDao();
		tieEntityDao = new TieEntityDao();
		cbcrTable1Dao = new CbcrTable1Dao();
		cbcrTable2Dao = new CbcrTable2Dao();
		cbcrTable3Dao = new CbcrTable3Dao();
	}

	// TieMsg buildTieMsg( long msgId )
	public TieMsg buildTieMsg(long msgId) throws JsonProcessingException {
		// 1. find TieMsg
		TieMsg tieMsg = tieMsgDao.findTieMsgByTieMsgId((int) msgId);
		// * find all entity for the msg
		// * add entity to the msg

		// **************entityList:does entityList belong to doc rather than
		// msg*****************
		// all entity list moved to CbcrDoc

		// 2. find all TieDoc records for the msg
		List<TieDoc> tieDocList = new ArrayList<TieDoc>();
		tieDocList = tieDocDao.findTieDocByTieMsgId((int) msgId);

		
		// 3. buildTieDoc for each TieDoc record
		for (TieDoc tieDoc : tieDocList) {
		
			TieDoc builtDoc = buildTieDoc(tieDoc);
			
			ObjectMapper mas = new ObjectMapper();
			String builtJSON = mas.writeValueAsString(builtDoc);
			// builtDoc return null value in main doc 
			logger.debug("The doc after been built in json is {}", builtJSON);
			validateDoc(builtDoc,tieDoc);
			// 4. add the TieDoc subclass object to msg
			int docId = tieDoc.getTieDocId();
			List<TieTaxEntity> tieTaxEntityList = tieEntityDao.findTieEntityByTieDocId(docId);
					
			for(TieTaxEntity tieTaxEntity : tieTaxEntityList){
				
				builtDoc.getTaxEntityList().add(tieTaxEntity);
			}
		
			//logger.debug("Current doc ready to be added in msg in json is {}", sentdocJSON);
			tieMsg.getTieDocList().add(builtDoc);
		}
		
		ObjectMapper ma = new ObjectMapper();
		String sentMsgJSON = ma.writeValueAsString(tieMsg);

		// logger.debug("The message ready to be sent {}",sentMsgJSON);
		// * return msg
		
		return tieMsg;
	}// end buildTieMsg(.)

	private void validateDoc(TieDoc builtDoc, TieDoc tieDoc) {
		// TODO Auto-generated method stub
		builtDoc.setTieDocId(tieDoc.getTieDocId());
		builtDoc.setName(tieDoc.getName());
		builtDoc.setCode(tieDoc.getCode());
		builtDoc.setDescription(tieDoc.getDescription());
		builtDoc.setTieDocTypeId(tieDoc.getTieDocTypeId());
		builtDoc.setTieMsgId(tieDoc.getTieMsgId());
		builtDoc.setReportingEntityCode(tieDoc.getReportingEntityCode());
		builtDoc.setReportingEntity(tieDoc.getReportingEntity());
		builtDoc.setCurrencyCode(tieDoc.getCurrencyCode());
		builtDoc.setResCountryCode(tieDoc.getResCountryCode());
		builtDoc.setSourceDoc(tieDoc.getSourceDoc());
		builtDoc.setAccountingStandard(tieDoc.getAccountingStandard());
		builtDoc.setReportingPeriod(tieDoc.getReportingPeriod());
		builtDoc.setTaxEntityList(tieDoc.getTaxEntityList());
	}

	// TODO Fully build out a TieDoc subclass based on the given TieDoc record
	// TieDoc buildTieDoc( TieDoc tieDocRecord )
	public TieDoc buildTieDoc(TieDoc tieDocRecord) throws JsonProcessingException {
		// 1. switch based on type field of the record
		// 2. if type id cbcr, build cbcr doc
		TieDoc builtTieDoc = new TieDoc();
		if (tieDocRecord.getTieDocTypeId() == 1) {
			builtTieDoc = buildCbcrDoc(tieDocRecord);
		} else if (tieDocRecord.getTieDocTypeId() == 2) {
			logger.debug("Current Doc Type is {}", tieDocRecord.getTieDocTypeId());
		} else {
			logger.debug("Current Doc Type is {}", tieDocRecord.getTieDocTypeId());
		}
		return builtTieDoc;
	}// end buildTieDoc(.)

	// TODO fully build out a CbCrDoc
	public CbcrDoc buildCbcrDoc(TieDoc tieDocRecord) throws JsonProcessingException {
		// 1. check to ensure that the type is cbcr, otherwise, throw run time
				// exception
		if (tieDocRecord.getTieDocTypeId() != 1) {
			throw new RuntimeException("Not a CbCR doc");
		}else{
			ObjectMapper ma = new ObjectMapper();
			String tieDocRecordJSON = ma.writeValueAsString(tieDocRecord);

			logger.info("Start to build cbcr doc !" + tieDocRecordJSON);
		}
		
		// ***********TODO finish cbcrDoc migration
		// 2. create a new CbcrDoc to be returned, use constructor CbcrDoc(
				// TieDoc
				// tieDocRecord ), copying all fields of the input record
	
		CbcrDoc cbcrDoc = new CbcrDoc(tieDocRecord);
		
		// 3. table1,2,3 persisters, find records of the cbcr doc, and add to
				// the
				// new CbcrDoc to be returned.
		int tieDocId = tieDocRecord.getTieDocId();
		
		List<CbcrTable1> cbcrTable1List = cbcrTable1Dao.findCbcrTable1ByTieDocId(tieDocId);
		cbcrDoc.setCbcrTable1List(cbcrTable1List);
		
		List<CbcrTable2> cbcrTable2List = cbcrTable2Dao.findCbcrTable2ByTieDocId(tieDocId);
		cbcrDoc.setCbcrTable2List(cbcrTable2List);
		
		List<CbcrTable3> cbcrTable3List = cbcrTable3Dao.findCbcrTable3ByTieDocId(tieDocId);
		cbcrDoc.setCbcrTable3List(cbcrTable3List);
		
		return cbcrDoc;
	}// end buildCbcrDoc(.)
		
		
		

	public CbcrTable3Dao getCbcrTable3Dao() {
		return cbcrTable3Dao;
	}

	public void setCbcrTable3Dao(CbcrTable3Dao cbcrTable3Dao) {
		this.cbcrTable3Dao = cbcrTable3Dao;
	}

	public CbcrTable2Dao getCbcrTable2Dao() {
		return cbcrTable2Dao;
	}

	public void setCbcrTable2Dao(CbcrTable2Dao cbcrTable2Dao) {
		this.cbcrTable2Dao = cbcrTable2Dao;
	}

	public CbcrTable1Dao getCbcrTable1Dao() {
		return cbcrTable1Dao;
	}

	public void setCbcrTable1Dao(CbcrTable1Dao cbcrTable1Dao) {
		this.cbcrTable1Dao = cbcrTable1Dao;
	}

	public TieMsgReceiverDao getTieMsgReceiverDao() {
		return tieMsgReceiverDao;
	}

	public void setTieMsgReceiverDao(TieMsgReceiverDao tieMsgReceiverDao) {
		this.tieMsgReceiverDao = tieMsgReceiverDao;
	}

	public TieDocDao getTieDocDao() {
		return tieDocDao;
	}

	public void setTieDocDao(TieDocDao tieDocDao) {
		this.tieDocDao = tieDocDao;
	}

	public TieMsgDao getTieMsgDao() {
		return tieMsgDao;
	}

	public void setTieMsgDao(TieMsgDao tieMsgDao) {
		this.tieMsgDao = tieMsgDao;
	}

	public TieUserDao getTieUserDao() {
		return tieUserDao;
	}

	public void setTieUserDao(TieUserDao tieUserDao) {
		this.tieUserDao = tieUserDao;
	}

	public void setTieAppDao(TieAppDao tieAppDao) {
		this.tieAppDao = tieAppDao;
	}

	public TieEntityDao getTieEntityDao() {
		return tieEntityDao;
	}

	public void setTieEntityDao(TieEntityDao tieEntityDao) {
		this.tieEntityDao = tieEntityDao;
	}

	public TieAppDao getTieAppDao() {
		return new TieAppDao();
	}

	public LoginDao getLoginDao() {
		return new LoginDao();
	}
}
