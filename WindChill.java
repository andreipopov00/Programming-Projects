import java.util.Scanner;

/**
 * This program reads two double numeric amounts
 * that represent Fahrenheit temperature and wind speed
 * and use those variables in a formula to calculate the
 * wind chill temperature.
 */
public class WindChill 
{
	public static void main(String[] args)
	{
		double temperature,  
			   windSpeed,
			   windChillTemp;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Wind Chill Calculator\n");
		System.out.print("Please enter the temperature in Fahrenheit (must be >= -45 and <= 40): ");
		temperature = input.nextDouble();
		
		System.out.print("Please enter the wind speed (must be >= 5 and <= 60): ");
		windSpeed = input.nextDouble();
		
		windChillTemp = 35.74 + 0.6215*temperature - 35.75*(Math.pow(windSpeed, 0.16)) + 0.4275*temperature*(Math.pow(windSpeed, 0.16));
		
		System.out.println("Wind chill temperature: " + windChillTemp + " degrees Fahrenheit\n\n");
		System.out.println("Programmer:     Andrei Popov");
		System.out.println("Project's Name: Wind Chill Temperature Index");
		System.out.println("Due date:       2/12/2020");
		
		
	}
}
