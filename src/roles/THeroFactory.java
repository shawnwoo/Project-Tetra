package roles;

public class THeroFactory implements TRoleFactory {

	@Override
	public THero maleFactory() {
		// TODO Auto-generated method stub
		return new THero(new TRover("male"));
	}

	@Override
	public THero femaleFactory() {
		// TODO Auto-generated method stub
		return new THero(new TRover("female"));
	}

}
