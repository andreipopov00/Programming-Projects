package Assignment_4;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestSTUDENT {
	
	ManagementCompany m;
	Property p1, p2, p3, p4, p5, p6;
	
	@Before
	public void setUp() throws Exception {
		//student create a management company
		m = new ManagementCompany("Golden", "00125",10);
		//student add three properties, with plots, to mgmt co
		p1 = new Property("Topaz House", "Bethesda", 2000.00, "Andrei Popov",0,0,6,6);
		p2 = new Property("Diamond Pearl", "Washington D.C.", 5750.00, "Oboroc Ion",0,6,10,4);
		p3 = new Property("Oasis", "Sunny Beach", 3900.00, "Elon Musk",6,0,4,3);
		m.addProperty(p1);
		m.addProperty(p2);
		m.addProperty(p3);
	}

	@After
	public void tearDown() throws Exception{
		//student set mgmt co to null  
		p1=p2=p3=null;
		m=null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		p4 = new Property("La Italia", "Valencia", 1600.00, "Sergio Mazzerati");
		//student should add property with 8 args
		p5 = new Property("Black&White", "Barcelona", 11000.00, "Irina Volkova",6,3,2,1);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		p6 = new Property("Green Hills", "Berlin", 1250.00, "Aston Martin",6,4,4,2);
	}
 
	@Test
	public void testMaxRentProp() {
		//student should test if maxRentProp contains the maximum rent of properties
		assertTrue(m.maxRentProp().contains("5750.0"));
	}

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		assertEquals(m.totalRent(),11650.0,0);
	}
}