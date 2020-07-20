package Assignment_5;

import java.io.*;
import java.util.Scanner;
/**
 * This utility works with 2 dimensional ragged arrays with a maximum of 10 rows and 10 columns.
 * This class also works with negative and positive numbers.
 * This is a utility class - there are no private data members.
 * @author Andrei Popov
 */
public class TwoDimRaggedArrayUtility 
{
	/**
	 * Constructor of the utility
	 */
	public TwoDimRaggedArrayUtility()
	{
		
	}
	
	/**
	 * Reads from a file and returns a ragged array of doubles
	 * @param file the file to read from 
	 * @return a two dimensional ragged (depending on data) array of doubles if the file is not empty, 
	 * returns a null if file is empty 
	 * @throws FileNotFoundException
	 */
	public static double[][] readFile(File file) throws FileNotFoundException
	{
		// Creating a temporary array of Strings that are initialized to null 
		String[][] array = new String[10][10];
		// Open the file.
		Scanner inputFile = new Scanner(file);
		// Initializing the loop controller variables to zero which represent the rows and columns of 2D array
		int row = 0,
			column = 0;
		
		while (inputFile.hasNextLine())
		{
			String[] currentRow = inputFile.nextLine().split(" ");
			for (column = 0; column < currentRow.length; column++)
			{
				array[row][column] = currentRow[column];
			}
			row++;
		}
		
		inputFile.close();
		
		double[][] finalArray = new double[row][];
		for (row = 0; row < finalArray.length; row++)
		{
			for (column = 0; array[row][column] != null; column++)
			{
				
			}
			finalArray[row] = new double[column];
			for(column = 0; column < finalArray[row].length; column++)
			{
				finalArray[row][column] = Double.parseDouble(array[row][column]);
			}
		}
		
		return finalArray;
	}
	
	/**
	 * Writes the ragged array of doubles into the file. 
	 * Each row is on a separate line within the file and each double is separated by a space. 
	 * @param data two dimensional ragged array of doubles
	 * @param outputFile the file to write to 
	 * @throws FileNotFoundException if outputFile is not valid
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException
	{
		// Open the file
		PrintWriter output = new PrintWriter(outputFile);
		
		// Get data and write it to the file.
		// Passing through each row of the two dimensional array
		for (int row = 0; row < data.length; row++)
		{
			// Passing through each column in the current row
			for (int column = 0; column < data[row].length; column++)
			{
				if (column != 0)
				{
					output.print(" " + data[row][column]);
				}else {
					output.print(data[row][column]);
				}
			}
			output.println();
		}
		// Close the file
		output.close();
	}
	
	/**
	 * Returns the total of all the elements of the two dimensional array 
	 * @param data the two dimensional array getting total of 
	 * @return the sum of all the elements in the two dimensional array
	 */
	public static double getTotal(double[][] data)
	{
		// Declare and initialize accumulator to zero
		double total = 0;
		// Pass though each element of 2D array and add up the elements
		for (int row = 0; row < data.length; row++)
		{
			for (int column = 0; column < data[row].length; column++)
			{
				total += data[row][column];
			}
		}
		return total;
	}
	
	/**
	 * Returns the average of the elements in the two dimensional array 
	 * @param data the two dimensional array getting the average of 
	 * @return the average of the elements in the 2D array
	 */
	public static double getAverage(double[][] data)
	{
		// Accumulators for number of elements in the array
		int elements = 0;  
		
		for (int row = 0; row < data.length; row++)
		{
			for (int column = 0; column < data[row].length; column++)
			{
				elements++;
			}
		}
		return getTotal(data)/elements;
	}
	
	/**
	 * Returns the total of the selected row in the 2D array
	 * @param data the two dimensional array
	 * @param row the row index to take the total of (0 refers to the first row)
	 * @return the total of the row
	 */
	public static double getRowTotal(double[][] data, int row)
	{
		// Accumulator for holding the total of all the elements in the selected row
		double rowTotal = 0;
		for (int column = 0; column < data[row].length; column++)
		{
			rowTotal += data[row][column];
		}
		return rowTotal;
	}
	
