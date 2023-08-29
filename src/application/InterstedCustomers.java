package application;

import java.io.Serializable;
import java.time.LocalDate;

import Utils.Gender;


public class InterstedCustomers  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static int idCounter = 1;
	private String fullname;
	private String phone;
	private String area;
	private int id;
	
	
	public InterstedCustomers(String fullname,String phone, String area) {
		this.id=idCounter++;
		this.fullname = fullname;
		this.phone = phone;
		this.area=area;
		
	}


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "fullname=" + fullname + ", phone=" + phone + ", area=" + area ;
	}
	
	


}
