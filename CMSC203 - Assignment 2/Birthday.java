import javax.swing.JOptionPane;
import java.text.DecimalFormat;
import java.lang.Math;
import java.util.Random;
import java.util.Scanner;

/**
 *  The Birthday driver class asks for the toy choice of the user, kid's name and age.
 *  Then it validates the input and prints into console the total for each gift
 *  and the total amount off the order, assigning to it a random five-digit number.
 * @author Andrei Popov
 */
public class Birthday 
{
	public static void main(String []args)
	{
		final String PROGRAMMER_NAME = "Andrei Popov", // Programmer's name
					 DATE = "6/19/2020"; // Due date
		final int ASSIGNMENT_NUMBER  = 2; // Assignment number
		
		String kidName, // The child's name
			   input,   // User input
			   toyChoice, // The toy that the user chooses
			   request, // To hold the value for another toy request if previous one was not age appropriate
			   card, // To hold the choice to add the card into gift or not
			   balloon, // To hold the choice to add the balloon with the gift or not
			   anotherToy; // To hold the user's input if it does want to add another toy into irder
		int kidAge,  // Child's age
			orderNum; // To hold the five-digit random number of the order
		
		double totalCost = 0; // Accumulator for the total cost of the order;
		
		// Create a toy object
		Toy toy = new Toy();
		DecimalFormat dollar = new DecimalFormat("#,##0.00");	//format cost
		
		// Title of the project displayed in console
		System.out.println("BIRTHDAY GIFTS\n");
		// Welcome message
		JOptionPane.showMessageDialog(null, "Welcome to the Toy Company \nto choose gifts for young children");
		
		// Loop for getting the user's input if there are multiple toys ordered
		do {
		// Get the child's name
		kidName = JOptionPane.showInputDialog("Enter the name of the child");
		// Get the child's age
		input = JOptionPane.showInputDialog("How old is the child?"); 
		kidAge = Integer.parseInt(input);
		toy.setAge(kidAge);
		
		// Get the toy choice
		toyChoice = JOptionPane.showInputDialog("Choose a toy: plushie, blocks or book");
		toy.setToy(toyChoice);
		toy.setCost(toyChoice);
		
		// If age is appropriate proceed to adding the card and/or balloon
		// if not, ask the user if it wants to cancel the request or continue
		if (toy.ageOK())
		{
			toy.getToy();
			toy.getCost();
		}
		else 
		{
			// Ask the user to cancel the request or continue with the order 
			// even if the toy is not age appropriate
			request = JOptionPane.showInputDialog("The toy that you choose is not age appropriate! "
					+ "\nDo you want to cancel the toy request? (Yes or No)");
			
			// If user's cancels, then inputs data from the very beginning starting with the child's name
			while(request.toLowerCase().equals("yes"))
			{
				// Get the child's name
				kidName = JOptionPane.showInputDialog("Enter the name of the child");
				// Get the child's age
				input = JOptionPane.showInputDialog("How old is the child?"); 
				kidAge = Integer.parseInt(input);
				toy.setAge(kidAge);
				
				// Get the toy choice
				toyChoice = JOptionPane.showInputDialog("Choose a toy: plushie, blocks or book");
				toy.setToy(toyChoice);
				toy.setCost(toyChoice);	
				
				// Check again if the user entered the appropriate age for the chosen toy
				if(toy.ageOK())
					break;
				else 
					// Ask the user to cancel the request or continue with the order 
					// even if the toy is not age appropriate
					request = JOptionPane.showInputDialog("The toy that you choose is not age appropriate! "
							+ "\nDo you want to cancel the toy request? (Yes or No)");		;
			}
			// If the user doesn't cancels the order, then set the kid's age and continue with the order procedure
			while(request.toLowerCase().equals("no"))
			{
				toy.setAge(kidAge);
				break;
			}
		}
		
		// Ask if the user wants to add a card into order
		// If yes, add the card, if no - skip (don't add the card)
		card = JOptionPane.showInputDialog("Do you want a card with the gift? (Yes or No)");
		toy.addCard(card);
		
		// Ask if the user wants to add a balloon into order
		// If yes, add the balloon, if no - skip (don't add the balloon)
		balloon = JOptionPane.showInputDialog("Do you want a balloon with the gift (Yes or No)");
		toy.addBalloon(balloon);
		
		// Display the child's name, child's age and the cost of the gift order into console
		// (including the cost of the card and/or balloon) 
		System.out.println("The gift for " + kidName + toy.toString());
		anotherToy = JOptionPane.showInputDialog("Do you want another toy? (Yes or No)");
		// Add the cost of the chil's gift into accumulator for the total cost of the order
		totalCost += toy.getCost();
		
		// If the user chooses to add another toy repeat the process from the very beginning 
		// by asking the child's name, age and toy choice
		// If not, display to the console the total cost of the order
		}while(anotherToy.toLowerCase().contentEquals("yes"));
		// Displays the total cost of the order
		System.out.println("\nThe total cost of your order is $" + dollar.format(totalCost));
		
		// Generating a random five-digit number of as the order number
		orderNum = (((int)(Math.random() * 100000) + (int)(Math.random() * 100000))/2) + 10000;
		// Displays the random five-digit order number
		System.out.println("Order number is " + orderNum + "\n");
		
		// Displays general information about programmer's name, assignment number and the due date
		System.out.println("Programmer: " + PROGRAMMER_NAME);
		System.out.println("CMSC 203 Assignment " + ASSIGNMENT_NUMBER);
		System.out.println("Due Date: " + DATE);
	}
}
