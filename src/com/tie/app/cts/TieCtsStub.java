/**
 * 
 */
package com.tie.app.cts;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import com.tie.model.TieMsg;
import com.tie.model.TieMsgEnvelope;
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
	// loop through each package and delegate to the send pkg method
	public void sendTieMsg(TieMsg tieMsg) {
		// TODO Auto-generated method stub
		Map<Long, TieMsgPackage> msgPackagesMap = tieMsg.getMsgPackages();
		// loop through packageList to generate each indivial package
		for (Object Key : msgPackagesMap.keySet()) {
			TieMsgPackage tieMsgPackage = msgPackagesMap.get(Key);
			sendTieMsgPackage(tieMsgPackage);
		}
	}

	@Override
	// create a msg file from the given package and
	// put it in a designated folder TieAppInbox
	public void sendTieMsgPackage(TieMsgPackage tieMsgPackage) {
		// TODO Auto-generated method stub
		String fileName = null;
		String sender = null;
		String receiver = null;
		String ctsTrackingId = null;
		String timeStamp = null;
		try {
			TieMsgEnvelope tieMsgEnvelope = deserialize(tieMsgPackage.getPackageBytes());
			sender = tieMsgEnvelope.getSender().getName();
			receiver = "x";
			ctsTrackingId = Integer.toString(tieMsgPackage.getTiemsg().getTieMsgId());
			timeStamp = tieMsgEnvelope.getSendTime().toString();
			fileName = sender + receiver + ctsTrackingId + "_" + "1" + ".txt";
			writeToFile(tieMsgPackage.getPackageBytes(), fileName);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Save the package
	public void writeToFile(byte[] bs, String fileName) {
		String root = "C:/CBCR_sendTieMsgPackage/";
		byte[] data = bs;
		try {
		    Files.write(Paths.get(root+fileName), data);
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}

	// byte to obj
	public TieMsgEnvelope deserialize(byte[] data) throws IOException, ClassNotFoundException {
		ByteArrayInputStream in = new ByteArrayInputStream(data);
		ObjectInputStream is = new ObjectInputStream(in);
		TieMsgEnvelope tieMsgEnvelope = (TieMsgEnvelope) is.readObject();
		return tieMsgEnvelope;
	}
}
