package prod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import bus.Account;
import bus.CheckingAccount;
import bus.Customer;
import bus.Date;
import bus.Functions;
import bus.MissingFileException;
import bus.Transaction;
import data.FileHandler;

public class Test1 {
	public static void main(String[] args) throws IOException, ClassNotFoundException, MissingFileException {
		
	/*ArrayList<Transaction> transactionList =  new ArrayList<Transaction>();
	ArrayList<Account> accountList =  new ArrayList<Account>();
	ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	ArrayList<Transaction> transactionListFromFile =  new ArrayList<Transaction>();
	ArrayList<Account> accountListFromFile =  new ArrayList<Account>();
	ArrayList<Customer> customerListFromFile = new ArrayList<Customer>();
	
	
	Date openDate = new Date(1,1,2018);
	Date transDate = new Date(1,11,2019);
	Account checkAccount = new CheckingAccount(1,1234,openDate,8000,transactionList,true,4,1.5);	
	Customer testCustomer = new Customer(1,"John","Doe","jd@jd.com","555-555-555",checkAccount,accountList);
	customerList.add(testCustomer);
	testCustomer.openCheckingAccount(2, 2345, openDate, 0, transactionList, true, 4, 2);
	testCustomer.openSavingAccount(3, 3456, openDate, 5000, transactionList, true, 4, 5000, 150);
	
	//Testing customer created
	System.out.println("\n Testing Customer....\n");
	System.out.println(testCustomer);	
	
	//Transactions test	
	testCustomer.getCheckAccount().doTransaction(1, "Deposit to test check account", "Deposit", transDate, 500);
		
	System.out.println("\n Testing Transaction....\n");
	System.out.println(testCustomer);
	System.out.println(testCustomer.getCheckAccount().getBalance());
	System.out.println(testCustomer.getAccountList());
	
	//Closing account
	testCustomer.closeAccount(testCustomer.getAccountList().get(2));
	System.out.println("\n Testing Closing acc....\n");
	System.out.println(testCustomer.getAccountList().get(2));
	
	//Write to binary file
	
	FileHandler.writeFiles(customerList, accountList, transactionList);
	transactionListFromFile = FileHandler.readTransactions();
	accountListFromFile = FileHandler.readAccount();
	customerListFromFile = FileHandler.readCustomer();	
		

	System.out.println("\n Customers From FILE....\n");
	for(Customer aCustomer : customerListFromFile)	{
		System.out.println(aCustomer);
	}
	
	System.out.println("\n Accounts From FILE....\n");
	for(Account aAccount : accountListFromFile)	{
		System.out.println(aAccount);
	}
	
	System.out.println("\n Transactions From FILE....\n");
	for(Transaction aTransaction : transactionListFromFile)	{
		System.out.println(aTransaction);
	}
	*/
		
	//Program starts here!
	int selectedCustomer = 0;
	Customer currCustomer = new Customer();	
	Account currAccount = new Account();
	ArrayList<Customer> customerListFromFile;
	//If there is no file saved yet, creates a new customer's list
	if(FileHandler.readCustomer() == null)
	{
		customerListFromFile = new ArrayList<Customer>();	
		Customer testCustomer = new Customer(0,"John","Doe","jd@jd.com","555-555-555",new CheckingAccount(),new ArrayList<Account>());//Creates a test customer to avoid errors within the program
		customerListFromFile.add(testCustomer);
	}	
	else {
		customerListFromFile = FileHandler.readCustomer();	
	}
	int transactionNumber;	
		

	boolean exit = false;
	do {
	//First Menu
	System.out.println("\nHello, welcome to Fortis Bank!");
	System.out.println("\nPlease enter your selection below:");
	System.out.println("\n1-New Customer");
	System.out.println("\n2-Existing Customer");
	System.out.println("\n3-Exit");	
	
	Scanner  inputCustomer = new Scanner(System.in);
	int inputMenu1 = inputCustomer.nextInt();
	inputCustomer.nextLine();	
	switch (inputMenu1) {
		//Menu for creating new user..
		case 1:
			Functions.inputUser(customerListFromFile);
			break;
			
		//Operating with existing user...
		case 2:
			currCustomer = Functions.selectCustomer(customerListFromFile);
			if(currCustomer==null)
			{
				System.out.println("\nUnable to find Customer, please try again.");
				break;
			}			
			boolean back = false;
			do {
				
				System.out.println("\nWelcome back, "+ currCustomer.getFn()+ " !");
				System.out.println("\nPlease enter the type of operation to perform:");
				System.out.println("\n1 - Open Account");
				System.out.println("\n2 - Close Account");
				System.out.println("\n3 - Check Balance");
				System.out.println("\n4 - Deposit");
				System.out.println("\n5 - Withdraw");
				System.out.println("\n6 - Back");
				
				int inputMenu2 = inputCustomer.nextInt();				 
				switch(inputMenu2) {
					
					case 1://Menu Open Account
						System.out.println("\nPlease enter the type of account to open:");
						System.out.println("\n1 - Checking Account");
						System.out.println("\n2 - Savings Account");
						System.out.println("\n3 - Back");
						int inputMenu3 = inputCustomer.nextInt();
						
						switch(inputMenu3) {
							
							case 1: //Open Checking acc
								Functions.openChecking(currCustomer);
								break;
															
							case 2: //Open Savings Acc
								Functions.openSavings(currCustomer);
								break;		
							case 3://Back
								back = true;
								break;
							default:
								System.out.println("Invalid Option!");
								}				
						break;				
					case 2://Close Account
						Functions.closeAccounts(currCustomer);
						break;
					
					case 3: //Check Balance
						System.out.println("\nShowing balances:");
						for(Account aAccount : currCustomer.getAccountList())
						{
							System.out.println(( currCustomer.getAccountList().indexOf(aAccount)+ " " + aAccount.getClass().getName().substring(4)+ " $" + aAccount.getBalance()));
						}				
						break;
					case 4://Deposit
						Functions.makeADeposit(currCustomer);
						break;
					case 5://Withdraw
						Functions.makeAWithdraw(currCustomer);
						break;
					case 6://Back
						back = true;
						break;
					default:
						System.out.println("Invalid Option!");						
							}				
						//Update customer list with new info about current customer
						int indexOfcust = customerListFromFile.indexOf(currCustomer);
						customerListFromFile.set(indexOfcust, currCustomer);	
						FileHandler.writeFiles(customerListFromFile);	
						}while(!back);break;
		case 3:
				FileHandler.writeFiles(customerListFromFile);		
				exit = true;
				break;	
		default:
			System.out.println("Invalid Option!");
			}
		FileHandler.writeFiles(customerListFromFile);		
		}while(!exit);
	}
}
		
		
		
			
			
		
		
