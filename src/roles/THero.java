package roles;

import starMap.StarMapInterface;
import surface.Location;
import starMap.*;

public class THero implements TInhabitant {

	private TInhabitant rover;
	private EncryptStrategy encryptStragety;

	public THero(TInhabitant rover) {
		this.rover = rover;
	}

	@Override
	public void moveTo(Location targetLoc) {
		rover.moveTo(targetLoc);

	}

	@Override
	public String getImg() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getGender() {
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

	/**
	 * @return the encryptStragety
	 */
	public EncryptStrategy getEncryptStragety() {
		return encryptStragety;
	}

	/**
	 * @param encryptStragety the encryptStragety to set
	 */
	public void setEncryptStragety(EncryptStrategy encryptStragety) {
		this.encryptStragety = encryptStragety;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return rover.getId();
	}

	public void flyTo(Location targetLoc){
		((TRover)rover).setLocation(targetLoc);
	}
}
