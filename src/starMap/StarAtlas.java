package starMap;

import java.util.Enumeration;
import java.util.Vector;

import roles.THero;

public class StarAtlas implements StarMapInterface{
	
	
	private Vector starAtlas=new java.util.Vector();
	


	@Override
	public StarSignal showSignal(String MapId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		Enumeration enu=nodes();
		while(enu.hasMoreElements()){
			((StarMapInterface)enu.nextElement()).display();
		}
		
	}

	@Override
	public void encrypt(THero hero) {
		// TODO Auto-generated method stub
		Enumeration enu=nodes();
		while(enu.hasMoreElements()){
			((StarMapInterface)enu.nextElement()).encrypt(hero);
		}
		
	}

	@Override
	public void decrypt(THero hero) {
		// TODO Auto-generated method stub
		
		Enumeration enu=nodes();
		while(enu.hasMoreElements()){
			((StarMapInterface)enu.nextElement()).decrypt(hero);
		}
		
	}
	
	public void add(StarMapInterface node){
		
		starAtlas.addElement(node);
		
	}
	
	public void remove(StarMapInterface node){
		starAtlas.removeElement(node);
	}
	
	public void getChild(StarMapInterface node){
		
	}

	@Override
	public StarMapInterface getNode() {
		// TODO Auto-generated method stub
		return this;
	}
	
	public Enumeration nodes(){
		return starAtlas.elements();
	}

}
