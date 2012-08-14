package roles;

import surface.Location;

public class TRover implements TInhabitant {

	private Location currentLoc;
	

	/**
	 * move to target location, if the target location is an adjacent location, log a message
	 * @param targetLoc
	 */
	public void moveTo(Location targetLoc) {
		if (!currentLoc.isAdjacent(targetLoc))
			this.setCurrntloc(targetLoc);
		else
			System.out.println("Cannot move to that adjacent location");

	}

	/**
	 * @return the currntloc
	 */
	public Location getCurrntloc() {
		return currentLoc;
	}

	/**
	 * @param currntloc
	 *            the currntloc to set
	 */
	public void setCurrntloc(Location currntloc) {
		this.currentLoc = currntloc;
	}

}
