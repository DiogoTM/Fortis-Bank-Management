package bus;

import java.io.Serializable;

public class Date implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int day;
	int month;
	int year;
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Date(int day, int month, int year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public Date() {
		super();
		this.day = 01;
		this.month = 01;
		this.year = 1999;
	
	}
	@Override
	public String toString() {
		return "Date: "+ day + "/" + month + "/" + year ;
	}
	
	

}
