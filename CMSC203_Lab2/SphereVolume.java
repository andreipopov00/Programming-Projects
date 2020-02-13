import java.util.Scanner;

public class SphereVolume 
{ 
	public static void main(String[] args) 
	{ 
		double diam,
			   radius,
			   volume;
		Scanner input = new Scanner(System.in);
		// Print the purpose of the program 
		System.out.println("Sphere Volume Calculator");
		// Print a prompt asking for the diameter of a sphere 
		System.out.print("Please enter the diameter of the sphere: ");
		// Read the diameter 
		diam = input.nextDouble();
		// Calculate the radius as diameter divided by 2 
		radius = diam/2.0;
		// Calculate volume of the sphere using the formula (see Task #3b) 
		volume = (4.0/3.0)*Math.PI*Math.pow(radius, 3);
		// Print the volume 
		System.out.println("The volume of the sphere with the diamter of " + diam + " is " + volume);
		
	} 
} 