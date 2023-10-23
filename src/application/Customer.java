package application;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import Utils.Gender;


public class Customer extends Person implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int idCounter = 1;
	private String userName;
	private String password;
	private double wieght;
	private double diff;
	private String fedback;
	private LocalDate date ;
	private ArrayList<music> songs ; 
	
	public ArrayList<music> getSongs() {
		if(songs == null) {
			songs = new ArrayList<music>();
		}
		
		return songs;
	}

	public void setSongs(ArrayList<music> songs) {
		this.songs = songs;
	}


	public Customer(String firstName, String lastName, LocalDate birthDay, Gender gender,String userName, String password) {
		super(idCounter++, firstName, lastName, birthDay, gender);
		this.userName = userName;
		this.password = password;
		LocalDate currentDate = LocalDate.now();
		date  = currentDate.minusDays(1);;
	}
	
	
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}



	public double getDiff() {
		return diff;
	}

	public void setDiff(double diff) {
		this.diff = diff;
	}

	public String getFedback() {
		return fedback;
	}

	public void setFedback(String fedback) {
		this.fedback = fedback;
	}

	
	
	public double getWieght() {
		return wieght;
	}

	public void setWieght(double wieght) {
		this.wieght = wieght;
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
		return userName + " - " + "Current wieght: " + wieght + "Kg Improvement: " + diff + "Kg fedback: " + fedback ;
				
	}


	

	


}
