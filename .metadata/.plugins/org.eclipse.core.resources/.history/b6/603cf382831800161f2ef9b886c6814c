

import java.security.spec.KeySpec;

import javax.crypto.SecretKey;


public class HomeMadeKey implements KeySpec, SecretKey {


	private static final long serialVersionUID = 3481524322219986049L;
	

	private byte[] myKey; 

	private String algorithm;
	
	public HomeMadeKey(byte[] myKey, String algorithm) {
//		this.myKey = myKey;
		this.myKey = (byte[])myKey.clone();
		this.algorithm = algorithm;
	}
	
	@Override
	public String getAlgorithm() {
		return algorithm;
	}

	@Override
	public String getFormat() {
		// ???? No idea why this is "raw", but that is what it is supposed to be
		/* Keys that implement this interface return the string RAW as their encoding 
		 * format (see getFormat), and return the raw key bytes as the result of a 
		 * getEncoded method call. (The getFormat and getEncoded methods are inherited 
		 * from the java.security.Key parent interface.) */
		return "RAW";
	}

	@Override
	public byte[] getEncoded() {
		return (byte[])myKey.clone();
	}

}
