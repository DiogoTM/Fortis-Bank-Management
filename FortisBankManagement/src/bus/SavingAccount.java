package bus;

import java.util.ArrayList;

public class SavingAccount extends Account{
	
	double annualInterest, annualGain, extraFees;

	public double getAnnualInterest() {
		return annualInterest;
	}

	public void setAnnualInterest(double annualInterest) {
		this.annualInterest = annualInterest;
	}

	public double getAnnualGain() {
		return annualGain;
	}

	public void setAnnualGain() {
		this.annualGain = annualInterest*balance;
	}

	public double getExtraFees() {
		return extraFees;
	}

	public void setExtraFees(double extraFees) {
		this.extraFees = extraFees;
	}

	public SavingAccount(Integer acc_number, Integer pin, Date open_date, double balance,
			ArrayList<Transaction> transac_list, boolean status,double annualInterest, double annualGain, double extraFees) {
		super(acc_number, pin, open_date, balance, transac_list, status);
		this.annualInterest = annualInterest;
		this.annualGain = annualGain;
		this.extraFees = extraFees;
	}

	public SavingAccount() {
		super();
		this.annualInterest = 0;
		this.annualGain = 0;
		this.extraFees = 0;
	}

	@Override
	public String toString() {
		return "\nSavingAccount Information: " +"\nannualInterest=" + annualInterest + "\nannualGain=" + annualGain + "\nextraFees="
				+ extraFees + "\nacc_number=" + acc_number + "\npin=" + pin + "\nopen_date=" + open_date + "\nbalance="
				+ balance + "\ntransac_list=" + transac_list + "\nstatus=" + status;
	}

	

	

}
