package com.tie.app;

import java.util.List;
import com.tie.model.TieMsgPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UcControllerSendTieMsg extends TieControllerBase {
	final Logger logger = LoggerFactory.getLogger(TaxDocParser.class);
	List<TieMsgPackage> SessionController;
	
	public UcControllerSendTieMsg() {
		
	}

	public void sendTieMsg(long msgId) {
		
		logger.debug("Message to be sent with ID {}.", msgId);
	}

}
