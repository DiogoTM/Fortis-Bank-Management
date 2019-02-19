package bus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import data.FileHandler;

public class Functions {

	public static void inputUser(ArrayList<Customer>customerList) throws IOException
	{
		Scanner inputCustomer = new Scanner(System.in);		
		System.out.println("\nPlease enter the following information");
		System.out.println("\nFirst Name");
		String fname = inputCustomer.nextLine();
		System.out.println("\nLast Name");
		String lname = inputCustomer.nextLine();
		System.out.println("\nEmail");
		String email = inputCustomer.nextLine();
		System.out.println("\nPhone Number");
		String pNumber = inputCustomer.nextLine();
		System.out.println("\nOpening date, day:");
		int date_day = inputCustomer.nextInt();
		System.out.println("\nOpening date, month:");
		int date_month = inputCustomer.nextInt();
		System.out.println("\nOpening date, year:");
		int date_year = inputCustomer.nextInt();
		System.out.println("\nPin for your Checkin account");
		int pin = inputCustomer.nextInt();
		Date newCustOpenDate = new Date(date_day,date_month,date_year);	
		ArrayList<Account> newCustomeraccountList =  new ArrayList<Account>();
		ArrayList<Transaction> newCustomerTrans =  new ArrayList<Transaction>();
		Account checkAccount = new CheckingAccount(1,pin,newCustOpenDate,0,newCustomerTrans,true,4,1.5);
		int custNumber = customerList.size()+1;
		Customer newCustomer = new Customer(custNumber,fname,lname,email,pNumber,checkAccount,newCustomeraccountList);
		customerList.add(newCustomer);
		System.out.println(newCustomer);
		FileHandler.writeFiles(customerList);
	}
	
	public static Customer selectCustomer (ArrayList<Customer>customerList)
	{
		boolean valid = false;
		Scanner inputCustomer = new Scanner(System.in);		
		while(!valid) {
		System.out.println("\nPlease select a customer from the list, or enter 'b' to return.");
			for(Customer aCustomer : customerList)	{
				System.out.println(aCustomer.getId()+" "+ aCustomer.getFn()+" "+ aCustomer.getLn());
			}
			
			String selectionInput = inputCustomer.nextLine();
			System.out.println(selectionInput.toUpperCase());
			if(selectionInput.toUpperCase()== "B")
			{
				System.out.println("noice");
				return null;
			}
			int selectedCustomer = Integer.parseInt(selectionInput);
			for(Customer aCustomer : customerList)	{
				if(aCustomer.getId() == selectedCustomer)
				{					
					valid=true;
					return aCustomer;
				}
			}
				if(selectedCustomer == 0)
				{
					System.out.println("\nPlease make a valid selection.");
					valid = false;
					return null;
				}	
			}
		return null;
	}
	
	public static void openChecking(Customer currCustomer)
	{
		Scanner inputCustomer = new Scanner(System.in);		
		System.out.println("\nPlease enter the following information:");
		System.out.println("\n1 - Pin Number");
		int pinNumber = inputCustomer.nextInt();
		System.out.println("\n2 - Balance");
		double balance = inputCustomer.nextDouble();
		ArrayList<Transaction> currTrans =  new ArrayList<Transaction>();
		Date openDate = new Date(11,12,2018);//Should be date of today
		currCustomer.openCheckingAccount(pinNumber, openDate, balance, currTrans, true, 4, 2);				
		System.out.println("\nAccount created succesfully!");
		System.out.println(currCustomer.getAccountList())	;
		
	}
	public static void openSavings(Customer currCustomer)
	{
		Scanner inputCustomer = new Scanner(System.in);		
		System.out.println("\nPlease enter the following information:");
		System.out.println("\n1 - Pin Number");
		int pinNumber = inputCustomer.nextInt();
		System.out.println("\n2 - Balance");
		double balance = inputCustomer.nextDouble();
		ArrayList<Transaction> currTrans =  new ArrayList<Transaction>();
		Date openDate = new Date(11,12,2018);//Should be date of today
		currCustomer.openSavingAccount(pinNumber, openDate, balance, currTrans, true, 2, 2000, 100);
		System.out.println("\nAccount created succesfully!");
		System.out.println(currCustomer.getAccountList());		
	}
	
	public static void closeAccounts(Customer currCustomer)
	{
		Scanner inputCustomer = new Scanner(System.in);	
		System.out.println("\nPlease select the account to close:");
		for(Account aAccount : currCustomer.getAccountList())	{
			System.out.println(( currCustomer.getAccountList().indexOf(aAccount)+ " " + aAccount.getClass().getName().substring(4)));
				}
		int selectedAcc = inputCustomer.nextInt();		
		currCustomer.closeAccount(currCustomer.getAccountList().get(selectedAcc));
	}
	public static void makeADeposit(Customer currCustomer)
	{		
		Scanner inputCustomer = new Scanner(System.in);	
		System.out.println("\nPlease select the account to deposit to:");
		for(Account aAccount : currCustomer.getAccountList())	{
		System.out.println(( currCustomer.getAccountList().indexOf(aAccount)+ " " + aAccount.getClass().getName().substring(4)));
		}
		
		int selectedAcc = inputCustomer.nextInt();		
		Account currAccount = currCustomer.getAccountList().get(selectedAcc);
		System.out.println("\nPlease enter the amount to deposit:");
		double inputAmount = inputCustomer.nextDouble();
		int transactionNumber = currAccount.getTransac_list().size()+1;
		String description = "Deposit to account";
		String type = "Deposit";
		Date transactionDate = new Date(1,1,2019);//Should be the date of the day..
		double amount = inputAmount;
		currAccount.doTransaction(transactionNumber, description, type, transactionDate, amount);
		
		
	}
	
	public static void makeAWithdraw(Customer currCustomer)
	{		
		Scanner inputCustomer = new Scanner(System.in);	
		System.out.println("\nPlease select the account to withdraw from:");
		for(Account aAccount : currCustomer.getAccountList())	{
		System.out.println(( currCustomer.getAccountList().indexOf(aAccount)+ " " + aAccount.getClass().getName().substring(4)));
		}
		
		int selectedAcc = inputCustomer.nextInt();		
		Account currAccount = currCustomer.getAccountList().get(selectedAcc);
		System.out.println("\nPlease enter the amount to withdraw:");
		double inputAmount = inputCustomer.nextDouble();
		int transactionNumber = currAccount.getTransac_list().size()+1;
		String description = "Withdraw from account";
		String type = "Withdraw";
		Date transactionDate = new Date(1,1,2019);//Should be the date of the day..
		double amount = inputAmount;
		currAccount.doTransaction(transactionNumber, description, type, transactionDate, amount);
		
	}
	
}
