package Lab11;

import java.text.DecimalFormat;
public class Function1 extends Function
{
	DecimalFormat d = new DecimalFormat("#,##0.00");	//format dimension
	@Override
	public double fnValue(double x) 
	{
		return ((0.8 * Math.PI * Math.pow(x,2)) + (800/x));
	}
	
	public String toString() 
	{
		return "Minimize the cost of a can that will hold 2 liters of lliquid";
	}
	
	public String answerString(double optVal, double x, double y, double z)
	{
		return "Minimum cost is $" + d.format(optVal) + " with height = " + d.format(y) + "cm and radius = " + d.format(x) + "cm";
	}
	
	public double getXVal (double x)
	{
		return x;
	}
	
	public double getYVal (double x)
	{
		return (2000/(Math.PI * Math.pow(x, 2)));
	}
	
	public double getZVal (double x)
	{
		return (-1.0);
	}
	
}
