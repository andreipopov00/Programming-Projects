/** 
* The purpose of this class is to model a television
* Date: 6/18/2020
* @author Andrei Popov
*/

public class Television 
{
	private final String MANUFACTURER; //Brand name of the manufacturer
	private final int SCREEN_SIZE; //Size of the television screen
	private boolean powerOn; //To hold the value if the TV is on or off
	private int channel;  //Holds the value of the station that the television is showing
	private int volume; //Holds value representing the loudness 
	
	/**
	 * The Constructor sets the brand name, screen size of TV,
	 * power value to off, volume to value 20 and channel to station 2. 
	 * @param brand The name of manufacturer
	 * @param size The TV's screen size
	 */
	public Television(String brand, int size)
	{
		MANUFACTURER = brand;
		SCREEN_SIZE = size;
		powerOn = false;
		volume = 20;
		channel = 2;
	}
	
	/**
	 * The setChannel method sets the value of the station
	 * that the TV is currently showing.
	 * @param station TV's channel
	 */
	public void setChannel(int station)
	{
		channel = station;
	}
	
	/**
	 * The power method changes the state of TV 
	 * from turned on to turned off or
	 * from turned off to turned on.
	 */
	public void power()
	{
		if (powerOn)
			powerOn = !powerOn;
		else powerOn = !powerOn;
	}
	
	/**
	 * The increaseVolume method increases the TV's volume by 1.
	 */
	public void increaseVolume()
	{
		++volume;
	}
	
	/**
	 * The increaseVolume method decreases the TV's volume by 1.
	 */
	public void decreaseVolume()
	{
		--volume;
	}
	
	/**
	 * The getChannel method 
	 * @return The TV's channel currently showing
	 */
	public int getChannel()
	{
		return channel;
	}
	
	/**
	 * The getVolume method
	 * @return The TV's volume
	 */
	public int getVolume()
	{
		return volume;
	}
	
	/**
	 * The getScreenSize method
	 * @return The size of TV's screen
	 */
	public int getScreenSize()
	{
		return SCREEN_SIZE;
	}
	
	/**
	 * the getManufacturer method
	 * @return The name of TV's manufacturer 
	 */
	public String getManufacturer()
	{
		return MANUFACTURER;
	}
}