	/**
	 * Returns the total of the selected column in 2D array 
	 * @param data the two dimensional array
	 * @param col the column index to take the total of (0 refers to the first column)
	 * @return the total of the column
	 */
	public static double getColumnTotal(double[][] data, int col)
	{
		// Accumulator for holding the total of all elements in the selected column
		double columnTotal = 0;
		for (int row = 0; row < data.length; row++)
		{
			if (col < data[row].length)
			{
				columnTotal += data[row][col];
			}
		}
		return columnTotal;
	}
	
	/**
	 * Returns the largest element of the selected row in 2D array
	 * @param data the two dimensional array
	 * @param row the row index to find the largest element of (0 refers to the first row)
	 * @return the largest element of the row
	 */
	public static double getHighestInRow(double[][] data, int row)
	{
		// Initialize the highest row element to be the first element in the passed array
		double highRow = data[0][0];
		
		// Passing through every column of the array on the specified row
		for (int column = 0; column < data[row].length; column++)
		{
			if (highRow < data[row][column])
			{
				highRow = data[row][column];
			}
		}
		return highRow;
	}
	
	/**
	 * Returns the index of the largest element of the selected row in 2D array
	 * @param data the two dimensional array
	 * @param row the row index to find the largest element of (0 refers to the first row)
	 * @return the index of largest element of the row
	 */
	public static double getHighestInRowIndex(double[][] data, int row)
	{
		// Index of the highest element in the specified row
		int index = 0;
		// Initialize the highest row element to be the first element in the passed array
		double highRow = data[0][0];
		
		// Passing through every column of the array on the specified row
		for (int column = 0; column < data[row].length; column++)
		{
			if (column < data[row].length)
			{
				if (highRow < data[row][column])
				{
					highRow = data[row][column];
					index = column;
				}
			}
		}
		return index;
	}
	
	/**
	 * Returns the smallest element of the selected row in 2D array
	 * @param data the two dimensional array
	 * @param row the row index to find the smallest element of (0 refers to the first row)
	 * @return the smallest element of the row
	 */
	public static double getLowestInRow(double[][] data, int row)
	{
		// Initialize the lowest row element to be the first element in the passed array
		double lowRow = data[0][0];
		
		// Passing through every column of the array on the specified row
		for (int column = 0; column < data[row].length; column++)
		{
			if (lowRow > data[row][column])
			{
				lowRow = data[row][column];
			}
		}
		return lowRow;
	}
	
	/**
	 * Returns the index of the smallest element of the selected row in 2D array
	 * @param data the two dimensional array
	 * @param row the row index to find the smallest element of (0 refers to the first row)
	 * @return the index of smallest element of the row
	 */
	public static double getLowestInRowIndex(double[][] data, int row)
	{
		// Index of the lowest element in the specified row
		int index = 0;
		// Initialize the lowest row element to be the first element in the passed array
		double lowRow = data[0][0];
		
		// Passing through every column of the array on the specified row
		for (int column = 0; column < data[row].length; column++)
		{
			if (column < data[row].length)
			{
				if (lowRow > data[row][column])
				{
					lowRow = data[row][column];
					index = column;
				}
			}
		}
		return index;
	}
	
	/**
	 * Returns the largest element of the selected column in 2D array
	 * @param data the two dimensional array
	 * @param col the column index to find the largest element of (0 refers to the first column)
	 * @return the largest element of the column
	 */
	public static double getHighestInColumn(double[][] data, int col)
	{
		// Flag for checking column length
		int scanRow = 0;
		// Initialize the highest column element to be the first element in the passed array
		double highColumn = data[0][0];
		
		// Finding the highest value of the column even it does have gaps in it
		while (scanRow < data.length)
		{
			if (col < data[scanRow].length)
			{
				highColumn = data[scanRow][col];
				break;
			} else
			{
				scanRow++;
			}
		}
		
		// Passing through every row of the array on the specified column
		for (int row = 0; row < data.length; row++)
		{
			if (col < data[row].length)
			{
				if (highColumn < data[row][col])
				{
					highColumn = data[row][col];
				}
			}
		}
		return highColumn;
	}
	
