package Lab11;

import java.text.DecimalFormat;

public class Function2 extends Function
{
	DecimalFormat d = new DecimalFormat("#,##0.00");	//format dimension
	@Override
	public double fnValue(double x) 
	{
		double y = Math.pow(x,2) - 8*x +25;
		return ((x/3.0)+(2*(Math.sqrt(y))));
	}
	
	public String toString() 
	{
		return "Minimize the distance a dog will run and swim to retrieve a ball in the ocean";
	}
	
	public String answerString(double optVal, double x, double y, double z)
	{
		return "The fastest time that the dog can reach the ball is " + d.format(optVal) 
				+ " seconds and it will occur at the distance of " + d.format(x) + " meters";
	}
	
	public double getXVal (double x)
	{
		return x; //The distance dog runs along the beach
	}
	
	public double getYVal (double x)
	{
		//Returns the distance dog swims to the ball
		return (Math.sqrt(Math.pow(3, 2) + Math.pow(4-x, 2))); 
	}
	
	public double getZVal (double x)
	{
		return (-1.0);
	}
}
