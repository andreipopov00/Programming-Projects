package Assignment_6;

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

/**
 * The MovieTicketManager class works with ArrayList of type Ticket
 * This class sorts the Ticket objects ascending by Day or by ID, 
 * it also reads data from a file, prints the monthly sales report 
 * and calculates the total sales of the ticket in a month.
 * @author Andrei Popov
 */
public class MovieTicketManager implements MovieTicketManagerInterface
{
	// Setting up the main ArrayList of the class
	private ArrayList<Ticket> ticketList;
	// Setting the displayed price format
	private DecimalFormat currencyFormat = new DecimalFormat("##0.00");
	
	/**
	 * Constructor for the MovieTicketManager class
	 */
	public MovieTicketManager()
	{
		this.ticketList = new ArrayList<>();
	}
	
	/**
	 * Returns the number of times this patron has visited the theater this month
	 * @param id id of the ticket applicable just for MoviePass and Employee ticket type 
	 * @return the number of times this patron has visited the theater this month
	 */
	public int numVisits(int id)
	{
		int numVisits = 0;
		
		// Passing through all the ArrayList objects
		for (int i = 0; i < ticketList.size(); i++)
		{
			if (ticketList.get(i).getId() == id)
			{
				numVisits++;
			}
		}
			
		return numVisits;
	}
	
	/**
	 * Returns the number of times the patron has seen this movie
	 * @param id the id of the Employee or MoviePass
	 * @param movie the movie to search for in ArrayList
	 * @return the number of times the patron has seen this movie
	 */
	public int numThisMovie(int id, String movie)
	{
		int numThisMovie = 0;
		// Passing through all the ArrayList objects
		for (int i = 0; i < ticketList.size(); i++)
		{
			if ((ticketList.get(i).getId() == id) && (ticketList.get(i).getMovieName().equals(movie)))
			{
				numThisMovie++;
			}
		}
		
		return numThisMovie;
	}
	
	/**
	 * Checks to see if this patron already saw a movie today
	 * @param id the id of the Employee or MoviePass
	 * @param date current date
	 * @return number of movies the patron has seen today
	 */
	public int numMoviesToday(int id, int date)
	{
		int numMoviesToday = 0;
		// Passing through all the ArrayList objects
		for (int i = 0; i < ticketList.size(); i++)
		{
			if ((ticketList.get(i).getId() == id) && (ticketList.get(i).getDay() == date))
			{
				numMoviesToday++;
			}
		}
		
		return numMoviesToday;
	}
	
	/**
	 * Adds a patron to the list and returns the ticket price
	 * @param movieN movie name
	 * @param rating holds the rating of the movie
	 * @param d date
	 * @param t time
	 * @param f format
	 * @param type type of patron
	 * @param id for identification number for movie pass or employee
	 * @return the price of the ticket. Returns a negative number if type is invalid
	 */
	public double addTicket(String movieN, String rating, int d, int t, String f, String type, int id)
	{
		if (type.equals("Adult"))
		{
			// Passing initial values to constructor
			Adult addAdultTicket = new Adult(movieN, rating, d, t, f, id);
			// Declaring and initiating the ticket price 
			double price = addAdultTicket.calculateTicketPrice();
			// Setting the price of the new object
			addAdultTicket.setPrice(price);
			// Adding the object to ArrayList
			ticketList.add(addAdultTicket);
			return price;
		} else if (type.equals("Child")) // Setting up the Child ticket object
		{
			// Passing initial values to constructor and declaring a new object
			Child addChildTicket = new Child(movieN, rating, d, t, f, id);
			// Declaring and initiating the ticket price
			double price = addChildTicket.calculateTicketPrice();
			// Setting the price of the new object
			addChildTicket.setPrice(price);
			// Adding the object to ArrayList
			ticketList.add(addChildTicket);
			return price;
		} else if (type.equals("Employee")) // Setting up the Employee ticket object
		{
			// Passing initial values to constructor and declaring a new employee ticket object
			Employee addEmployeeTicket = new Employee(movieN, rating, d, t, f, id, numVisits(id));
			// Declaring and initializing the ticket price
			double price = addEmployeeTicket.calculateTicketPrice();
			// Setting the price of the new object
			addEmployeeTicket.setPrice(price);
			// Adding the object to ArrayList
			ticketList.add(addEmployeeTicket);
			return price;
		} else if (type.equals("MoviePass")) // Setting up the MoviePass ticket object
		{
			// Passing initial values to constructor and declaring a new movie pass object
			MoviePass addMoviePass = new MoviePass(movieN, rating, d, t, f, id);
			// Declaring and initializing the price to 0
			double price = 0;
			
			/* If the holder of the movie ticket pass didn't attend a movie today,
			 * didn't saw the chosen movie before and the format of the movie is NONE,
			 * then set the price to 0 */
			if ((addMoviePass.getFormat().equals(Format.NONE)) && 
				(numThisMovie(id, movieN) == 0) && 
				(numMoviesToday(id, d) == 0))
			{
				// If this is the first movie watched with the pass, 
				// then set the price to $9.99
				if (numVisits(id) == 0)
				{
					price = 9.99;
					// Set the price of the new object
					addMoviePass.setPrice(price);
					// Add the new movie pass object to the ArrayList
					ticketList.add(addMoviePass);
					return price;
				}
				price = 0;
				// Set the price of the new object
				addMoviePass.setPrice(price);
				// Add the new movie pass object to the ArrayList
				ticketList.add(addMoviePass);
				return price;
			/* If any of the 3 rules described above wasn't met, 
			 * than charge at the Adult price*/	
			} else
			{
				// Calculate the price of the movie ticket based on Adult ticket rate
				price = addMoviePass.calculateTicketPrice();
				// Add the price to the new movie pass m=object
				addMoviePass.setPrice(price);
				// Add the new movie pass object ot the ArrayList
				ticketList.add(addMoviePass);
				return price;
			}
		// If the type didn't matched with any of the four described above, then return -1 
		} else return -1;
	}
	
