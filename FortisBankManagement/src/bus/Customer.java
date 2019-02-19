package bus;

import java.io.Serializable;
import java.util.ArrayList;

public class Customer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String fn,ln,email,phone;
	Account checkAccount;
	ArrayList<Account> accountList;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFn() {
		return fn;
	}
	public void setFn(String fn) {
		this.fn = fn;
	}
	public String getLn() {
		return ln;
	}
	public void setLn(String ln) {
		this.ln = ln;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Account getCheckAccount() {
		return checkAccount;
	}
	public void setCheckAccount(Account checkAccount) {
		this.checkAccount = checkAccount;
	
	}
	public ArrayList<Account> getAccountList() {
		return accountList;
	}
	
	public void setAccountList(ArrayList<Account> accountList) {
		this.accountList = accountList;
	}
	public Customer(int id, String fn, String ln, String email, String phone, Account checkAccount,
			ArrayList<Account> accountList) {
		super();
		this.id = id;
		this.fn = fn;
		this.ln = ln;
		this.email = email;
		this.phone = phone;
		this.checkAccount = checkAccount;
		this.accountList = accountList;
		this.accountList.add(checkAccount);
	}
	public Customer() {
		super();
		this.id = 0;
		this.fn = " ";
		this.ln = " ";
		this.email = " ";
		this.phone = " ";
		this.checkAccount = new CheckingAccount();
		this.accountList = new ArrayList<Account>();
		this.accountList.add(checkAccount);
	}
	@Override
	public String toString() {
		return "\nCustomer Information:"+"\nid=" + id + "\nfn=" + fn + "\nln=" + ln + "\nemail=" + email + "\nphone=" + phone
				+ "\ncheckAccount=" + checkAccount + "\naccountList=" + accountList;
	}

	
	
	public void openSavingAccount(Integer pin, Date open_date, double balance,
			ArrayList<Transaction> transac_list, boolean status,double annualInterest, double annualGain, double extraFees) {
		int acc_number = this.accountList.size()+1;
		Account savingAccount = new SavingAccount(acc_number, pin, open_date, balance,transac_list, status,annualInterest,annualGain,extraFees);
		this.accountList.add(savingAccount);		
	}
	
	public void openCheckingAccount(Integer pin, Date open_date, double balance,
			ArrayList<Transaction> transac_list, boolean status,int freeTransactions, double fees) {
		int acc_number = this.accountList.size()+1;
		Account checkAccount = new CheckingAccount(acc_number, pin, open_date, balance,transac_list,status,freeTransactions,fees);
		this.accountList.add(checkAccount);		
	}
	
	public void closeAccount(Account accountToClose) {
		
		if(accountToClose instanceof CheckingAccount) {
			System.out.println("Cannot close a checking account, contact your branch!");
		}
		else {
			this.accountList.get(this.accountList.indexOf(accountToClose)).status = false;		
			System.out.println("Account closed succesfully!");
		}
	}
	
	
	
	
	
	
	
	
	

}
