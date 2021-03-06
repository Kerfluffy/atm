import java.util.Scanner;

public class ATM {
	BankAccount bankAccount;
	static User user;
	ATM(BankAccount bankAccount, User user) {
		this.bankAccount = bankAccount;
		this.user = user;
	}
	
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		ATM atm = new ATM(newAccount(), user); 
		atm.bankMenu();
	}
	
	public static BankAccount newAccount() {
		System.out.println("Enter your personal information below");
		System.out.print("Name: ");
			String name = in.nextLine(); 
		System.out.print("PIN: ");
			int pin = in.nextInt();
			in.nextLine();
		System.out.print("Date of Birth ");
			String dob = in.nextLine();
		System.out.print("Address: ");
			String address = in.nextLine();
		
		User user = new User(pin, name, dob, address); 
		
		double balance = 0;

		System.out.print("Account Number: ");
			int accountNumber = in.nextInt();
		in.nextLine();

		return new BankAccount(accountNumber, balance, user);
	}
	
	public void menu() {
		//switch to check if user wants to continue
		System.out.println("Want to do something else? Enter Y if you want to, enter anything else if else.");
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
				if (newPin != this.user.getPIN()) {
					System.out.println("Please try again.");
				}
				else {
					accountNum = false;
				}
			}
					
			//Prompt the user for what action to perform
			System.out.println("Enter 1 to withdraw, enter 2 to deposit, or enter 3 to check balance: ");
					
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