package bus;

public class CreditAccount extends Account{
	
	Date dueDate;
	double creditLimitl;
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public double getCreditLimitl() {
		return creditLimitl;
	}
	public void setCreditLimitl(double creditLimitl) {
		this.creditLimitl = creditLimitl;
	}
	public CreditAccount(Date dueDate, double creditLimitl) {
		super();
		this.dueDate = dueDate;
		this.creditLimitl = creditLimitl;
	}
	public CreditAccount() {
		super();
		this.dueDate = new Date(01,01,1999);
		this.creditLimitl = 0;
	}
	@Override
	public String toString() {
		return "\nCreditAccount Information: "+"\ndueDate=" + dueDate + "\ncreditLimitl=" + creditLimitl;
	}
	
	

}