	/**
	 * Returns the sales for the entire month
	 * @return the sales for the entire month
	 */
	public double totalSalesMonth()
	{
		double totalSales = 0;
		// Passing through every object of the ArrayList
		for (int i = 0; i < ticketList.size(); i++)
		{
			totalSales += ticketList.get(i).getPrice();
		}
		
		return totalSales;
	}
	
	/**
	 * Prints the monthly sales report
	 */
	public String monthlySalesReport()
	{
		// Accumulators for number of different types of movie tickets
		int numAdult = 0,
			numChild = 0,
			numEmployee = 0,
			numMoviePass = 0;
		
		// Accumulators for total sales of each type of movie tickets
		double salesAdult = 0,
			   salesChild = 0,
			   salesEmployee = 0,
			   salesMoviePass = 0;
		
		// Passing through every object of the ArrayList
		for (int i = 0; i < ticketList.size(); i++)
		{
			if (ticketList.get(i).getTicketType().equals("Adult"))
			{
				numAdult++;
				salesAdult += ticketList.get(i).getPrice();
			} else if (ticketList.get(i).getTicketType().equals("Child"))
			{
				numChild++;
				salesChild += ticketList.get(i).getPrice();
			} else if (ticketList.get(i).getTicketType().equals("Employee"))
			{
				numEmployee++;
				salesEmployee += ticketList.get(i).getPrice();
			} else if (ticketList.get(i).getTicketType().equals("MoviePass"))
			{
				numMoviePass++;
				salesMoviePass += ticketList.get(i).getPrice();
			} 
		}
		
		String report = "\tMonthly Sales Report\n\n\t\t\tSales\tNumber\n" + 
						"ADULT\t\t$" + currencyFormat.format(salesAdult) + "\t\t" + numAdult + "\n" +
						"CHILD\t\t$" + currencyFormat.format(salesChild) + "\t\t" + numChild + "\n" +
						"EMPLOYEE\t$" + currencyFormat.format(salesEmployee) + "\t\t" + numEmployee + "\n" +
						"MOVIEPASS\t$" + currencyFormat.format(salesMoviePass) + "\t\t" + numMoviePass + "\n\n" + 
						"Total Monthly Sales: $" + currencyFormat.format(totalSalesMonth());
		
		return report;
	}
	
	/**
	 * Returns an arraylist of strings that represent 3D tickets sorted by day
	 * @return an arraylist of strings that represent 3D tickets sorted by day
	 */
	public ArrayList<String> get3DTickets()
	{
		// Setting up a new ArrayList of Ticket type for 3D ticket objects
		ArrayList<Ticket> DDDTickets = new ArrayList<>();
		// Passing through every object of the ArrayList
		for (int i = 0; i < ticketList.size(); i++)
		{
			if (ticketList.get(i).getFormat().equals(Format.THREE_D))
			{
				DDDTickets.add(ticketList.get(i));
			}
		}
		// Sort the 3D ticket list by day
		sortByDay(DDDTickets);
		
		// Convert the array list of type Ticket into array list of type String
		ArrayList<String> DDDTicketsString = new ArrayList<>();
		// Passing through all the objects of the new 3D tickets ArrayList
		for (int i = 0; i < DDDTickets.size(); i++)
		{
			DDDTicketsString.add(DDDTickets.get(i).toString());
		}
		return DDDTicketsString;
	}
	
