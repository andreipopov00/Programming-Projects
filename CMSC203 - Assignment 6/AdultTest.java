package Assignment_6;

/**
 * @author Andrei Popov
 */
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdultTest {
	Adult a1,a2,a3, a4, a5,a6;

	@Before
	public void setUp() throws Exception {
		//Evening movie (after 6 pm)
		a1 = new Adult("Revenge", "G", 5, 19,"NONE", 0);
		//Morning time (before 6 pm)
		a2 = new Adult("Revenge", "G", 2, 12,"NONE", 0);
		//Evening IMAX movie
		a3 = new Adult("Cars", "G", 3, 20,"IMAX", 0);
		//Morning IMAX
		a4 = new Adult("Cars", "G", 1, 13,"IMAX", 0);
		//Evening 3D
		a5 = new Adult("Ocean's 8", "PG", 3, 21,"3D", 0);
		//Morning 3D
		a6 = new Adult("Ocena's 8", "PG", 2, 14,"3D", 0);
	}

	@After
	public void tearDown() throws Exception {
		a1=a2=a3=a4=a5=a6=null;
	}

	@Test
	public void test() {
		assertEquals(14.79,a1.calculateTicketPrice(),.01);
		assertEquals(11.50,a2.calculateTicketPrice(),.01);
		assertEquals(18.08,a3.calculateTicketPrice(),.01);
		assertEquals(14.79,a4.calculateTicketPrice(),.01);
		assertEquals(17.53,a5.calculateTicketPrice(),.01);
		assertEquals(14.24,a6.calculateTicketPrice(),.01);
	}
}