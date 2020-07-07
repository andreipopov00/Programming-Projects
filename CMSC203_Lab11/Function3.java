package Lab11;

import java.text.DecimalFormat;

public class Function3 extends Function
{
	DecimalFormat d = new DecimalFormat("#,##0.00");	//format dimension
	@Override
	public double fnValue(double x) 
	{
		double inner = Math.pow(x,4) - Math.pow(x,2) + 1; 
		return Math.sqrt(inner);
	}
	
	public String toString() 
	{
		return "Find the minimum distance between the fucntion f(x) = x^2 and the point (0,1)"
				+ "\nThis distance is described by the fucntion d(x) = sqrt(x^4 - x^2 +1)";
	}
	
	public String answerString(double optVal, double x, double y, double z)
	{
		return "The smallest distance between point (0,1) and the function f(x) = x^2 is " + d.format(optVal)
				+ " and it occurs at the points (" + d.format(this.getXVal(x)) + "," + d.format(this.getYVal(x)) + ")"
				+ " and (-"+ d.format(this.getXVal(x)) + "," + d.format(this.getYVal(x)) + ")";
	}
	
	public double getXVal (double x)
	{
		return Math.sqrt(2)/2.0;
	}
	
	public double getYVal (double x)
	{
		return Math.pow(this.getXVal(x),2);
	}
	
	public double getZVal (double x)
	{
		return (-1.0);
	}
}
