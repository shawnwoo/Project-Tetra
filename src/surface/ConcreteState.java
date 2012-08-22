package surface;

public class ConcreteState implements LocationState {
	
	private LocationState intrinsicState=null;
	
	public ConcreteState(LocationState state){
		this.intrinsicState=state;
	}

	@Override
	public String showState() {
		// TODO Auto-generated method stub
		return this.intrinsicState.showState();
	}

}
