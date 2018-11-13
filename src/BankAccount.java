public class BankAccount {
    private double balance = 0;
    private int accountNumber;
    private int pin;
    private AccountHolder accountHolder;
    BankAccount(AccountHolder accountHolder, int pin, int accountNumber) {
        this.accountHolder = accountHolder;
        this.pin = pin;
        this.accountNumber = accountNumber;
    }
    void deposit(double amount) {
        balance += amount;
    }
    void withdraw(double amount) {
    	if (balance >= amount) {
    		balance -= amount;
    	}
    	else {
    		System.out.println("Sorry, you do not have enough money in your account.");
    	}
    }
    /* set time */
    void setBalance(double balance) {
    	this.balance = balance;
    }
    void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    void setPin(int pin) {
    	this.pin = pin;
    }
    void setAccountHolder(AccountHolder accountHolder) {
    	this.accountHolder = accountHolder;
    }
    /* get time */
    double getBalance() {
        return balance;
    }
    int getAccountNumber() {
        return accountNumber;
    }
    int getPin() {
    	return pin;
    }
    AccountHolder getAccountHolder() {
        return accountHolder;
    }
}