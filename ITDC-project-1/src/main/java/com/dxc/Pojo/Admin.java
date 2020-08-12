package com.dxc.Pojo;

public class Admin {
	
	private int id;
	private int password;
	
	public void Admin()
	{
		
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", password=" + password + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	

}
