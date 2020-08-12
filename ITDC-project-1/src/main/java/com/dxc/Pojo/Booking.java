package com.dxc.Pojo;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Booking {

@Id
private String sno;
private String uname;
private String name;
private String address;
private String phno;
private String brooms;
private String cost;
private String fromDate;
private String toDate;
private String bookedDate;
private String status;

public  Booking()
{
	
}







public Booking(String sno, String uname, String name, String address, String phno, String brooms, String cost,
		String fromDate, String toDate, String bookedDate, String status) {
	super();
	this.sno = sno;
	this.uname = uname;
	this.name = name;
	this.address = address;
	this.phno = phno;
	this.brooms = brooms;
	this.cost = cost;
	this.fromDate = fromDate;
	this.toDate = toDate;
	this.bookedDate = bookedDate;
	this.status = status;
}







@Override
public String toString() {
	return "Booking [sno=" + sno + ", uname=" + uname +  ", name=" + name + ", address="
			+ address + ", phno=" + phno + ", brooms=" + brooms + ", cost=" + cost + ", fromDate=" + fromDate
			+ ", toDate=" + toDate + ", bookedDate=" + bookedDate + ", status=" + status + "]";
}



public String getSno() {
	return sno;
}


public void setSno(String sno) {
	this.sno = sno;
}


public String getUname() {
	return uname;
}


public void setUname(String uname) {
	this.uname = uname;
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



public String getBrooms() {
	return brooms;
}



public void setBrooms(String brooms) {
	this.brooms = brooms;
}






public String getCost() {
	return cost;
}







public void setCost(String cost) {
	this.cost = cost;
}







public String getFromDate() {
	return fromDate;
}


public void setFromDate(String fromDate) {
	this.fromDate = fromDate;
}


public String getToDate() {
	return toDate;
}


public void setToDate(String toDate) {
	this.toDate = toDate;
}


public String getBookedDate() {
	return bookedDate;
}


public void setBookedDate(String bookedDate) {
	this.bookedDate = bookedDate;
}


public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}






}
