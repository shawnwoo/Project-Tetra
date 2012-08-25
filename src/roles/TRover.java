package roles;

import starMap.StarMapInterface;
import surface.EmptyState;
import surface.Location;
import surface.LocationStateFactory;
import surface.TRoverState;

public class TRover implements TInhabitant {

	private Location currentLoc;
	private String gender;
	private StarMapInterface starMap;
	private String ID = "0";
	LocationStateFactory factory = new LocationStateFactory();

	public TRover(String gender) {
		this.gender = gender;
	};

	public TRover(String gender, Location loc) {
		this.gender = gender;
		this.currentLoc = loc;
	}

	/**
	 * move to target location, if the target location is not an adjacent
	 * location, log a message
	 * 
	 * @param targetLoc
	 */
	public void moveTo(Location targetLoc) {

		if (currentLoc.isAdjacent(targetLoc)) {
			if (targetLoc.getState().showState().equalsIgnoreCase("empty")
					|| targetLoc.getState().showState()
							.equalsIgnoreCase("Mapbase")) {
				currentLoc.reverseToLastState();
				setCurrentLocation(targetLoc);
				currentLoc.setState(factory.factory(new TRoverState()));
			}else System.out.println("Something in there, I cannot move to that location.");
		}

		else
			System.out.println("Only can move to adjacent location");

	}

	@Override
	public String getImg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGender() {
		// TODO Auto-generated method stub
		return this.gender;
	}

	@Override
	public void setStarMap(StarMapInterface starMap) {
		// TODO Auto-generated method stub
		this.starMap = starMap;
	}

	@Override
	public StarMapInterface getStarMap() {
		// TODO Auto-generated method stub
		return this.starMap;
	}

	@Override
	public void setInitLocation(Location loc) {
		// TODO Auto-generated method stub
		this.currentLoc = loc;

	}

	@Override
	public Location getCurrentLocation() {
		// TODO Auto-generated method stub
		return this.currentLoc;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return ID;
	}

	public void setId(String id) {
		this.ID = id;
	}

	@Override
	public void setCurrentLocation(Location loc) {
		// TODO Auto-generated method stub
		this.currentLoc = loc;
	}

}
