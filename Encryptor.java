
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import sun.misc.BASE64Encoder;

public class Encryptor implements Encryptable {

	private String username;
	private String password;
	
	public Encryptor (String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	@Override
	public boolean encrypt(String encryptedFileName) {
		// username = "erica" and password = "password".  username + password = "ericapassword"
		byte[] rawByteData = (username+password).getBytes();
        HomeMadeKey myHomeMadeKey = new HomeMadeKey(rawByteData, "Blowfish");
        
        Cipher myCipher = null;
        try {
			myCipher = Cipher.getInstance("Blowfish");
			myCipher.init(Cipher.ENCRYPT_MODE, myHomeMadeKey);
		} catch (NoSuchAlgorithmException | NoSuchPaddingException 
				| InvalidKeyException e) {
			e.printStackTrace();
		}
        
        byte[] encryptedBytes = null;
		try {
			encryptedBytes = myCipher.doFinal(password.getBytes());
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
		}
		
		String encryptedString = new BASE64Encoder().encode(encryptedBytes);
		
		PrintWriter myPrinter = null;
		try {
			File encryptedFile = new File(encryptedFileName);
	        myPrinter = new PrintWriter(encryptedFile);
	        myPrinter.write(encryptedString);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} finally {
			myPrinter.close();
		}
		System.out.println(encryptedString);
        
		
		return true;
	}
	
}
