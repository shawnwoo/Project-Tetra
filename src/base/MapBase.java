package base;

import starMap.StarMapInterface;
import surface.Location;
import surface.LocationState;
import surface.LocationStateFactory;
import surface.MapBaseState;

public class MapBase implements Base {

	private StarMapInterface map;
	private boolean isEmpty = false;
	private String mapID;

	public MapBase(StarMapInterface map) {
		this.map = map;
		this.mapID=map.getHeader().getID();
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

		LocationStateFactory factory = new LocationStateFactory();

		return factory.factory(new MapBaseState());
	}

	@Override
	public void setEmpty() {
		// TODO Auto-generated method stub
		this.isEmpty = true;
	}

	@Override
	public void setMap(StarMapInterface map) {
		// TODO Auto-generated method stub
		this.map = map;
	}

}
