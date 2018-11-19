public class BankAccount {
	
	private static long generatedAccountNumber = 100000001L;
	
	long accountNumber;
	private double balance;
	private User user;
	
	public BankAccount(long accountNumber, double balance, User user) {
		this.accountNumber = BankAccount.generatedAccountNumber++;
		this.balance = balance;
		this.user = user;
	}
	/* get section */
	public long getAccountNumber() {
		return accountNumber;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public User getUser() {
		return user;
	}
	/* set section */
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
		
	public int deposit(double amount) {
		if (amount <= 0) {
			return 0;
		} else {
			balance = balance + amount;
			
			return 1;
		}
	}
	
	public int withdraw(double amount) {
		if (amount > balance) {
			return 0;
		} else if (amount <= 0) {
			return 1;
		} else {
			balance = balance - amount;
			
			return 2;
		}
	}
}