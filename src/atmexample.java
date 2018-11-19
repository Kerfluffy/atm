import java.util.Scanner;

public class ATM {
	BankAccount bankAccount;
	ATM(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		ATM atm = new ATM(newAccount()); 
		atm.bankMenu();
	}
	
	public static BankAccount newAccount() {
		System.out.println("Enter your personal information below");
		System.out.print("Name: ");
		String name = in.nextLine(); 
		System.out.print("SSN: ");
		int ssn = in.nextInt();
		in.nextLine();
		System.out.print("Phone: ");
		String phone = in.nextLine();
		System.out.print("Address: ");
		String Address = in.nextLine();
		
		AccountHolder user = new AccountHolder(ssn, name, phone, Address); 
		
		double balance = 0;
		System.out.print("PIN: ");
		int pin = in.nextInt();
		in.nextLine();
		System.out.print("Account Number: ");
		int accountNumber = in.nextInt();
		in.nextLine();

		return new BankAccount(balance, accountNumber, pin, user);
	}
	
	public void menu() {
		//switch to check if user wants to continue
		System.out.println("Would you like to do something else (Y for \"Yes\", any key for \"No\"): ");
		char choice = in.next().charAt(0); 
		switch (choice) {
		case 'Y':
			bankMenu();
		case 'y':
			bankMenu();
		default:
			System.exit(0);
		}
	}
	
	public void bankMenu() {
		//implement system to check entered number to previous number
		boolean menuSet = true;
		boolean accountNum = true;
		int check = 0;
		while (menuSet) {
			while (accountNum) {
				while (check == 0) {
					System.out.print("Enter your account number: ");
					int newNum = in.nextInt();
					if (newNum != this.bankAccount.accountNumber) {
						System.out.println("Please try again.");
					}
					else {
						check++;
					}
				}
				System.out.print("Enter your PIN: ");
				int newPin = in.nextInt();
				if (newPin != this.bankAccount.pin) {
					System.out.println("Please try again.");
				}
				else {
					accountNum = false;
				}
			}
					
			//options menu with choices
			System.out.println("What would you like to do?");
			System.out.println("1. Withdraw\n2. Deposit\n3. Check Balance");
					
			//loop to check if choice is valid
			int menuLoop = 0;
			while (menuLoop == 0) {
				int menuChoice = in.nextInt(); 
				switch (menuChoice) {
					case 1:
						System.out.print("Enter withdrawl amount: ");
						double withAmount = in.nextInt();
						if (bankAccount.getBalance() == 0) {
							System.out.println("Insufficient funds. Please try again later");
						}
						else {
							this.bankAccount.setBalance(bankAccount.getBalance() - withAmount);
						}
							
						menu();
					case 2:
						System.out.print("Enter deposited amount: ");
						double desAmount = in.nextInt();
						this.bankAccount.setBalance(bankAccount.getBalance() + desAmount);
						
							
						menu();
					case 3:
						System.out.println("Current Balance: $" + bankAccount.getBalance());
						menu();
					default: 
						System.out.print("That is not a choice. Please try again: ");
				}
			}
		}
	}
}