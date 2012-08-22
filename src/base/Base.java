package base;

import starMap.StarMapInterface;
import surface.Location;
import surface.LocationState;

public interface Base {
	boolean isEmpty();
	StarMapInterface getStarMap();
	String getBaseType();
	LocationState setBaseState();
	void setEmpty();
	void setMap(StarMapInterface map);

}
