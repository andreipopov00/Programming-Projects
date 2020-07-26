package Assignment_6;

import java.text.DecimalFormat;
/**
 * The Ticket class is an abstract class that
 * holds general data about any ticket.
 * @author Andrei Popov
 */
public abstract class Ticket 
{	
	protected Format format;
	protected String movieName, 
					 movieRating,
					 ticketType;
	protected int day,
			      time,
			      id;
	protected double price;
	protected final int EVENING = 18; // Holds the time for late night movies after 6PM
	protected final double TAX = 0.096; // Tax rate of 9.6%
	
	/**
	 * Abstract class which will be overridden in the inherited subclasses
	 * @return the price for a specific ticket
	 */
	public abstract double calculateTicketPrice();
	
	/**
	 * Abstract class which will be overridden in the inherited subclasses
	 * @return ID of the employee or movie pass
	 */
	public abstract int getId();
	
	/**
	 * Default (no-arg) constructor
	 */
	public Ticket()
	{
		this.movieName = "";
		this.movieRating = "";
		this.day = 1;
		this.time = 8;
		this.format = Format.NONE;
		this.ticketType = "Ticket";
		this.id = -1;
		this.price = -1;
		
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
	public Ticket(String name, String rating, int day, int time, Format format, int ID)
	{
		this.movieName = name;
		this.movieRating = rating;
		this.day = day;
		this.time = time;
		this.format = format;
		this.ticketType = "Ticket";
		this.id = ID;
		this.price = -1;
	}
	
	/**
	 * @return the format of the movie
	 */
	public Format getFormat()
	{
		return format;
	}
	
	/**
	 * @param f the value to store in format
	 */
	public void setFormat(Format f)
	{
		this.format = f;
	}
	
	/**
	 * @return the value stored in the movieName field
	 */
	public String getMovieName()
	{
		return movieName;
	}
	
	/**
	 * @param n the value to store in movieName
	 */
	public void setMovieName(String n)
	{
		this.movieName = n;
	}
	
	
	/**
	 * @return the value stored in the movieRating field
	 */
	public String getMovieRating()
	{
		return movieRating;
	}
	
	/**
	 * @param r the value to store in movieRating
	 */
	public void setMovieRating(String r)
	{
		this.movieRating = r;
	}
	
	/**
	 * @return the value stored in the ticketType field
	 */
	public String getTicketType()
	{
		return ticketType;
	}
	
	/**
	 * @param t the value to store in the ticketType
	 */
	public void setTicketType(String t)
	{
		this.ticketType = t;
	}
	
	/**
	 * @return the value stored in the day field
	 */
	public int getDay()
	{
		return day;
	}
	
	/**
	 * @param d the value to store in the day field
	 */
	public void setDay(int d)
	{
		this.day = d;
	}
	
	/**
	 * @return the value stored in the time field
	 */
	public int getTime()
	{
		return time;
	}
	
	/**
	 * @param t the value to store in the time field
	 */
	public void setTime(int t)
	{
		this.time = t;
	}
	
	/**
	 * @return the value stored in the price field
	 */
	public double getPrice()
	{
		return price;
	}
	
	/**
	 * @param p the value to store in the price field
	 */
	public void setPrice(double p)
	{
		this.price = p;
	}

	/**
	 * @param ID the value to store in the id field
	 */
	public void setId(int ID)
	{
		this.id = ID;
	}
	
	/**
	 * The toString method which will be used in the subclasses of the super class Ticket
	 */
	@Override
	public String toString()
	{
		// to store string values of movie format such as IMAX, 3D or none
		String movieFormat = "";
		// to store string values of ticket type such as Adult, Child, Employee or MoviePass
		String type = ticketType.toUpperCase();
		// to convert the price into a currency format
		DecimalFormat dollar = new DecimalFormat("##0.00");
		
		if (format.equals(Format.IMAX))
		{
			movieFormat = "IMAX";
		} else if (format.equals(Format.THREE_D))
		{
			movieFormat = "3D";
		}
		
		if (getId() != -1)
		{
			type += "-" + id;
		}
		
		return type + " " + movieFormat + " Movie: " + movieName + " Rating: " + movieRating 
				+ " Day: " + day + " Time: " + time + " Price: $" + dollar.format(price); 
	}
}
