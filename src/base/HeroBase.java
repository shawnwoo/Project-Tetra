package base;

import starMap.StarMapInterface;
import surface.Location;
import surface.LocationState;
import surface.LocationStateFactory;
import surface.THeroBaseState;

public class HeroBase implements Base {

	private boolean isEmpty = false;
	private StarMapInterface map;
	private String ID;
	
	

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return isEmpty;
	}

	@Override
	public StarMapInterface getStarMap() {
		// TODO Auto-generated method stub
		return this.map;
	}

	@Override
	public String getBaseType() {
		// TODO Auto-generated method stub
		return "HeroBase";
	}

	@Override
	public LocationState setBaseState() {
		// TODO Auto-generated method stub

		LocationStateFactory factory = new LocationStateFactory();

		return factory.factory(new THeroBaseState());
	}

	@Override
	public void setEmpty() {
		// TODO Auto-generated method stub
		this.isEmpty = true;
	}
	
	public void setID(String ID){
		this.ID=ID;
	}
	
	public String getID(){
		return this.ID;
	}

	@Override
	public void setMap(StarMapInterface map) {
		// TODO Auto-generated method stub
		this.map=map;
	}

	

}
