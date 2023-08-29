package application;

import java.io.Serializable;
import java.util.HashMap;




public class Gym implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static Gym gym = null;
	
	private HashMap<Integer, Customer> customers;
	private HashMap<Integer, InterstedCustomers> interstedCustomers;
	
	
	public static Gym getInstance()
	{
		if(gym == null)
			gym = new Gym();
		return gym;
	}
	
	private Gym() {
		
		customers = new HashMap<>();
		interstedCustomers = new HashMap<>();
		
		
	}
	
	public HashMap<Integer, Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(HashMap<Integer, Customer> customers) {
		this.customers = customers;
	}
	
	public HashMap<Integer, InterstedCustomers> getinterstedCustomers() {
		return interstedCustomers;
	}

	public void setinterstedCustomers(HashMap<Integer, InterstedCustomers> customers) {
		this.interstedCustomers = customers;
	}
	
	
	public boolean addCustomer(Customer cust) {
		if(cust == null || getCustomers().containsKey(cust.getId()))
			return false;

  	return getCustomers().put(cust.getId(), cust) ==null;
		
	}
	
	public boolean addinterstedCustomers(InterstedCustomers cust) {
		if(cust == null || getinterstedCustomers().containsKey(cust.getId())) {
			System.out.println("kkkkkkkkkkk");
			return false;
		}

  	return getinterstedCustomers().put(cust.getId(), cust) ==null;
		
	}

}
