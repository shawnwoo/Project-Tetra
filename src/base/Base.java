package base;

import starMap.StarMapInterface;
import surface.LocationState;

public interface Base {
	boolean isEmpty();
	StarMapInterface getStarMap();
	String getBaseType();
	LocationState setBaseState();
	void setEmpty();

}
