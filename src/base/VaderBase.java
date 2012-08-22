package base;

import starMap.StarMapInterface;
import surface.Location;
import surface.LocationState;
import surface.LocationStateFactory;
import surface.RectangleLocation;
import surface.TVaderBaseState;

public class VaderBase implements Base {

	public static  final int X_VADER_BASE = 5;
	public static final int Y_VADER_BASE = 5;
	public static final Location loc=new RectangleLocation(X_VADER_BASE, Y_VADER_BASE); 

	private boolean isEmpty = false;
	private StarMapInterface map;

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return isEmpty;
	}

	@Override
	public StarMapInterface getStarMap() {
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public String getBaseType() {
		// TODO Auto-generated method stub
		return "VaderBase";
	}

	@Override
	public LocationState setBaseState() {
		// TODO Auto-generated method stub
		
		LocationStateFactory factory=new LocationStateFactory();
		return factory.factory(new TVaderBaseState());
	}

	@Override
	public void setEmpty() {
		// TODO Auto-generated method stub
		isEmpty = true;
	}

	@Override
	public void setMap(StarMapInterface map) {
		// TODO Auto-generated method stub
		this.map=map;
	}

	

}
