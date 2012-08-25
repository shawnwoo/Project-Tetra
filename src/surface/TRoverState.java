package surface;

public class TRoverState implements LocationState{

	@Override
	public String showState() {
		// TODO Auto-generated method stub
		return "Rover";
	}

	@Override
	public int getStateNum() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public boolean isSurFaceState() {
		// TODO Auto-generated method stub
		return false;
	}

}