	/**
	 * Returns the index of largest element of the selected column in 2D array
	 * @param data the two dimensional array
	 * @param col the column index to find the largest element of (0 refers to the first column)
	 * @return the index of largest element of the column
	 */
	public static double getHighestInColumnIndex(double[][] data, int col)
	{
		// Flag for checking column length
		int scanRow = 0;
		// Index of the highest element in the specified column
		int index = 0;
		// Initialize the highest column element to be the first element in the passed array
		double highColumn = data[0][0];
		
		// Finding the highest value of the column even it does have gaps in it
		while (scanRow < data.length)
		{
			if (col < data[scanRow].length)
			{
				highColumn = data[scanRow][col];
				break;
			} else
			{
				scanRow++;
			}
		}

		// Passing through every row of the array on the specified column
		for (int row = 0; row < data.length; row++)
		{
			if (col < data[row][col])
			{
				if (highColumn < data[row][col])
				{
					highColumn = data[row][col];
					index = row;
				}
			}
		}
		return index;
	}
	
	/**
	 * Returns the smallest element of the selected column in 2D array
	 * @param data the two dimensional array
	 * @param col the column index to find the smallest element of (0 refers to the first column)
	 * @return the smallest element of the column
	 */
	public static double getLowestInColumn(double[][] data, int col)
	{
		// Flag for checking column length
		int scanRow = 0;
		// Initialize the lowest column element to be the first element in the passed array
		double lowColumn = data[0][0];
		
		// Finding the lowest value of the column even it does have gaps in it
		while (scanRow < data.length)
		{
			if (col < data[scanRow].length)
			{
				lowColumn = data[scanRow][col];
				break;
			} else
			{
				scanRow++;
			}
		}
		
		// Passing through every row of the array on the specified column
		for (int row = 0; row < data.length; row++)
		{
			if (col < data[row].length)
			{
				if (lowColumn > data[row][col])
				{
					lowColumn = data[row][col];
				}
			}
		}
		return lowColumn;
	}
	
	/**
	 * Returns the index of smallest element of the selected column in 2D array
	 * @param data the two dimensional array
	 * @param col the column index to find the smallest element of (0 refers to the first column)
	 * @return the index of smallest element of the column
	 */
	public static double getLowestInColumnIndex(double[][] data, int col)
	{
		// Flag for checking column length
		int scanRow = 0;
		// Index of the lowest element in the specified column
		int index = 0;
		// Initialize the lowest column element to be the first element in the passed array
		double lowColumn = data[0][0];
		
		// Finding the lowest value of the column even it does have gaps in it
		while (scanRow < data.length)
		{
			if (col < data[scanRow].length)
			{
				lowColumn = data[scanRow][col];
				break;
			} else
			{
				scanRow++;
			}
		}
		
		// Passing through every row of the array on the specified column
		for (int row = 0; row < data.length; row++)
		{
			if (col < data[row].length)
			{
				if (lowColumn > data[row][col])
				{
					lowColumn = data[row][col];
					index = row;
				}
			}
		}
		return index;
	}
	
	/**
	 * Returns the largest element in 2D array
	 * @param data the two dimensional array
	 * @return the largest element in the two dimensional array
	 */
	public static double getHighestInArray(double[][] data)
	{
		// Initialize the highest element of the array to be the first element in the passed array
		double high = data[0][0];
		// Passing through every element in 2D array
		for (int row = 0; row < data.length; row++)
		{
			for (int column = 0; column < data[row].length; column++)
			{
				if (high < data[row][column])
				{
					high = data[row][column];
				}
			}
		}
		return high;
	}
	
	/**
	 * Returns the smallest element in 2D array
	 * @param data the two dimensional array
	 * @return the smallest element in the two dimensional array
	 */
	public static double getLowestInArray(double[][] data)
	{
		// Initialize the lowest element of the array to be the first element in the passed array
		double low = data[0][0];
		// Passing through every element in 2D array
		for (int row = 0; row < data.length; row++)
		{
			for (int column = 0; column < data[row].length; column++)
			{
				if (low > data[row][column])
				{
					low = data[row][column];
				}
			}
		}
		return low;
	}
}
