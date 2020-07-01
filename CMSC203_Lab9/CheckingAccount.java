package Lab9;

public class CheckingAccount extends BankAccount
{
	private final static double FEE = 0.15;
	
	public CheckingAccount (String name, double amount)
	{
		super(name, amount);
		setAccountNumber(this.getAccountNumber() + "-10");
		
	}
	
	public boolean withdraw (double amount)
	{
		boolean completed = true;

		if (amount <= this.getBalance())
		{
			setBalance(this.getBalance() - amount - FEE);
		}
		else
		{
			completed = false;
		}
		return completed;
	}
}