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

import com.tie.app.TaxDocParser;
import com.tie.model.CbcrDoc;
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

	// TieMsg buildTieMsg( long msgId )
	public TieMsg buildTieMsg(long msgId) {
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
			// 4. add the TieDoc subclass object to msg
			tieMsg.getTieDocList().add(builtDoc);
		}

		// * return msg

		return tieMsg;
	}//end buildTieMsg(.)

	// TODO Fully build out a TieDoc subclass based on the given TieDoc record
	// TieDoc buildTieDoc( TieDoc tieDocRecord )
	public TieDoc buildTieDoc(TieDoc tieDocRecord) {
		// 1. switch based on type field of the record
		// 2. if type id cbcr, build cbcr doc
		TieDoc builtTieDoc = new TieDoc();
		if (tieDocRecord.getTieDocTypeId() == 3) {
			builtTieDoc = buildCbcrDoc(tieDocRecord);
		} else if (tieDocRecord.getTieDocTypeId() == 2) {
			logger.debug("Current Doc Type is {}",tieDocRecord.getTieDocTypeId());
		} else {
			logger.debug("Current Doc Type is {}",tieDocRecord.getTieDocTypeId());
		}
		return builtTieDoc;
	}//end buildTieDoc(.)

	// TODO fully build out a CbCrDoc
	public CbcrDoc buildCbcrDoc(TieDoc tieDocRecord) {
		if(tieDocRecord.getTieDocTypeId() != 3){
			throw new RuntimeException("Not a CbCR doc");
		}
		//***********TODO finish cbcrDoc migration
		CbcrDoc cbcrDoc = new CbcrDoc(tieDocRecord);
		return cbcrDoc;
	}//end buildCbcrDoc(.)
	// 1. check to ensure that the type is cbcr, otherwise, throw run time
	// exception
	// 2. create a new CbcrDoc to be returned, use constructor CbcrDoc(
	// TieDoc
	// tieDocRecord ), copying all fields of the input record
	// 3. table1,2,3 persisters, find records of the cbcr doc, and add to
	// the
	// new CbcrDoc to be returned.

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

	public TiePersister() {
		init();
	}

	public void init() {
		// BaseDao basedao = new BaseDao();
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
