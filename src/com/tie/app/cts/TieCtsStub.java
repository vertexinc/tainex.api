/**
 * 
 */
package com.tie.app.cts;

import com.tie.model.TieMsg;
import com.tie.model.TieMsgPackage;
import com.tie.model.TieUser;

/**
 * @author awang stub implementation of the interface
 */
public class TieCtsStub implements ICts {

	@Override
	public String fecthcEncryptionKey(TieUser user) {
		// TODO Auto-generated method stub
		return "!@#$MySecr3tPassw0rd";
	}

	@Override
	//loop through each package and delegate to the send pkg method
	public void sendTieMsg(TieMsg tiemsg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//create a msg file from the given package and 
	//put it in a designated folder TieAppInbox
	public void sendTieMsgPackage(TieMsgPackage tieMsgPackage) {
		// TODO Auto-generated method stub
		
	}
	

}
