package starMap;

import roles.THero;

public interface StarMapInterface {
	StarSignal showSignal(String MapId);
	void display();
	void encrypt(THero hero);
	void decrypt(THero hero);
	StarMapInterface getNode();
	boolean isEncrypted();
	boolean isEncrypted(THero hero);
	Header getHeader();
	StarMapInterface cloneMap() throws CloneNotSupportedException;
	void setDirections(String string);
	String getDirections();
	

}
