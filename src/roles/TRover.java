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
		
		LocationStateFactory factory=new LocationStateFactory();
		
		if (currentLoc.isAdjacent(targetLoc)) {
			if (targetLoc.getState().showState().equalsIgnoreCase("empty")
					|| targetLoc.getState().showState()
							.equalsIgnoreCase("Mapbase"))

				this.currentLoc.reverseToLastState();
			this.setCurrntloc(targetLoc);
			this.currentLoc.setState(factory.factory(new TRoverState()));
		}

		else
			System.out.println("Can move to adjacent location");

	}

	/**
	 * @return the currntLoc
	 */
	public Location getCurrntloc() {
		return currentLoc;
	}

	/**
	 * @param currntloc
	 *            the currntLoc to set
	 */
	public void setCurrntloc(Location currntloc) {
		this.currentLoc = currntloc;
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
