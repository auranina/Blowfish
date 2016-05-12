
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import sun.misc.BASE64Decoder;

public class Decryptor implements Decryptable {

	private String username;
	private String password;
	
	public Decryptor (String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Override
	public String decript(String encryptedFileName) {
		String encryptedContent = "EMPTY FILE!";
		try {
			File encryptedFile = new File(encryptedFileName);
			encryptedContent = new Scanner(encryptedFile).useDelimiter("\\Z").next();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		System.out.println(encryptedContent);
		// username = "erica" and password = "password".  username + password = "ericapassword"
		byte[] keyData = (username+password).getBytes();
        HomeMadeKey myHomeMadeKey = new HomeMadeKey(keyData, "Blowfish");
        
        Cipher myCipher = null;
        try {
			myCipher = Cipher.getInstance("Blowfish");
			myCipher.init(Cipher.DECRYPT_MODE, myHomeMadeKey);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException 
				| InvalidKeyException e) {
			e.printStackTrace();
		}
        
        byte[] decryptedBytes = null;
		try {
			decryptedBytes = myCipher.doFinal(new BASE64Decoder().decodeBuffer(encryptedContent));
		} catch (IllegalBlockSizeException | BadPaddingException | IOException e) {
			e.printStackTrace();
		}
		
        String decryptedString = new String(decryptedBytes);
		return decryptedString;
	}
	
}
