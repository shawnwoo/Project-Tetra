package starMap;

import java.util.Date;

import roles.THero;

public class StarMap implements StarMapInterface {

	private Header header = new Header();
	private String directions;
	private String map;
	private boolean isEncrypted = false;

	@Override
	public StarSignal showSignal(String MapId) {
		// TODO Auto-generated method stub
		return null;

	}

	/**
	 * @return the header
	 */
	public Header getHeader() {
		return header;
	}

	/**
	 * @param header
	 *            the header to set
	 */
	public void setHeader(Header header) {
		this.header = header;
	}

	/**
	 * @return the directions
	 */
	public String getDirections() {
		return directions;
	}

	/**
	 * @param directions
	 *            the directions to set
	 */
	public void setDirections(String directions) {
		this.directions = directions;
	}

	/**
	 * @return the map
	 */
	public String getMap() {
		return map;
	}

	/**
	 * @param map
	 *            the map to set
	 */
	public void setMap(String map) {
		this.map = map;
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		if (this.isEncrypted()) {
			System.out.println("This map is encryped");
		} else {
			System.out.println("ID: " + header.getTHero().getId());
			System.out.println("Date: " + header.getDateOfEncrypt().toString());
			System.out.println("Text: " + this.getDirections());
		}
	}

	@Override
	public void encrypt(THero hero) {

		header.setTHero(hero);
		header.setDateOfEncrypt(new Date());
		this.setDirections(hero.getEncryptStragety().encrypt(
				this.getDirections()));

		this.isEncrypted = true;

	}

	@Override
	public void decrypt(THero hero) {
		// TODO Auto-generated method stub

		if (hero == header.getTHero()) {
			this.setDirections(hero.getEncryptStragety().decrypt(
					this.getDirections()));
			this.isEncrypted = false;
		} else {
			System.out
					.println("This is not the same hero who encrypt the map!");
		}

	}

	public boolean isEncrypted() {
		return this.isEncrypted;
	}

	@Override
	public StarMapInterface getNode() {
		// TODO Auto-generated method stub
		return this;
	}

}
