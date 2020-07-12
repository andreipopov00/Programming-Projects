package Assignment_4;

/**
 * Represents management company object 
 * @author Andrei Popov
 *
 */
public class ManagementCompany 
{
	private final int MAX_PROPERTY = 5;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private double mgmFeePer;
	private String name;
	private String taxID;
	private Plot plot;
	private Property[] properties;

	/**
	 * No-Arg Constructor that creates a ManagementCompany object 
	 * using empty strings and a default Plot. "properties" array is initialized here as well. 
	 */
	public ManagementCompany() 
	{
		this.plot = new Plot();
		this.properties = new Property[MAX_PROPERTY];
		this.name = "";
		this.taxID = "";
		this.mgmFeePer = 0;
	}

	/**
	 * Constructor Creates a ManagementCompany object using the passed information. 
	 * Mgmt Co plot is initialized to default Plot. "properties" array is initialized here as well. 
	 * @param name management company name
	 * @param taxID tax id
	 * @param mgmFee management fee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
	}

	/**
	 * Constructor Creates a ManagementCompany object using the passed information. "properties" array is initialized here as well. 
	 * @param name management company name
	 * @param taxID tax id
	 * @param mgmFee management fee
	 * @param x the x-value of the property's plot
	 * @param y the y-value of the property's plot
	 * @param width the horizontal size of the property's plot
	 * @param depth the vertical size of the property's plot
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
	{
		this.properties = new Property[MAX_PROPERTY];
		this.name = name;
		this.taxID = taxID;
		this.mgmFeePer = mgmFee;
		this.plot = new Plot(x, y, width, depth);
	}
	
	/**
	 * Copy Constructor creates a ManagementCompany object using another ManagementCompany object. 
	 * "properties" array is initialized here as well. 
	 * @param otherCompany another management company
	 */
	public ManagementCompany(ManagementCompany otherCompany)
	{
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(otherCompany.plot);
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFeePer = otherCompany.mgmFeePer;
	}
	
	/**
	 * Return the MAX_PROPERTY constant that represent the size of the "properties" array. 
	 * @return the MAX_PROPERTY a constant attribute for this class that is set 5
	 */
	public int getMAX_PROPERTY() 
	{
		return MAX_PROPERTY;
	}

	/**
	 * returns the plot object	
	 * @return the Plot object
	 */
	public Plot getPlot() 
	{
		return plot;
	}

	/**
	 * returns the management company name
	 * @return the management company name
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * Adds the property object to the "properties" array. 
	 * @param property a property object 
	 * @return Returns either -1 if the array is full, -2 if property is null, 
	 * -3 if the plot is not contained by the MgmtCo plot, 
	 * -4 of the plot overlaps any other property, 
	 * or the index in the array where the property was added successfully. 
	 */
	public int addProperty(Property property)
	{
		if (property == null)
			return -2;
  
		if (!plot.encompasses(property.getPlot()))
			return -3;

		for (int i = 0; i < properties.length; i++) 
		{
			if (properties[i] != null) 
			{
				if (properties[i].getPlot().overlaps(property.getPlot()))
				{
					return -4;
				}
				
			} else 
			{
				properties[i] = property;
				return i;
			} 
		}
		return -1;
	}

	/**
	 * Creates a property object and adds it to the "properties" array, in a default plot. 
	 * @param propertyName property name
	 * @param city location of the property
	 * @param rent monthly rent 
	 * @param owner owner of the property 
	 * @return Returns either -1 if the array is full, -2 if property is null, 
	 * -3 if the plot is not contained by the MgmtCo plot, 
	 * -4 of the plot overlaps any other property, 
	 * or the index in the array where the property was added successfully.
	 */
	public int addProperty(String propertyName, String city, double rent, String owner) 
	{
		return addProperty(new Property(propertyName, city, rent, owner));
	}


	/**
	 * Creates a property object and adds it to the "properties" array. 
	 * @param propertyName - property name
	 * @param city location of the property
	 * @param rent monthly rent 
	 * @param owner owner of the property 
	 * @param x x location of upper left corner of property's plot 
	 * @param y y location of upper left corner of property's plot 
	 * @param width width of the property's plot 
	 * @param depth depth of the property's plot 
	 * @return Returns either -1 if the array is full, -2 if property is null, 
	 * -3 if the plot is not contained by the MgmtCo plot, 
	 * -4 of the plot overlaps any other property, 
	 * or the index in the array where the property was added successfully.
	 */
	public int addProperty(String propertyName, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		return addProperty(new Property(propertyName, city, rent, owner, x, y, width, depth));
	}

	/**
	 * This method accesses each "Property" object within the array "properties" 
	 * and sums up the property rent and returns the total amount. 
	 * @return total rent
	 */
	public double totalRent() 
	{
		double totalRent = 0;
		for (int i = 0; i < properties.length; i++) 
		{
			if (properties[i] == null) 
				break;

			totalRent += properties[i].getRentAmount();
		}
		return totalRent;
	}

	/**
	 * This method finds the index of the property with the maximum rent amount. 
	 * NOTE: For simplicity assume that each "Property" object's rent amount is different. 
	 * @return the index of the property with the maximum rent amount
	 */
	public int maxRentPropertyIndex() 
	{
		int index = -1;
		double max = 0;
		for (int i = 0; i < properties.length; i++) 
		{
			if (properties[i] == null) 
				break;

			if (properties[i].getRentAmount() > max) 
			{
				max = properties[i].getRentAmount();
				index = i;
			}
		}
		return index;
	}

	/**
	 * This method finds the property with the maximum rent amount and returns its toString result
	 * @return the maximum rent amount
	 */
	public String maxRentProp() 
	{
		return properties[maxRentPropertyIndex()].toString();
	}

	/**
	 * Displays the information of the property at index
	 * @param index the index of the property within the array "properties" 
	 * @return information of the property at index
	 */
	public String displayPropertyAtIndex(int index) 
	{
		return properties[index].toString();
	}

	/**
	 * Displays the information of all the properties in the "properties" array.
	 * @return  information of ALL the properties within this management company by accessing the "Properties" array
	 */
	public String toString() 
	{
		String propertyList = "";
		for (int i = 0; i < MAX_PROPERTY; i++) 
		{
			if (properties[i]==null) 
				break;
			 
			propertyList += properties[i] + "\n"; 
		}

		return "List of the properties for " + name + ", taxID: " + taxID

				+ "\n__________________________________________________\n"

      			+ propertyList +  "__________________________________________________\n"

      			+ "total management Fee: " + (totalRent() * mgmFeePer / 100);

	}
}