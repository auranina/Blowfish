

import java.security.spec.KeySpec;

import javax.crypto.SecretKey;


public class HomeMadeKey implements KeySpec, SecretKey {

//needed this?
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
		return "RAW";
	}

	@Override
	public byte[] getEncoded() {
		return (byte[])myKey.clone();
	}

}
