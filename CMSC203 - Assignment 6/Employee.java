package Assignment_6;

/**
 * Employee class represents all details of an employee ticket
 * @author Andrei Popov
 */
public class Employee extends Ticket
{
	private final double MORNING_PRICE = 5.25, // ticket price before 6PM 
						 EVENING_PRICE = 6.75, // ticket price after 6PM
						 IMAX_PRICE = 1.50, // ticket price for IMAX
						 DDD_PRICE = 1.25; // ticket price for 3D
	private int moviesWatched = 0; //Counter for the number of movies seen
	
	/**
	 * Default (no-arg) constructor
	 */
	public Employee()
	{
		super.ticketType = "Employee";
	}
	
	/**
	 * Constructor for employee class with an additional parameter, 
	 * which is watched for counting the number of seen movies   
	 * @param name holds the name of the movie
	 * @param rating holds the rating of the movie
	 * @param day the chosen day for watching the movie
	 * @param time the chosen time for watching the movie
	 * @param format type of the movie as 3D, IMAX or none
	 * @param ID the identification number of the employee
	 * @param watched the number of movie watched in total
	 */
	public Employee(String name, String rating, int day, int time, String format, int ID, int watched)
	{
		super.ticketType = "Employee";
		super.movieName = name;
		super.movieRating = rating;
		super.day = day;
		super.time = time;
		super.id = ID;
		moviesWatched = watched;
		
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
	public Employee(String name, String rating, int day, int time, Format format, int ID)
	{
		super(name, rating, day, time, format, ID);
		super.ticketType = "Employee";
	}
	
	
	@Override
	/**
	 * Returns the Employee ID
	 */
	public int getId()
	{
		return this.id;
	}
	
	@Override
	/**
	 * Returns the overall price for Employee ticket depending on the choice
	 */
	public double calculateTicketPrice()
	{
		double price = 0.0;
		
		// If the number of movies watched is greater or equal to 2,
		// then set the price as half-priced Adult ticket
		if (moviesWatched >= 2)
		{
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
		// If number of previously movies watched is less than 2,
		// then set the price equal to 0 (FREE Ticket)
		} else price = 0.0;
		
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