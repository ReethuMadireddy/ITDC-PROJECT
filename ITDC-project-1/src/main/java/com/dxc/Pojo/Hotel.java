package com.dxc.Pojo;

public class Hotel {
	
	private String name;
	private String address;
	private String phno;
	private String rooms;
	private String cost;
	
	
	public void Hotel()
	{
		
	}

	

	



	public Hotel(String name, String address, String phno, String rooms, String cost) {
		super();
		this.name = name;
		this.address = address;
		this.phno = phno;
		this.rooms = rooms;
		this.cost = cost;
	}







	public String getName() {
		return name;
	}








	public void setName(String name) {
		this.name = name;
	}








	public String getAddress() {
		return address;
	}








	public void setAddress(String address) {
		this.address = address;
	}








	public String getPhno() {
		return phno;
	}








	public void setPhno(String phno) {
		this.phno = phno;
	}








	public String getRooms() {
		return rooms;
	}








	public void setRooms(String rooms) {
		this.rooms = rooms;
	}








	








	

	public String getCost() {
		return cost;
	}







	public void setCost(String cost) {
		this.cost = cost;
	}







	@Override
	public String toString() {
		return "Hotel [name=" + name + ", address=" + address + ", phno=" + phno + ", rooms=" + rooms + ", cost=" + cost
				+ "]";
	}
		
	

}
