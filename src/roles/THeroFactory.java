package roles;

public class THeroFactory implements TRoleFactory {

	@Override
	public TInhabitant maleFactory() {
		// TODO Auto-generated method stub
		return new THero(new TRover("male"));
	}

	@Override
	public TInhabitant femaleFactory() {
		// TODO Auto-generated method stub
		return new THero(new TRover("female"));
	}

}
