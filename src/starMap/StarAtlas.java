package starMap;

import java.util.Enumeration;
import java.util.Vector;

import roles.THero;

public class StarAtlas implements StarMapInterface,Cloneable {

	private Vector starAtlas = new java.util.Vector();
	private boolean isEncrypted = false;
	private Header header;

	@Override
	public StarSignal showSignal(String MapId) {
		// TODO Auto-generated method stub
		return new StarSignal();
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		Enumeration enu = nodes();
		while (enu.hasMoreElements()) {
			((StarMapInterface) enu.nextElement()).display();
		}

	}

	@Override
	public void encrypt(THero hero) {
		// TODO Auto-generated method stub
		Enumeration enu = nodes();
		while (enu.hasMoreElements()) {
			((StarMapInterface) enu.nextElement()).encrypt(hero);
		}
		;
		this.isEncrypted = true;

	}

	@Override
	public void decrypt(THero hero) {
		// TODO Auto-generated method stub

		Enumeration enu = nodes();
		while (enu.hasMoreElements()) {
			((StarMapInterface) enu.nextElement()).decrypt(hero);
		}
		;
		this.isEncrypted = false;

	}

	public void add(StarMapInterface node) {

		starAtlas.addElement(node);
		if (header == null) {
			this.header = node.getHeader();
		}

	}

	public void remove(StarMapInterface node) {
		starAtlas.removeElement(node);
	}

	public void getChild(StarMapInterface node) {

	}

	@Override
	public StarMapInterface getNode() {
		// TODO Auto-generated method stub
		return this;
	}

	public Enumeration nodes() {
		return starAtlas.elements();
	}

	@Override
	public boolean isEncrypted() {
		// TODO Auto-generated method stub
		return isEncrypted;
	}

	@Override
	public boolean isEncrypted(THero hero) {
		// TODO Auto-generated method stub
		if (isEncrypted && header.getTHero() == hero)
			return true;
		else
			return false;
	}

	@Override
	public Header getHeader() {
		// TODO Auto-generated method stub
		return this.header;
	}

	@Override
	public StarMapInterface cloneMap() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		
		StarAtlas newAtlas=new StarAtlas();
		
		Enumeration enu=nodes();
		while(enu.hasMoreElements()){
		
			newAtlas.add(((StarMapInterface) enu.nextElement()).cloneMap());
		}
		
		
		
		return newAtlas;
	}

	@Override
	public void setDirections(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDirections() {
		// TODO Auto-generated method stub
		return "Star Atlas";
	}

}
