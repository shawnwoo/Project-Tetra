package roles;

import starMap.StarMapInterface;
import surface.Location;
import starMap.*;
import base.Base;
import base.HeroBase;
import base.VaderBase;

public class THero implements TInhabitant {

	private TInhabitant rover;
	private EncryptStrategy encryptStragety;
	private HeroBase heroBase;
	private Location heroBaseLocation;

	public void setHeroBase(HeroBase base) {
		this.heroBase = base;
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

	public THero(TInhabitant rover) {
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
		}

		// rover.moveTo(targetLoc);

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

	public void flyTo(Location targetLoc) {
		rover.setCurrentLocation(targetLoc);
	}

	private void enterHeroBase(Location loc) {
		rover.setCurrentLocation(loc);
		((HeroBase) rover.getCurrentLocation().getBase()).setID(rover.getId());

	}

	@Override
	public void setCurrentLocation(Location loc) {
		// TODO Auto-generated method stub
		rover.setCurrentLocation(loc);
	}
}
