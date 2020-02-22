import java.util.Scanner;
public class MovieDriver 
{

	public static void main(String[] args)
	{
		String setTitle, getRating, again;
		char tryAgain;
		int getSoldTickets;
		
		Scanner input = new Scanner(System.in);
		Movie movie = new Movie();
		System.out.println("Enter the name of the movie: ");
		movie.setTitle(input.nextLine());
		
		System.out.println("Enter the rating of the movie: ");
		movie.setRating(input.next());
		
		System.out.println("Enter the number of tickets sold for this movie: ");
		movie.setSoldTickets(input.nextInt());
		
		System.out.println(movie.toString());
		
		System.out.println("Do you want to enter another movie? (y or n)");
		again = input.next();
		tryAgain = again.charAt(0);
		
		if (tryAgain == 'y' || tryAgain == 'Y')
		{
			do {
			System.out.println("Enter the name of the movie: ");
			movie.setTitle(input.next());
			
			System.out.println("Enter the rating of the movie: ");
			movie.setRating(input.next());
			
			System.out.println("Enter the number of tickets sold for this movie: ");
			movie.setSoldTickets(input.nextInt());
			
			System.out.println(movie.toString());		
			System.out.println("Do you want to enter another movie? (y or n)");
			again = input.next();
			tryAgain = again.charAt(0);
			}while (tryAgain == 'y' || tryAgain == 'Y');
		}
		System.out.println("Goodbye!");
	}
}