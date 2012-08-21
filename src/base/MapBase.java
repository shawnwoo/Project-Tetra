package base;

import starMap.StarMapInterface;
import surface.LocationState;
import surface.MapBaseState;

public class MapBase implements Base {
	
	private StarMapInterface map;
	private boolean isEmpty=false;
	
	public MapBase(StarMapInterface map){
		this.map=map;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.isEmpty;
	}

	@Override
	public StarMapInterface getStarMap() {
		// TODO Auto-generated method stub
		return map;
	}

	@Override
	public String getBaseType() {
		// TODO Auto-generated method stub
		return "MapBase";
	}

	@Override
	public LocationState setBaseState() {
		// TODO Auto-generated method stub
		return new MapBaseState();
	}

	@Override
	public void setEmpty() {
		// TODO Auto-generated method stub
		this.isEmpty=true;
	}

}
