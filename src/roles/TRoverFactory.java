package roles;

public class TRoverFactory implements TRoleFactory {

	@Override
	public TRover maleFactory() {
		// TODO Auto-generated method stub
		return new TRover("male");
	}

	@Override
	public TRover femaleFactory() {
		// TODO Auto-generated method stub
		return new TRover("female");
	}

}
