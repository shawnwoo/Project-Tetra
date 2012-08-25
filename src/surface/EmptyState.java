package surface;

public class EmptyState implements LocationState {

	@Override
	public String showState() {
		// TODO Auto-generated method stub
		return "EMPTY";
	}

	@Override
	public int getStateNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isSurFaceState() {
		// TODO Auto-generated method stub
		return true;
	}

}
