package starMap;

public class ReverseEncrypt implements EncryptStrategy {

	@Override
	public String encrypt(String str) {
		return new StringBuffer(str).reverse().toString();

	}

	@Override
	public String decrypt(String str) {
		// TODO Auto-generated method stub
		return new StringBuffer(str).reverse().toString();
	}

}
