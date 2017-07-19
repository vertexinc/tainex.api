/**
 * 
 */
package com.tie.app.cts;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.SerializationUtils;

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

	/*
	 * Read & Write file
	 */
	// Save the package to local disk
	public void writeToFile(byte[] bs, String fileName) {
		String root = "C:/CBCR_sendTieMsgPackage/";
		byte[] data = bs;
		try {
			Files.write(Paths.get(root + fileName), data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Read the package from the local disk
	public byte[] readFromFile(String fileName) {
		Path fileLocation = Paths.get("C:/CBCR_sendTieMsgPackage/" + fileName);
		byte[] data = null;
		try {
			data = Files.readAllBytes(fileLocation);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}

	/*
	 * Send & Receive message package
	 */
	@Override
	// create a msg file from the given package and
	// put it in a designated folder TieAppInbox
	public void sendTieMsgPackage(byte[] tieMsgPackageByte) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		String fileName = null;
		String sender = null;
		String receiver = null;
		String ctsTrackingId = null;
		String timeStamp = null;
		TieMsgPackage tieMsgPackage = deserializePkg(tieMsgPackageByte);
		TieMsgEnvelope tieMsgEnvelope = tieMsgPackage.getTiemsgEvelope();
		sender = tieMsgEnvelope.getSender().getName();
		receiver = tieMsgPackage.getSingleRecipient();
		ctsTrackingId = Integer.toString(tieMsgPackage.getTiemsg().getTieMsgId());
		timeStamp = tieMsgEnvelope.getSendTime().toString().replaceAll("\\s+", "").replaceAll(":", "");
		fileName = sender + receiver + ctsTrackingId + "_" + timeStamp + ".txt";
		writeToFile(tieMsgPackageByte, fileName);
	}

	public TieMsgPackage receiveTieMsgPackage(byte[] tieMsgPkgData) throws ClassNotFoundException, IOException {
		TieMsgPackage tieMsgPackage = deserializePkg(tieMsgPkgData);
		return tieMsgPackage;
	}

	/*
	 * Byte to obj
	 */

	// TieMsgPkg byte to obj
	// byte to obj
	public TieMsgPackage deserializePkg(byte[] data) throws IOException, ClassNotFoundException {
		TieMsgPackage tieMsgPackage = (TieMsgPackage) SerializationUtils.deserialize(data);
		return tieMsgPackage;
	}

	public String[] checkForNewMessage(String receipientString) {
		File folder = new File("C:/CBCR_sendTieMsgPackage");
		File[] listOfFiles = folder.listFiles();
		List<String> receivedFileName = new ArrayList<String>();
		for (int i = 0; i < listOfFiles.length; i++) {
			// Check String contains:
			String fileName = listOfFiles[i].getName();
			if (fileName.toLowerCase().contains(receipientString.toLowerCase())) {
				receivedFileName.add(listOfFiles[i].getName());
			}
		}
		String[] retVal = new String[receivedFileName.size()];
		retVal = receivedFileName.toArray(retVal);
		System.out.println("Received Message" + Arrays.toString(retVal));
		return retVal;
	}
}
