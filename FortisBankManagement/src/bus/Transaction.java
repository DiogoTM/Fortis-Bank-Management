package bus;

import java.io.Serializable;

public class Transaction  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Integer transactionNumber;
	String description,type;
	Date transactionDate;
	double amount;
	
	
	public Integer getTransactionNumber() {
		return transactionNumber;
	}
	public void setTransactionNumber(Integer transactionNumber) {
		this.transactionNumber = transactionNumber;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Transaction(Integer transactionNumber, String description, String type, Date transactionDate,
			double amount) {
		super();
		this.transactionNumber = transactionNumber;
		this.description = description;
		this.type = type;
		this.transactionDate = transactionDate;
		this.amount = amount;
	}
	public Transaction() {
		super();
		this.transactionNumber = 0;
		this.description = " ";
		this.type = " ";
		this.transactionDate = new Date(01,01,1999);
		this.amount = 0;
	}
	@Override
	public String toString() {
		return "\nTransaction Information: "+ "\ntransactionNumber=" + transactionNumber + "\ndescription=" + description + "\ntype=" + type
				+ "\ntransactionDate=" + transactionDate + "\namount=" + amount;
	}
	
	public Boolean withdraw (double amount, Account aAccount) {
		Boolean result;
		double endAmount = aAccount.balance - amount;
		if (endAmount >= 0)
		{ 
			aAccount.setBalance(endAmount);
			System.out.println("\nWithdraw succesful!");
			result = true; 
		}
		else
		{
			result = false;
		}
		return result;		
	}
	public Boolean deposit (double amount, Account aAccount) {
		Boolean result;
		double endAmount = aAccount.balance + amount;
		if (endAmount >= 0)
		{
			aAccount.setBalance(endAmount);
			System.out.println("\nDeposit succesful!");
			result = true; 
		}
		else
		{
			result = false;
		}
		return result;		
	}
	
	
	
}
