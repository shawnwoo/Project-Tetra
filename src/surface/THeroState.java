package surface;

public class THeroState implements LocationState{

	@Override
	public String showState() {
		// TODO Auto-generated method stub
		return "hero";
	}

	@Override
	public int getStateNum() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public boolean isSurFaceState() {
		// TODO Auto-generated method stub
		return false;
	}

}
