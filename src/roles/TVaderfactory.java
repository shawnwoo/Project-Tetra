package roles;

public class TVaderfactory implements TRoleFactory {

	@Override
	public TVader maleFactory() {
		// TODO Auto-generated method stub
		return new TVader(new TRover("male"));
	}

	@Override
	public TVader femaleFactory() {
		// TODO Auto-generated method stub
		return new TVader(new TRover("female"));
	}

}
