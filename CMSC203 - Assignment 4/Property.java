package Assignment_4;

/**
 * Represents a Property object 
 * @author Andrei Popov
 *
 */
public class Property 
{
	private String city, owner, propertyName;
	private double rentAmount;
	private Plot plot;
	
	/**
	 * No-arg Constructor, creates a new object with default values of empty strings, 0 for rent amount, and default Plot 
	 */
	public Property()
	{
		this.city = "";
		this.owner = "";
		this.propertyName = "";
		this.rentAmount = 0;
		this.plot = new Plot();
	}
	
	/**
	 * Copy Constructor, creates a new object using the information of the object passed to it. 
	 * @param p a Property object
	 */
	public Property(Property p)
	{
		this.city = p.city;
		this.owner = p.owner;
		this.propertyName = p.propertyName;
		this.rentAmount = p.rentAmount;
		this.plot = new Plot(p.plot);
	}
	
	/**
	 * Constructor, Parameterized constructor with no Plot information (uses default Plot where x,y are set to 0, width and depth set to 1)
	 * @param propertyName property name
	 * @param city city where the property is located
	 * @param rentAmount rent amount
	 * @param owner the owner's name
	 */
	public Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		this.plot = new Plot();
	}
	
	/**
	 * Constructor, Parameterized constructor 
	 * @param propertyName property name
	 * @param city city where the property is located
	 * @param rentAmount rent amount
	 * @param owner the owner's name
	 * @param x the x-value of the property's plot
	 * @param y the y-value of the property's plot
	 * @param width the horizontal size of the property's plot
	 * @param depth the vertical size of the property's plot
	 */
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
	{
		this.city = city;
		this.owner = owner;
		this.propertyName = propertyName;
		this.rentAmount = rentAmount;
		this.plot = new Plot(x, y, width, depth);
	}
	
	/**
	 * Return the property Name 
	 * @return the propertyName
	 */
	public String getPropertyName()
	{
		return propertyName;
	}
	
	/**
	 * Set the property name 
	 * @param propertyName the propertyName to set
	 */
	public void setPropertyName(String propertyName)
	{
		this.propertyName = propertyName;
	}
	
	/**
	 * return the city 
	 * @return the city
	 */
	public String getCity()
	{
		return city;
	}
	
	/**
	 * set the city 
	 * @param city the city to set
	 */
	public void setCity(String city)
	{
		this.city = city;
	}
	
	/**
	 * return the rent amount
	 * @return the rentAmount
	 */
	public double getRentAmount()
	{
		return rentAmount;
	}
	
	/**
	 * set the rent amount 
	 * @param rentAmount the rentAmount to set
	 */
	public void setRentAmount(double rentAmount)
	{
		this.rentAmount = rentAmount;
	}
	
	/**
	 * return the owner name 
	 * @return the owner
	 */
	public String getOwner()
	{
		return owner;
	}
	
	/**
	 * set the owner name 
	 * @param owner the owner to set
	 */
	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	
	/**
	 * set the Plot values 
	 * @param x the x-value of the property's plot
	 * @param y the y-value of the property's plot
	 * @param width the horizontal size of the property's plot
	 * @param depth the vertical size of the property's plot
	 * @return the Plot for the property
	 */
	public Plot setPlot(int x, int y, int width, int depth)
	{
		plot = new Plot(x, y, width, depth);
		return plot;
	}
	
	/**
	 * return the plot object	
	 * @return Plot object
	 */
	public Plot getPlot()
	{
		return plot;
	}
	
	@Override
	/**
	 * Prints out the name, city, owner and rent amount for a property 
	 * @return the string representation of a Property object in the following format:
     *         Property Name: propertyName
     *         Located in city
     *         Belonging to: owner
     *         Rent Amount: rentAmount 
	 */
	public String toString() 
	{
		return "Property Name: " + propertyName + "\nLocated in " + city 
				+ "\nBelonging to: " + owner + "\nRent Amount: " + rentAmount + " ";
	}
}
