package Assignment_5;

/**
 * This utility works with 2 dimensional ragged arrays with a maximum of 10 rows and 10 columns.
 * This class also works with negative and positive numbers.
 * This is a utility class - there are no private data members.
 * This class calculates the holiday bonuses for each store of the district #5 
 * and the total holiday bonuses for all stores.
 * @author Andrei Popov
 */
public class HolidayBonus 
{
	/**
	 * Constructor of the utility class
	 */
	public HolidayBonus()
	{
		
	}
	
	/**
	 * Calculates the holiday bonus for each store
	 * @param data the two dimensional array of store sales
	 * @param high bonus for the highest store in a category
	 * @param low bonus for the lowest store in a category
	 * @param other bonus for all other stores in a category
	 * @return an array of the bonus for each store

	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other)
	{
		double[] holidayBonus = new double[data.length];
		for (int row = 0; row < data.length; row++)
		{
			for (int column = 0; column < data[row].length; column++)
			{
				if (data[row][column] == TwoDimRaggedArrayUtility.getLowestInColumn(data, column))
				{
					holidayBonus[row] += low;
				}else if (data[row][column] == TwoDimRaggedArrayUtility.getHighestInColumn(data, column))
				{
					holidayBonus[row] += high;
				}else 
				{
					holidayBonus[row] += other;
				}
			}
		}
		return holidayBonus;
	}
	
	/**
	 * Calculates the total holiday bonuses
	 * @param data the two dimensional array of store sales
	 * @param high bonus for the highest store in a category
	 * @param low bonus for the lowest store in a category
	 * @param other bonus for all other stores in a category
	 * @return the total of all holiday bonuses
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other)
	{
		double[] arrayTotal = calculateHolidayBonus(data, high, low, other);
		double total = 0;
		for (int row = 0; row < arrayTotal.length; row++)
		{
			total += arrayTotal[row];
		}
		return total;
	}
}
