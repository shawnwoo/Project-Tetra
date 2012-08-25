package roles;

import starMap.StarMapInterface;
import surface.Location;
import surface.LocationStateFactory;
import surface.THeroState;
import starMap.*;
import base.Base;
import base.HeroBase;
import base.VaderBase;

public class THero implements TInhabitant {

	private TRover rover;
	private EncryptStrategy encryptStragety;
	private HeroBase heroBase;
	private Location heroBaseLocation;
	private LocationStateFactory factory = new LocationStateFactory();

	public void setHeroBase(HeroBase base) {
		this.heroBase = base;
		base.setID(rover.getId());
	}

	public HeroBase getHeroBase() {
		return this.heroBase;
	}

	public void setHeroBaseLocation(Location loc) {
		this.heroBaseLocation = loc;
	}

	public Location getHeroBaseLocation() {
		return this.heroBaseLocation;
	}

	public THero(TRover rover) {
		this.rover = rover;

	}

	@Override
	public void moveTo(Location targetLoc) {

		if (targetLoc.getState().showState().equalsIgnoreCase("THero")) {
			enterHeroBase(targetLoc);
		}
		;

		if (targetLoc.getState().showState().equalsIgnoreCase("MapBase")) {

			rover.moveTo(targetLoc);

			Base base = targetLoc.getBase();
			StarMapInterface map;

			if (!base.isEmpty()) {
				map = base.getStarMap();
				if (!map.isEncrypted()) {

					map.display();
					map.encrypt(this);

				} else if (map.isEncrypted(this)) {
					map.decrypt(this);
					map.display();
				} else if (!map.isEncrypted(this)) {
					map.getHeader().appendID(this.getId());
					map.display();
				}
				;

			} else {
				flyTo(VaderBase.loc);
				Base vaderbase = VaderBase.loc.getBase();
				StarMapInterface rubbedMap = vaderbase.getStarMap();
				String MapId = vaderbase.getStarMap().getHeader().getID();
				if (vaderbase.getStarMap().showSignal(MapId).isHere()) {
					try {
						StarMapInterface heroMap = rubbedMap.cloneMap();
						rubbedMap.encrypt(this);
						base.setMap(rubbedMap);
						flyTo(this.heroBaseLocation);
						this.heroBase.setMap(heroMap);

					} catch (CloneNotSupportedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					;

				}
			}
		} else
			rover.moveTo(targetLoc);

		rover.getCurrentLocation().setState(factory.factory(new THeroState()));
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
	 * @param encryptStragety
	 *            the encryptStragety to set
	 */
	public void setEncryptStragety(EncryptStrategy encryptStragety) {
		this.encryptStragety = encryptStragety;
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return rover.getId();
	}

	public void setId(String id) {
		rover.setId(id);

	}

	public void flyTo(Location targetLoc) {

		rover.getCurrentLocation().reverseToLastState();
		rover.setCurrentLocation(targetLoc);
		rover.getCurrentLocation().setState(factory.factory(new THeroState()));
	}

	private void enterHeroBase(Location loc) {
		rover.setCurrentLocation(loc);
		((HeroBase) rover.getCurrentLocation().getBase()).setID(rover.getId());

	}

	@Override
	public void setCurrentLocation(Location loc) {
		// TODO Auto-generated method stub
		rover.setCurrentLocation(loc);
		loc.setState(factory.factory(new THeroState()));
	}
}
