package application;

import java.io.Serializable;
import java.time.LocalDate;

import Utils.Gender;


public class Customer extends Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int idCounter = 1;
	private String userName;
	private String password;
	
	
	public Customer(String firstName, String lastName, LocalDate birthDay, Gender gender,String userName, String password) {
		super(idCounter++, firstName, lastName, birthDay, gender);
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer(int id) {
		super(id);
	}

	public static int getIdCounter() {
		return idCounter;
	}

	public static void setIdCounter(int idCounter) {
		Customer.idCounter = idCounter;
	}

	

	@Override
	public String toString() {
		return super.toString();
	}
}
