package roles;

import java.util.ArrayList;

import starMap.StarMapInterface;
import surface.Location;
import transportation.TFlier;

public class TVader implements TInhabitant {

	private TInhabitant rover;
	private ArrayList<Location> trace;

	public TVader(TInhabitant rover) {
		this.rover = rover;
	}

	@Override
	public void moveTo(Location targetLoc) {
		if (!targetLoc.getState().showState().equalsIgnoreCase("THeroBase")) {
			rover.moveTo(targetLoc);
			trace.add(targetLoc);
		}
		
		if(targetLoc.getState().showState().equalsIgnoreCase("MapBase")){
			rubMap();
		}

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

	public void flyTo(Location targetLoc) {
		((TRover) rover).setLocation(targetLoc);

	}

	public void rubMap() {
		if (!rover.getCurrentLocation().getBase().isEmpty()) {
			rover.setStarMap(rover.getCurrentLocation().getBase().getStarMap());
			rover.getCurrentLocation().getBase().setEmpty();
		} else {
			System.out.println("This base is already rubbed!");
		}

	}

	public void retrace() {
		for (int i = 0; i < trace.size(); i++) {
			moveTo(trace.get(i));
		}

		trace.clear();
	}

}
