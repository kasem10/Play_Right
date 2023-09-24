package application;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;





public class Gym implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private static Gym gym = null;
	
	private HashMap<Integer, Customer> customers;
	
	private HashMap<Integer, interestedjoin> interestedjoin;
	private HashMap<Integer, Meal>  meals;
	
	private HashMap<Integer, music> music;
	
	
	
	 HashMap<Integer, ArrayList<exercise>> mb3;
	 HashMap<Integer, ArrayList<exercise>> mb4;
	 HashMap<Integer, ArrayList<exercise>> mb5;
	
	
	
	
	ArrayList<exercise> Weightlose3daya;
	

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
	
	
	
	

	public ArrayList<exercise> getWeightlose3daya() {
		
		return Weightlose3daya;
	}

	public void setWeightlose3daya(ArrayList<exercise> weightlose3daya) {
		Weightlose3daya = weightlose3daya;
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
		
		
		
		 mb3  = new HashMap<>();
		 mb4 = new HashMap<>() ; 
		 mb5 = new HashMap<>();
		 
		 ArrayList<exercise> exerciseList = mb3.get(1);
		 if (exerciseList == null) {
		     // The ArrayList for key 1 doesn't exist, create it
		     exerciseList = new ArrayList<>();
		     mb3.put(1, exerciseList);
		 }
		 ArrayList<exercise> exerciseList2 = mb3.get(2);
		 if (exerciseList2 == null) {
		     // The ArrayList for key 1 doesn't exist, create it
		     exerciseList2 = new ArrayList<>();
		     mb3.put(2, exerciseList2);
		 }
		 ArrayList<exercise> exerciseList3 = mb3.get(3);
		 if (exerciseList3 == null) {
		     // The ArrayList for key 1 doesn't exist, create it
		     exerciseList3 = new ArrayList<>();
		     mb3.put(3, exerciseList3);
		 }
		 
		 Main.update();
		 
		 
		
		
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
    
 public boolean addex(exercise ex, String goal , int day) {
	 
	 
	

	 
	 
    	if(goal.equals("mb3")) {
    		
    		mb3.get(day).add(ex);
    	}
    	if(goal.equals("mb4")) {
    		mb4.get(day).add(ex);
    	}
    	if(goal.equals("mb5")) {
    		mb5.get(day).add(ex);
    	}
    

  	 return true;
    	
    }
    public boolean removemusic(music music) {
		if(music == null || !getMusic().containsKey(music.getId()))
			return false;
		return getMusic().remove(music.getId(), music);
	}

}
