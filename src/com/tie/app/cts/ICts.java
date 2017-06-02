/**
 * 
 */
package com.tie.app.cts;

import com.tie.model.TieMsg;
import com.tie.model.TieMsgPackage;
import com.tie.model.TieUser;

/**
 * @author awang
 *
 */
public interface ICts {
	String fecthcEncryptionKey(TieUser user);
	void sendTieMsg(TieMsg tiemsg);
	void sendTieMsgPackage(TieMsgPackage tieMsgPackage);
}
