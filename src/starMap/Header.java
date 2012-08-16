package starMap;
import java.util.Date;

import surface.Location;
import roles.THero;

public class Header {
	private String ID;
	private Location Location;
	private int numerOfItems ;
	private THero THero;
	private Date dateOfEncrypt;
	private int restorationCounter;
	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
	}
	/**
	 * @return the location
	 */
	public Location getLocation() {
		return Location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		Location = location;
	}
	/**
	 * @return the numerOfItems
	 */
	public int getNumerOfItems() {
		return numerOfItems;
	}
	/**
	 * @param numerOfItems the numerOfItems to set
	 */
	public void setNumerOfItems(int numerOfItems) {
		this.numerOfItems = numerOfItems;
	}
	/**
	 * @return the tHero
	 */
	public THero getTHero() {
		return THero;
	}
	/**
	 * @param tHero the tHero to set
	 */
	public void setTHero(THero tHero) {
		THero = tHero;
	}
	/**
	 * @return the dateOfEncrypt
	 */
	public Date getDateOfEncrypt() {
		return dateOfEncrypt;
	}
	/**
	 * @param dateOfEncrypt the dateOfEncrypt to set
	 */
	public void setDateOfEncrypt(Date dateOfEncrypt) {
		this.dateOfEncrypt = dateOfEncrypt;
	}
	/**
	 * @return the restorationCounter
	 */
	public int getRestorationCounter() {
		return restorationCounter;
	}
	/**
	 * @param restorationCounter the restorationCounter to set
	 */
	public void setRestorationCounter(int restorationCounter) {
		this.restorationCounter = restorationCounter;
	}
	
	
	

}
