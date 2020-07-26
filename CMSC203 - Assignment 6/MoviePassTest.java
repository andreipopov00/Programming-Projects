package Assignment_6;

/**
 * @author Andrei Popov
 */
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MoviePassTest {
	MoviePass m1, m2, m3, m4, m5, m6;

	@Before
	public void setUp() throws Exception {
		//Evening movie (after 6 pm)
		m1 = new MoviePass("Revenge", "G", 5, 19,"NONE", 11111);
		//Morning time (before 6 pm)
		m2 = new MoviePass("Revenge", "G", 2, 12,"NONE", 22222);
		//Evening IMAX movie
		m3 = new MoviePass("Cars", "G", 3, 20,"IMAX", 33333);
		//Morning IMAX
		m4 = new MoviePass("Cars", "G", 1, 13,"IMAX", 44444);
		//Evening 3D
		m5 = new MoviePass("Ocean's 8", "PG", 3, 21,"3D", 55555);
		//Morning 3D
		m6 = new MoviePass("Ocena's 8", "PG", 2, 14,"3D", 55555);
	}

	@After
	public void tearDown() throws Exception {
		m1=m2=m3=m4=m5=m6=null;
	}

	@Test
	public void test() {
		assertEquals(14.79,m1.calculateTicketPrice(),.01);
		assertEquals(11.50,m2.calculateTicketPrice(),.01);
		assertEquals(18.08,m3.calculateTicketPrice(),.01);
		assertEquals(14.79,m4.calculateTicketPrice(),.01);
		assertEquals(17.53,m5.calculateTicketPrice(),.01);
		assertEquals(14.24,m6.calculateTicketPrice(),.01);
	}
}
