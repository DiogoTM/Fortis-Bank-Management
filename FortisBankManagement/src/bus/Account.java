package bus;

import java.io.Serializable;
import java.util.ArrayList;

public class Account implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer acc_number,pin;
	Date open_date;
	double balance;
	ArrayList<Transaction> transac_list;
	boolean status;
	
	public Account(Integer acc_number, Integer pin, Date open_date, double balance,
			ArrayList<Transaction> transac_list, boolean status) {
		super();
		this.acc_number = acc_number;
		this.pin = pin;		
		this.open_date = open_date;
		this.balance = balance;
		this.transac_list = transac_list;
		this.status = status;
	}
	
	public Account() {
		super();
		this.acc_number = 0;
		this.pin = 0;	
		this.open_date = new Date(01,01,1999);
		this.balance = 0;
		this.transac_list = new ArrayList<Transaction>();
		this.status = true;
	}
	public Integer getAcc_number() {
		return acc_number;
	}
	public void setAcc_number(Integer acc_number) {
		this.acc_number = acc_number;
	}
	public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		this.pin = pin;
	}
		
	public Date getOpen_date() {
		return open_date;
	}
	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public ArrayList<Transaction> getTransac_list() {
		return transac_list;
	}
	public void setTransac_list(ArrayList<Transaction> transac_list) {
		this.transac_list = transac_list;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
	
	@Override
	public String toString() {
		return "\nAccount Information:"
				+ "\nacc_number=" + acc_number + "\npin=" + pin + "\nopen_date=" + open_date + "\nbalance="
				+ balance + "\ntransac_list=" + transac_list + "\nstatus=" + status;
	}

	public void doTransaction(Integer transactionNumber, String description, String type, Date transactionDate,
			double amount)
	{
		Transaction aTransaction = new Transaction(transactionNumber,description,type,transactionDate,amount);		
		if(type == "Deposit")
		{
			aTransaction.deposit(amount, this);
			
		}
		else if (type == "Withdraw")
		{
			if (this.balance>=amount) {
			aTransaction.withdraw(amount, this);
			}
			else {
				System.out.println("Not enough funds!");
			}
		}
		else
		{
			System.out.println("Please enter a valid choice (Withdray or Deposit)");
		}

		this.transac_list.add(aTransaction);
	}
		

	
}
