
package com.tie.app;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import com.tie.app.cts.TieCtsStub;
import com.tie.dao.BaseDao;
import com.tie.dao.LoginDao;
import com.tie.model.TieMsgPackage;
import com.tie.model.TieUser;

/**
 * @author awang Validate username and psw authentication & authorization
 */
public class TieSecurityManager extends TieControllerBase {

	/**
	 * Authenticate the given user name and password.
	 */
	// reference to cts
	TieCtsStub tieCtsStub = null;

	public TieSecurityManager() {

	}

	public TieSecurityManager(TieCtsStub tieCtsStub) {
		this.tieCtsStub = tieCtsStub;
	}

	public boolean authentiate(String name, String pass) {
		boolean retval = false;
		LoginDao loginDao = new LoginDao();
		retval = loginDao.validate(name, pass);
		return retval;
	}

	String fecthcEncryptionKey(TieUser user) {
		return "!@#$MySecr3tPassw0rd";
	}

	byte[] encryptMsgBody(String msgBody, TieMsgPackage tieMsgPkg)
			throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException,
			NoSuchAlgorithmException, NoSuchPaddingException {
		String key = fecthcEncryptionKey(tieMsgPkg.getTiemsg().getSender());
		byte[] encryptedText = encryptText(key, msgBody);
		return encryptedText;
	}
	
	String decryptMsgBody( TieMsgPackage tieMsgPkg) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
		String key = fecthcEncryptionKey(tieMsgPkg.getTiemsg().getSender());
		String tieMsgPayload = decryptText(key,tieMsgPkg.getPayloadEncrypted());
		return tieMsgPayload;
	}

	private String decryptText(String key, byte[] payloadEncrypted) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		// TODO Auto-generated method stub
		String decryptedText = null;
		int length = 16;
		byte[] keyByte = new byte[length];
		keyByte = fixSecret(key, length);
		
		SecretKeySpec secretKey = new SecretKeySpec(keyByte, "AES");
		Cipher cipher = Cipher.getInstance("AES");
		
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		String encryptedString  = new String(cipher.doFinal(payloadEncrypted));

		System.out.println("After decryption: " + encryptedString);
		return encryptedString;
	}

	byte[] encryptText(String key, String plainText) throws InvalidKeyException, IOException, IllegalBlockSizeException,
			BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
		byte[] encryptedText = null;
		int length = 16;
		byte[] keyByte = new byte[length];
		keyByte = fixSecret(key, length);

		SecretKeySpec secretKey = new SecretKeySpec(keyByte, "AES");
		Cipher cipher = Cipher.getInstance("AES");

		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		encryptedText = cipher.doFinal(plainText.getBytes("UTF-8"));
		System.out.println(Arrays.toString(encryptedText));
		return encryptedText;
	}

	private byte[] fixSecret(String key, int length) throws UnsupportedEncodingException {
		if (key.length() < length) {
			int missingLength = length - key.length();
			for (int i = 0; i < missingLength; i++) {
				key += " ";
			}
		}
		return key.substring(0, length).getBytes("UTF-8");
	}

}
