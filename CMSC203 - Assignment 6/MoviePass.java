package Assignment_6;

/**
 * MoviePass class represents all details of a movie pass
 * @author Andrei Popov
 */
public class MoviePass extends Ticket
{
	private final double MORNING_PRICE = 10.50, // ticket price before 6PM 
						 EVENING_PRICE = 13.50, // ticket price after 6PM
						 IMAX_PRICE = 3.00, // ticket price for IMAX
						 DDD_PRICE = 2.50; // ticket price for 3D
	/**
	 * Default (no-arg) constructor
	 */
	public MoviePass()
	{
		super.ticketType = "MoviePass";
	}
	
	/**
	 * Constructor for MoviePass class with the same parameter format, but as of String type
	 * @param name holds the name of the movie
	 * @param rating holds the rating of the movie
	 * @param day the chosen day for watching the movie
	 * @param time the chosen time for watching the movie
	 * @param format type of the movie as 3D, IMAX or none
	 * @param ID for identification number for movie pass or employee
	 */
	public MoviePass(String name, String rating, int day, int time, String format, int ID)
	{
		super.ticketType = "MoviePass";
		super.movieName = name;
		super.movieRating = rating;
		super.day = day;
		super.time = time;
		super.id = ID;
		
		// Deciding which format to set based on the string format parameter
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
	public MoviePass(String name, String rating, int day, int time, Format format, int ID)
	{
		super(name, rating, day, time, format, ID);
		super.ticketType = "MoviePass";
	}
	
	
	@Override
	/**
	 * Returns the MoviePass ID field
	 */
	public int getId()
	{
		return id;
	}
	
	@Override
	/**
	 * Returns the overall price for MoviePass ticket depending on the choice
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
		// Return the price of the ticket with the TAX included
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