	/**
	 * Returns an arrayList of strings which represent tickets, in chronological order
	 * @return an arrayList of strings which represent tickets, in chronological order
	 */
	public ArrayList<String> getAllTickets()
	{
		// Setting up a new ArrayList of Ticket type for objects of all tickets
		ArrayList<Ticket> allTicketsList = new ArrayList<>();
		// Passing through every object of the ArrayList
		for (int i = 0; i < ticketList.size(); i++)
		{
			allTicketsList.add(ticketList.get(i));
		}
		
		// Sort all tickets list by day
		sortByDay(allTicketsList);
		// Convert the array list of type Ticket into array list of type String
		ArrayList<String> allTicketsListString = new ArrayList<>();
		// Passing through all the objects of the new ArrayList of all ticket objects
		for (int i = 0; i < allTicketsList.size(); i++)
		{
			allTicketsListString.add(allTicketsList.get(i).toString());
		}
		return allTicketsListString;
	}

	/**
	 * Returns an Arraylist of string representation of MoviePass tickets sorted by movieId
	 * @return an Arraylist of string representation of MoviePass tickets sorted by movieId
	 */
	public ArrayList<String> getMoviePassTickets()
	{
		// Setting up a new ArrayList of Ticket type for MoviePass objects
		ArrayList<Ticket> moviePassList = new ArrayList<>();
		// Passing through every object of the main ArrayList
		for (int i = 0; i < ticketList.size(); i++)
		{
			if (ticketList.get(i).getTicketType().equals("MoviePass"))
			{
				moviePassList.add(ticketList.get(i));
			}
		}
		
		// Sort movie pass list by ID
		sortById(moviePassList);
		// Convert the array list of type Ticket into array list of type String
		ArrayList<String> moviePassListString = new ArrayList<>();
		// Passing through every object of the new ArrayList of movie pass
		for (int i = 0; i < moviePassList.size(); i++)
		{
			moviePassListString.add(moviePassList.get(i).toString());
		}
		return moviePassListString;
	}
	
	/**
	 * Reads from a file and populates an arraylist of Ticket objects
	 * @param file file to be read from
	 * @throws FileNotFoundException when file is not found
	 */
	public void readFile(File file) throws FileNotFoundException
	{
		// Declaring and initializing a scanner
		Scanner input = new Scanner(file);
		while (input.hasNextLine()) 
		{
			// Declaring and initializing an array of type String
			String[] ticket = input.nextLine().split(":");
			//Adding the content of the file to the String array
			addTicket(ticket[0], 
					  ticket[1], 
					  Integer.parseInt(ticket[2]), 
					  Integer.parseInt(ticket[3]),
					  ticket[4],
					  ticket[5],
					  Integer.parseInt(ticket[6]));
		}
		input.close();
	}
	
	/**
	 * @return the ticketList
	 */
	public ArrayList<Ticket> getTicketList()
	{
		return ticketList;
	}
	
	/**
	 * Selection sort algorithm that sorts an array list of tickets by day
	 * @param list an array list of type tickets that will be sorted by day parameter
	 */
	private void sortByDay(ArrayList<Ticket> list)
	{
		int last,
			max = 0;
		
		for (last = list.size() - 1; last >= 0; last--)
		{
			max = 0;
			for (int i = 0; i <= last; i++)
			{
				if ((list.get(max).getDay()) < (list.get(i).getDay()))
					max = i;
			}
			//swap list in last position with the last chronologically
	        Ticket tempList = list.get(last);
	        list.set(last, list.get(max));
	        list.set(max, tempList);
		}
	}
	
	/**
	 * Selection sort algorithm that sorts an array list of tickets by ID
	 * @param list an array list of type tickets that will be sorted by ID parameter
	 */
	private void sortById(ArrayList<Ticket> list)
	{
		int last,
			max = 0;
		
		for (last = list.size() - 1; last >= 0; last--)
		{
			max = 0;
			for (int i = 0; i <= last; i++)
			{
				if ((list.get(max).getId()) < (list.get(i).getId()))
					max = i;
			}
			//swap list in last position with the last chronologically
	        Ticket tempList = list.get(last);
	        list.set(last, list.get(max));
	        list.set(max, tempList);
		}
	}
}