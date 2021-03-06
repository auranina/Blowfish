

public class EricasBlowfishTest {

	public static void main(String[] args) {

		String fileName = "encrypted_text.txt";
		String username = "erica";
		String password = "password";
		
		Encryptor encryptor = new Encryptor(username, password);
		boolean success = encryptor.encrypt(fileName);
		if (success) {
			System.out.println("Successfully encrypted the password.");
		} else {
			System.out.println("Failed to encrypte the password.");
		}
		
		Decryptor decryptor = new Decryptor(username, password);
		String decryptedText = decryptor.decript(fileName);
		System.out.println("Decryped: ["+decryptedText+"]");

		if (decryptedText.equals(password)) {
			System.out.println("Decryption was successfull.");
		} else {
			System.out.println("Ack!  Decryption failed!");
		}
	}

}
