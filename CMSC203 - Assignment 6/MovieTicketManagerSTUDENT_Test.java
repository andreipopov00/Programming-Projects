package Assignment_6;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MovieTicketManagerSTUDENT_Test 
{
	private MovieTicketManager ticketList;
	
	@Before
	public void setUp() throws Exception {
		ticketList = new MovieTicketManager();
		
		// Add adult tickets
		ticketList.addTicket("Deadpool", "PG13", 4, 12, "3D", "Adult", 0);
        ticketList.addTicket("Mule", "R", 23, 17,"IMAX", "Adult", 0);
        ticketList.addTicket("The Suicide Squad", "R", 10, 22, "NONE", "Adult", 0);
        
		// Add children tickets
        ticketList.addTicket("Sonic the Hedgehog", "PG13", 6, 20, "NONE","Child",0);
        ticketList.addTicket("Frozen II", "G", 1, 9,"3D","Child", 0);
        ticketList.addTicket("Cars II", "G", 17, 12, "IMAX", "Child", 0);
        
		// Add employee tickets
        ticketList.addTicket("Black Panther", "PG13", 11, 18,"NONE", "Employee", 00100);
        ticketList.addTicket("Aquaman", "NR", 30, 16, "IMAX", "Employee", 00200);
        ticketList.addTicket("The Insult", "R", 12, 12,"NONE","Employee", 00300);
        ticketList.addTicket("The Insult", "R", 12, 14,"NONE","Employee", 00300);
	    ticketList.addTicket("The Insult", "R", 12, 16,"NONE","Employee", 00300);
	    ticketList.addTicket("The Insult", "R", 15, 12,"NONE","Employee", 00300);
        
		// Add MoviePass member tickets
        ticketList.addTicket("Black Panther", "PG13", 13, 13, "3D", "MoviePass", 33333);
        ticketList.addTicket("Loveless", "NR", 5, 22,"NONE", "MoviePass", 44444);
        ticketList.addTicket("Black Panther", "PG13", 18, 13, "IMAX", "MoviePass", 33333);
	}

	@After
	public void tearDown() throws Exception {
		// Set ticketList to null;
		ticketList.getTicketList().clear();
	}

	/**
	 * Test the number of visits to the theater within the month
	 * This only applied to those who have id members - Employees or MoviePass members
	 */
	@Test
	public void testNumVisits() {
		// Test Employees' number of visits
		  assertEquals(1, ticketList.numVisits(00100));
	      ticketList.addTicket("Midnight Sun", "R", 11, 22,"IMAX","Employee", 00400);
	      assertEquals(1, ticketList.numVisits(00400));
	      ticketList.addTicket("Revenge", "R", 21, 21,"IMAX","Employee", 00400);
	      assertEquals(2, ticketList.numVisits(00400));    
			
	    // Test MoviePass members' number of visits
	      assertEquals(1, ticketList.numVisits(44444));
	      ticketList.addTicket("Truth or Dare", "NR", 1, 8, "3D", "MoviePass", 33333);
	      assertEquals(3, ticketList.numVisits(33333));
	      ticketList.addTicket("Terminal", "R", 7, 23, "NONE", "MoviePass", 33333);
	      assertEquals(4, ticketList.numVisits(33333));
	}

	
	/**
	 * Test the number of times this movie has been viewed
	 * This only applied to those who have id numbers - Employees or MoviePass members
	 */
	@Test
	public void testNumThisMovie() {
		// Test Employees' number of views
		 assertEquals(1, ticketList.numThisMovie(00100,"Black Panther"));
	     assertEquals(1, ticketList.numThisMovie(00200,"Aquaman"));
	     assertEquals(4, ticketList.numThisMovie(00300,"The Insult"));
		
		// Test MoviePass members' number of views
	     assertEquals(1, ticketList.numThisMovie(44444, "Loveless"));
	     assertEquals(2, ticketList.numThisMovie(33333, "Black Panther"));
	     ticketList.addTicket("Black Panther", "PG13", 21, 14, "IMAX", "MoviePass", 33333);
	     assertEquals(3, ticketList.numThisMovie(33333,"Black Panther"));
	}
	
	/**
	 * Test the number of movies attended on a day
	 * This only applied to those who have id members - Employees or MoviePass members
	 */
	@Test
	public void testNumMoviesToday() {
	// Test Employees' number of views today
	  assertEquals(1, ticketList.numMoviesToday(00100, 11));
      assertEquals(1, ticketList.numMoviesToday(00200, 30));
      ticketList.addTicket("Aquaman", "NR", 30, 17, "IMAX", "Employee", 00200);
      ticketList.addTicket("Aquaman", "NR", 30, 19, "IMAX", "Employee", 00200);
      assertEquals(3, ticketList.numMoviesToday(00200, 30));
      assertEquals(3, ticketList.numMoviesToday(00300, 12));

   // Test MoviePass members' number of views today
     assertEquals(1, ticketList.numMoviesToday(44444,5));
     ticketList.addTicket("Terminal", "PG", 5, 17, "3D", "MoviePass", 44444);
     assertEquals(2, ticketList.numMoviesToday(44444, 5));
     ticketList.addTicket("Terminal", "PG", 5, 19, "3D", "MoviePass", 44444);
     ticketList.addTicket("Terminal", "PG", 5, 21, "3D", "MoviePass", 44444);
      assertEquals(4, ticketList.numMoviesToday(44444, 5));
	}
}