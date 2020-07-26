package Assignment_6;

/**
 * Adult class represents all details of an adult ticket
 * @author Andrei Popov
 */
public class Adult extends Ticket
{
	private final double MORNING_PRICE = 10.50, // ticket price before 6PM 
						 EVENING_PRICE = 13.50, // ticket price after 6PM
						 IMAX_PRICE = 3.00, // ticket price for IMAX
						 DDD_PRICE = 2.50; // ticket price for 3D
	/**
	 * Default (no-arg) constructor
	 */
	public Adult()
	{
		super.ticketType = "Adult";
	}
	
	/**
	 * Constructor
	 * @param name holds the name of the movie
	 * @param rating holds the rating of the movie
	 * @param day the chosen day for watching the movie
	 * @param time the chosen time for watching the movie
	 * @param format type of the movie as 3D, IMAX or none
	 * @param ID for identification number for movie pass or employee
	 */
	public Adult(String name, String rating, int day, int time, String format, int ID)
	{
		super.ticketType = "Adult";
		super.movieName = name;
		super.movieRating = rating;
		super.day = day;
		super.time = time;
		super.id = getId();
		
		// Deciding which format to set based on the string parameter
		if (format.contentEquals("IMAX"))
		{
			super.format = Format.IMAX;
		} else if (format.contentEquals("3D"))
		{
			super.format = Format.THREE_D;
		} else if (format.contentEquals("NONE"))
		{
			super.format = Format.NONE;
		}
	}
	
	/**
	 * Constructor
	 * @param name holds the name of the movie
	 * @param rating holds the rating of the movie
	 * @param day the chosen day for watching the movie
	 * @param time the chosen time for watching the movie
	 * @param format type of the movie as 3D, IMAX or none
	 * @param ID for identification number for movie pass or employee
	 */
	public Adult(String name, String rating, int day, int time, Format format, int ID)
	{
		super(name, rating, day, time, format, ID);
		super.ticketType = "Adult";
	}
	
	
	@Override
	/**
	 * Returns -1 for Adult ID field
	 */
	public int getId()
	{
		return -1;
	}
	
	@Override
	/**
	 * Returns the overall price for Adult ticket depending on the choice
	 */
	public double calculateTicketPrice()
	{
		double price = 0.0;
		
		// Set initial price depending on the movie time
		if (time < EVENING)
		{
			price = MORNING_PRICE;
		} else
		{
			price = EVENING_PRICE;
		}
		
		// Adding additional charge to price for specific movie format
		if (format.equals(Format.THREE_D))
		{
			price += DDD_PRICE;
		} else if (format.equals(Format.IMAX))
		{
			price += IMAX_PRICE;
		}
		
		return price + (price * TAX);
	}
	
	@Override 
	/**
	 * Overriding the toString method from the super class
	 */
	public String toString()
	{
		return super.toString();
	}
}