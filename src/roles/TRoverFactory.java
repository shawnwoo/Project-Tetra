package roles;

public class TRoverFactory implements TRoleFactory {

	@Override
	public TInhabitant maleFactory() {
		// TODO Auto-generated method stub
		return new TRover("male");
	}

	@Override
	public TInhabitant femaleFactory() {
		// TODO Auto-generated method stub
		return new TRover("female");
	}

}
