package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;

import bus.Account;
import bus.Customer;
import bus.MissingFileException;
import bus.Transaction;


public class FileHandler {
	
	
	private static String custPath = "src/data/myCustomers.ser";
	private static String accPath = "src/data/myAccounts.ser";
	private static String transPath = "src/data/myTransactions.ser";
	
	//write into binary file
		public static void writeFiles(ArrayList<Customer> myCustomer) throws IOException
		{					
			FileOutputStream   fos1 = new FileOutputStream(custPath);
			ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
			oos1.writeObject(myCustomer);	
			oos1.close();		
					
		}

		//read from binary file
		public static ArrayList<Customer> readCustomer() throws IOException, ClassNotFoundException
		{
			try {
			FileInputStream fis = new FileInputStream(custPath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			ArrayList<Customer> resultList = (ArrayList<Customer>)ois.readObject();		
			ois.close();
			return resultList;
			}
			catch(FileNotFoundException fnfe)
			{
				return null;
			}
			
		}
		

}
