

public class EricasBlowfishTest {

	public static void main(String[] args) {
		
		String fileName = "encrypted_text.txt";
		String username = "erica";
		String password = "password";
		System.out.println("Input: " + username);
		System.out.println("Key: " + password);
		Encryptor encryptor = new Encryptor(username, password);
		boolean success = encryptor.encrypt(fileName);
		
		if (success) {
			System.out.println("Successfully encrypted the password.");
		} else {
			System.out.println("Failed to encrypt the password.");
		}
		
		System.out.print("Input: ");
		
		Decryptor decryptor = new Decryptor(username, password);
		String decryptedText = decryptor.decript(fileName); //password
		
		System.out.println("Decrypted: ["+decryptedText+"]");

		if (decryptedText.equals(password)) {
			System.out.println("Decryption was successful.");
			System.out.println("Output: " 
					+ username);
		} else {
			System.out.println("Decryption failed!");
		}
	}

}
