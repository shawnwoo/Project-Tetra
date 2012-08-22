package surface;

import base.Base;
import roles.TInhabitant;

public abstract class Location {

	private LocationState state;
	private LocationState preState;
	private TInhabitant role;
	private int x = 0;
	private int y = 0;
	private Base base;

	/**
	 * @return the state
	 */
	public LocationState getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(LocationState state) {
		this.preState = this.state;
		this.state = state;
	}

	public void reverseToLastState() {
		this.state = this.preState;
	}

	abstract public boolean isAdjacent(Location target);

	public String showState() {
		return this.state.showState();
	}

	public abstract String getImg();

	/**
	 * @return the role
	 */
	public TInhabitant getRole() {
		return role;
	}

	/**
	 * @param role
	 *            the role to set
	 */
	public void setRole(TInhabitant role) {
		this.role = role;
	}

	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getAxisX() {
		return this.x;

	}

	public int getAxisY() {
		return this.y;
	}

	public Base getBase() {
		return this.base;
	}

	public void setBase(Base base) {
		state = base.setBaseState();
		this.base = base;
		

	}

}
