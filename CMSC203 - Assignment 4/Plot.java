package Assignment_4;
/**
 * Represents a Plot object 
 * @author Andrei Popov
 * */
public class Plot 
{
	private int x, y, width, depth;
	
	/**
	 * No-arg Constructor, creates a Plot with x=0, y=0, width=1, depth=1 
	 */
	public Plot()
	{
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}
	
	/**
	 * Copy Constructor, creates a new Plot using the information of the Plot passed to it. 
	 * @param p - a Plot object
	 */
	public Plot(Plot p)
	{
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth = p.depth;
	}
	
	/**
	 * Parameterized constructor 
	 * @param x horizontal coordinate of upper left corner
	 * @param y vertical coordinate of upper left corner
	 * @param width horizontal size
	 * @param depth vertical size
	 */
	public Plot (int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/**
	 * Determines if this plot overlaps the parameter 
	 * @param p a Plot object
	 * @return Returns true if this plot overlaps the parameter, false otherwise
	 */
	public boolean overlaps(Plot p)
	{
		boolean xLeft = ((p.x < x) && ((p.x + p.width) > x));
		boolean xCenter = ((p.x > x) && ((p.x + p.width) < (x + width)));
		boolean xRight = ((p.x < (x + width)) && ((p.x + p.width) > (x + width)));
		boolean yTop = ((p.y < y) && ((p.y + p.depth) > y));
		boolean yCenter = ((p.y > y) && ((p.y + p.depth) < (y + depth)));
		boolean yBottom = ((p.y < (y + depth)) && ((p.y + p.depth) > (y + depth)));
		
		boolean leftTop = xLeft && yTop;
		boolean leftCenter = xLeft && yCenter;
		boolean leftBottom = xLeft && yBottom;
		boolean centerTop = xCenter && yTop;
		boolean centerCenter = xCenter && yCenter;
		boolean centerBottom = xCenter && yBottom;
		boolean rightTop = xRight && yTop;
		boolean rightCenter = xRight && yCenter;
		boolean rightBottom = xRight && yBottom;
		boolean right = xRight && (p.y <= y) && ((p.y + p.depth) >= (y + depth));
		boolean left = xLeft && (p.y <= y) && ((p.y + p.depth) >= (y + depth));
		boolean top = yTop && (p.x <= x) && ((p.x + p.width) >= (x + width));
		boolean bottom = yBottom && (p.x <= x) && ((p.x + p.width) >= (x + width));
		
		boolean plotInside = ((p.x >= x) && ((p.x + p.width) <= (x + width)) && (p.y >= y) && ((p.y + p.depth) <= (y + depth)));
		
		return leftTop || leftCenter || leftBottom || 
				centerTop || centerCenter || centerBottom || 
				rightTop || rightCenter || rightBottom || 
				plotInside || right || left || top || bottom;
	}
	
	/**
	 * Determines if this plot encompasses the parameter 
	 * @param p a Plot object
	 * @return Returns true if this plot encompasses the parameter, false otherwise
	 */
	public boolean encompasses(Plot p)
	{
		boolean xLimits = ((p.x >= x) && (p.x + p.width <= x + width));
		boolean yLimits = ((p.y >= y) && (p.y + p.depth <= y +depth));
		return xLimits && yLimits;
	}
	
	/**
	 * Return the x value
	 * @return the x value
	 */
	public int getX()
	{
		return x;
	}
	
	/**
	 * Set the x value 
	 * @param x the x value to set
	 */
	public void setX(int x)
	{
		this.x = x;
	}
	
	/**
	 * Return the y value 
	 * @return the y value
	 */
	public int getY()
	{
		return y;
	}
	
	/**
	 * Set the y value 
	 * @param y the y value to set
	 */
	public void setY(int y)
	{
		this.y = y;
	}
	
	/**
	 * Return the width value 
	 * @return the width value
	 */
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * Set the width value 
	 * @param width the width value to set
	 */
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	/**
	 * Return the depth value 
	 * @return the depth value
	 */
	public int getDepth()
	{
		return depth;
	}
	
	/**
	 * Set the depth value
	 * @param depth the depth value to set
	 */
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	
	
	@Override
	/**
	 * Prints out the name, city, owner and rent amount for a property 
	 * @return the string representation of a Plot object in the following format:
	 * 		  Upper left: (1,1); Width: 3 Depth: 3 
	 */
	public String toString()
	{
		return "Upper left: (" + x + "," + y + "); Width: " + width + " Depth: " + depth;
	}
}
