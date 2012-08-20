package roles;

import starMap.StarMapInterface;
import surface.Location;

public class TVader implements TInhabitant {
	
	private TInhabitant rover;
	
	public TVader(TInhabitant rover){
		this.rover=rover;
	}

	@Override
	public void moveTo(Location targetLoc) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getImg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGender() {
		// TODO Auto-generated method stub
		return rover.getGender();
	}

	@Override
	public void setStarMap(StarMapInterface starMap) {
		// TODO Auto-generated method stub
	    rover.setStarMap(starMap);
		
	}

	@Override
	public StarMapInterface getStarMap() {
		// TODO Auto-generated method stub
		return rover.getStarMap();
	}

	@Override
	public void setInitLocation(Location loc) {
		rover.setInitLocation(loc);
	}

	@Override
	public Location getCurrentLocation() {
		// TODO Auto-generated method stub
		return rover.getCurrentLocation();
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return rover.getId();
	}

}
