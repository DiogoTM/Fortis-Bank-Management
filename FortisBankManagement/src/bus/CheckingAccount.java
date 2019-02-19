package bus;

import java.util.ArrayList;

public class CheckingAccount extends Account {
	
	int freeTransactions;
	double fees;
	
	public CheckingAccount(Integer acc_number, Integer pin, Date open_date, double balance,
			ArrayList<Transaction> transac_list,boolean status, int freeTransactions, double fees) {
		super(acc_number, pin, open_date, balance, transac_list, status);
		this.freeTransactions = freeTransactions;
		this.fees = fees;
	}
	
	public CheckingAccount() {
		super();
		this.freeTransactions = 4;
		this.fees = 0;
	}
	public int getFreeTransactions() {
		return freeTransactions;
	}
	public void setFreeTransactions(int freeTransactions) {
		this.freeTransactions = freeTransactions;
	}
	public double getFees() {
		return fees;
	}
	public void setFees(double fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return "\nCheckingAccount Information:"+"\nfreeTransactions=" + freeTransactions + "\nfees=" + fees + "\nacc_number=" + acc_number
				+ "\npin=" + pin + "\nopen_date=" + open_date + "\nbalance=" + balance + "\ntransac_list="
				+ transac_list + "\nstatus=" + status;
	}
	
	
	

}
