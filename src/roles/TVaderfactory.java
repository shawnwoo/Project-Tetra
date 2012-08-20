package roles;

public class TVaderfactory implements TRoleFactory {

	@Override
	public TInhabitant maleFactory() {
		// TODO Auto-generated method stub
		return new TVader(new TRover("male"));
	}

	@Override
	public TInhabitant femaleFactory() {
		// TODO Auto-generated method stub
		return new TVader(new TRover("female"));
	}

}
