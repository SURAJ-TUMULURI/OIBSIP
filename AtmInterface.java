import java.util.Scanner;

class BankAccounts{
	
	String name;
	String userName;
	String password;
	String accNo;
	float balance = 999999f;
	int transaction = 0;
	String transactionHist = "";
	
	/*BankAccount(String name, String userName, String password, String accountNo) {
	 this.name = name;
     this.userName = userName;
	 this.password = password;
	 this.accountNo = accountNo;
	  }*/
	
	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Your Name - ");
		this.name = sc.nextLine();
		System.out.print("\nEnter Your Username - ");
		this.userName = sc.nextLine();
		System.out.print("\nEnter Your Password - ");
		this.password = sc.nextLine();
		System.out.print("\nEnter Your Account Number - ");
		this.accNo = sc.nextLine();
		System.out.println("\nRegistration completed..kindly login");
	}
	
	public boolean login() {
		boolean login = false;
		Scanner sc = new Scanner(System.in);
		while ( !login ) {
			System.out.print("\nEnter Your Username - ");
			String Username = sc.nextLine();
			if ( Username.equals(userName) ) {
				while ( !login ) {
					System.out.print("\nEnter Your Password - ");
					String Password = sc.nextLine();
					if ( Password.equals(password) ) {
						System.out.print("\nLogin successful!!");
						login = true;
					}
					else {
						System.out.println("\nIncorrect Password");
					}
				}
			}
			else {
				System.out.println("\nUsername not found");
			}
		}
		return login;
	}
	
	public void withdraw() {
		
		System.out.print("\nEnter amount to withdraw - ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try {
			
			if ( balance >= amount ) {
				transaction++;
				balance -= amount;
				System.out.println("\nWithdraw Successfully");
				String str = amount + " Rs Withdrawed\n";
				transactionHist = transactionHist.concat(str);
				
			}
			else {
				System.out.println("\nInsufficient Balance");
			}
			
		}
		catch ( Exception e) {
		}
	}
	
	public void deposit() {
		
		System.out.print("\nEnter amount to deposit - ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		
		try {
			if ( amount <= 100000f ) {
				transaction++;
				balance += amount;
				System.out.println("\nSuccessfully Deposited");
				String str = amount + " Rs deposited\n";
				transactionHist = transactionHist.concat(str);
			}
			else {
				System.out.println("\nSorry...Limit is 100000.00");
			}
			
		}
		catch ( Exception e) {
		}
	}
	
	public void transfer() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Receipent's Name - ");
		String receipent = sc.nextLine();
		System.out.print("\nEnter amount to transfer - ");
		float money = sc.nextFloat();
		
		try {
			if ( balance >= money) {
				if ( money <= 50000f ) {
					transaction++;
					balance -= money;
					System.out.println("\nSuccessfully Transfered to " + receipent);
					String str = money + " Rs transfered to " + receipent + "\n";
					transactionHist = transactionHist.concat(str);
				}
				else {
					System.out.println("\nSorry...Limit is 50000.00");
				}
			}
			else {
				System.out.println("\nInsufficient Balance");
			}
		}
		catch ( Exception e) {
		}
	}
	
	public void checkBalance() {
		System.out.println("\n" + balance + " Rs");
	}
	
	public void transHistory() {
		if ( transaction == 0 ) {
			System.out.println("\nEmpty");
		}
		else {
			System.out.println("\n" + transactionHist);
		}
	}
}


class AtmInterface {
	
	
	public static int takeIntegerInput(int limit) {
		int n = 0;
		boolean flags = false;
		
		while ( !flags ) {
			try {
				Scanner sc = new Scanner(System.in);
				n = sc.nextInt();
				flags = true;
				
				if ( flags && n > limit || n < 1 ) {
					System.out.println("Choose the number between 1 to " + limit);
					flags = false;
				}
			}
			catch ( Exception e ) {
				System.out.println("Enter only integer value");
				flags = false;
			}
		};
		return n;
	}
	
	
	public static void main(String[] args) {
		
		System.out.println("\n*********WELCOME TO UNION BANK  ATM SYSTEM*********\n");
		System.out.println("1.Register \n2.Exit");
		System.out.print("Enter Your Choice - ");
		int select = takeIntegerInput(2);
		
		if ( select == 1 ) {
			BankAccounts b = new BankAccounts();
			b.register();
			while(true) {
				System.out.println("\n1.Login \n2.Exit");
				System.out.print("Enter Your Choice - ");
				int ch = takeIntegerInput(2);
				if ( ch == 1 ) {
					if (b.login()) {
						System.out.println("\n\n**********WELCOME BACK " + b.name + " **********\n");
						boolean isCompleted = false;
						while (!isCompleted) {
							System.out.println("\n1.Withdraw \n2.Deposit \n3.Transfer \n4.Check Balance \n5.Transaction History \n6.Exit");
							System.out.print("\nEnter Your Choice - ");
							int c = takeIntegerInput(6);
							switch(c) {
								case 1:
								b.withdraw();
								break;
								case 2:
								b.deposit();
								break;
								case 3:
								b.transfer();
								break;
								case 4:
								b.checkBalance();
								break;
								case 5:
								b.transHistory();
								break;
								case 6:
								isCompleted= true;
								break;
							}
						}
					}
				}
				else {
					System.exit(0);
				}
			}
		}
		else {
			System.exit(0);
		}
		
		
		
	}
}