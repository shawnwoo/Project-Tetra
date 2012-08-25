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

	@Override
	public int getStateNum() {
		// TODO Auto-generated method stub
		return this.intrinsicState.getStateNum();
	}

	@Override
	public boolean isSurFaceState() {
		// TODO Auto-generated method stub
		return this.intrinsicState.isSurFaceState();
	}

}
