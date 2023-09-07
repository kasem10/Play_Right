package application;

import java.io.Serializable;
import java.util.HashMap;





public class Gym implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static Gym gym = null;
	
	private HashMap<Integer, Customer> customers;
	
	private HashMap<Integer, interestedjoin> interestedjoin;
	private HashMap<Integer, Meal>  meals;
	
	private HashMap<Integer, music> music;
	

	public static Gym getInstance()
	{
		
		if(gym == null)
			gym = new Gym();
		
		return gym;
	}
	
	private Gym() {
		
		customers = new HashMap<>();
		interestedjoin = new HashMap<>();
		meals = new HashMap<>();
		music = new HashMap<>();
		
	}
	
	public HashMap<Integer, Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(HashMap<Integer, Customer> customers) {
		this.customers = customers;
	}
	
	public HashMap<Integer, Meal> getMeals() {
		
		return meals;
	}

	public void setMeals(HashMap<Integer, Meal> meals) {
		this.meals = meals;
	}
	public HashMap<Integer, interestedjoin> getinterestedjoin() {
	
		return interestedjoin;
	}

	public void setinterestedjoin(HashMap<Integer, interestedjoin> customers) {
		this.interestedjoin = customers;
	}
	
	public HashMap<Integer, music> getMusic() {
		
		return music;
	}

	public void setMusic(HashMap<Integer, music> music) {
		this.music = music;
	}
	
	
	public boolean addCustomer(Customer cust) {
		if(cust == null || getCustomers().containsKey(cust.getId()))
			return false;
		
		

  	return getCustomers().put(cust.getId(), cust) ==null;
		
	}
	
    public boolean addinterestedjoin(interestedjoin cust) {
	    
	
		if(cust == null || getinterestedjoin().containsKey(cust.getId())) {
			
			return false;
		}

  	return getinterestedjoin().put(cust.getId(), cust) ==null;
		
	}
    public boolean addnewmeal(Meal meal) {
	    
    	
    		if(meal == null || getMeals().containsKey(meal.getId())) {
    			
    			return false;
    		}

      	return getMeals().put(meal.getId(), meal) ==null;
    		
    	}
    
    public boolean removemeal(Meal meal) {
		if(meal == null || !getMeals().containsKey(meal.getId()))
			return false;
		return getMeals().remove(meal.getId(), meal);
	}
    
    
    public boolean addMusic(music music) {
    	
    	
    	
    	if(music == null || getMusic().containsKey(music.getId())) {
			
			return false;
		}

  	 return getMusic().put(music.getId(), music) ==null;
    	
    }
    public boolean removemusic(music music) {
		if(music == null || !getMusic().containsKey(music.getId()))
			return false;
		return getMusic().remove(music.getId(), music);
	}

}
