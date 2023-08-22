package application;

import java.io.Serializable;
import java.util.HashMap;




public class Gym implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static Gym gym = null;
	
	private HashMap<Integer, Customer> customers;
	
	public static Gym getInstance()
	{
		if(gym == null)
			gym = new Gym();
		return gym;
	}
	
	private Gym() {
		
		customers = new HashMap<>();
		
	}
	
	public HashMap<Integer, Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(HashMap<Integer, Customer> customers) {
		this.customers = customers;
	}
	
	public boolean addCustomer(Customer cust) {
		if(cust == null || getCustomers().containsKey(cust.getId()))
			return false;

  	return getCustomers().put(cust.getId(), cust) ==null;
		
	}

}
