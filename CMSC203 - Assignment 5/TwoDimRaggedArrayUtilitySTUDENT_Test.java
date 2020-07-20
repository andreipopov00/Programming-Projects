package Assignment_5;

import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * Testing 
 * @author Andrei Popov
 */
public class TwoDimRaggedArrayUtilitySTUDENT_Test {
	//STUDENT fill in dataSetSTUDENT with values, it must be a ragged array
	private double[][] dataSetSTUDENT = {{100.5, 50.5, 340.0, 500.0, 120.0, 30.0},
										 {4.2, 5.8, 90.3, 54.7, 2847.4, 754.6}, 
										 {5, 7, 8, 3, 1, 43}, 
										 {0.4, 0.1, 48, 98, 503}, 
										 {76, 29, 98, 6543, 754},
										 {65.5, 58.5, 893.5}};
	
	private File inputFile,outputFile;

	@Before
	public void setUp() throws Exception {
		outputFile = new File("TestOut.txt");
	}

	@After
	public void tearDown() throws Exception {
		dataSetSTUDENT = null;
		inputFile = outputFile = null;
	}

	/**
	 * Student Test getTotal method
	 * Return the total of all the elements in the two dimensional array
	 */
	@Test
	public void testGetTotal() 
	{
		assertEquals(14132.0 ,TwoDimRaggedArrayUtility.getTotal(dataSetSTUDENT),.001);
	}

	/**
	 * Student Test getAverage method
	 * Return the average of all the elements in the two dimensional array
	 */
	@Test
	public void testGetAverage()
	{
		assertEquals(455.871,TwoDimRaggedArrayUtility.getAverage(dataSetSTUDENT),.001);
	}

	/**
	 * Student Test getRowTotal method
	 * Return the total of all the elements of the row.
	 * Row 0 refers to the first row in the two dimensional array
	 */
	@Test
	public void testGetRowTotal() 
	{
		assertEquals(1141.0,TwoDimRaggedArrayUtility.getRowTotal(dataSetSTUDENT, 0),.001);
	}


	/**
	 * Student Test getColumnTotal method
	 * Return the total of all the elements in the column. If a row in the two dimensional array
	 * doesn't have this column index, it is not an error, it doesn't participate in this method.
	 * Column 0 refers to the first column in the two dimensional array
	 */
	@Test
	public void testGetColumnTotal() 
	{
		assertEquals(150.9,TwoDimRaggedArrayUtility.getColumnTotal(dataSetSTUDENT, 1),.001);
	}


	/**
	 * Student Test getHighestInArray method
	 * Return the largest of all the elements in the two dimensional array.
	 */
	@Test
	public void testGetHighestInArray() 
	{
		assertEquals(6543,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT),.001);
	}
	
	@Test
	public void testGetHighestInRow()
	{
		assertEquals(2847.4,TwoDimRaggedArrayUtility.getHighestInRow(dataSetSTUDENT, 1),.001);
	}
	
	@Test
	public void testGetHighestInColumn()
	{
		assertEquals(893.5,TwoDimRaggedArrayUtility.getHighestInColumn(dataSetSTUDENT, 2),.001);
	}
	

	/**
	 * Test the writeToFile method
	 * write the array to the outputFile File
	 * then read it back to make sure formatted correctly to read
	 * 
	 */
	@Test
	public void testWriteToFile() 
	{
		double[][] array = null;
		assertEquals(6543,TwoDimRaggedArrayUtility.getHighestInArray(dataSetSTUDENT),.001);
		
	}
}