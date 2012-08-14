package surface;

public abstract class Location {
	
	private LocationState state;
	private LocationState preState;

	/**
	 * @return the state
	 */
	public LocationState getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(LocationState state) {
		this.preState = this.state;
		this.state=state;
	}
	
	public boolean isAdjacent(Location target){
		return false;
		
	}
	
	public String showState(){
		return this.state.showState();
	}

}
