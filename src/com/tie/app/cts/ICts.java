/**
 * 
 */
package com.tie.app.cts;

import java.io.IOException;

import com.tie.model.TieMsg;
import com.tie.model.TieMsgPackage;
import com.tie.model.TieUser;

/**
 * @author awang
 *
 */
public interface ICts {
	String fecthcEncryptionKey(TieUser user);
	void sendTieMsgPackage(byte[] tieMsgPackageByte) throws ClassNotFoundException, IOException;
}
