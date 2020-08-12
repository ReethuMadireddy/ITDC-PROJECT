package com.dxc.Dao;

import java.util.ArrayList;

import java.util.Iterator;
import java.util.List;

import org.bson.Document;

import com.dxc.Pojo.Booking;
import com.dxc.Pojo.Hotel;
import com.dxc.Pojo.User;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.sun.el.parser.ParseException;

public class AdminDao {

	MongoClient mongoclient=new MongoClient("localhost",27017);
	MongoDatabase mongodatabase=mongoclient.getDatabase("itdc");



	public boolean adminLogin(int id, int password) 
	{
		MongoCollection<Document>  collection=mongodatabase.getCollection("admin1");

		List<Document> list=(List<Document>) collection.find().into(new ArrayList<>());

		for (Document d : list) {

			double u=(double) d.get("id");
			double p=(double) d.get("password");

			if(id==u && password==p)
			{
				return true;
			}
		}

		return false;
	}
public boolean addUser(User user) {
	MongoCollection<Document>  collection=mongodatabase.getCollection("user");
	List<Document> list= collection.find().into(new ArrayList<>());
		
	String username=user.getUname();
	String userpassword =user.getPassword();
	
	for (Document d : list) {
		Document d1=new Document();
		
		d1.append("uname",username);
		d1.append("password",userpassword);
		
		collection.insertOne(d1);
	
		return true;
	}
	return false;
	}


	public boolean addHotel(Hotel hotel)
	{

		MongoCollection<Document>  collection=mongodatabase.getCollection("hotel1");
		List<Document> list= collection.find().into(new ArrayList<>());

		String hotelname=hotel.getName();
		String hoteladdress=hotel.getAddress();
		String hotelphnno=hotel.getPhno();
		String hotelrooms=hotel.getRooms();
		String hotelcost=hotel.getCost();
		

		for (Document d : list) {
			Document d1=new Document();
			d1.append("name", hotelname);
			d1.append("address", hoteladdress);
			d1.append("phno", hotelphnno);
			d1.append("rooms", hotelrooms);
			d1.append("cost", hotelcost);
			
			collection.insertOne(d1);

			return true;
		}
		return false;
	}

	public List<Document> selecthotel(Hotel hotel)
	{
		MongoCollection<Document>  collection=mongodatabase.getCollection("hotel1");
		List<Document> list= new ArrayList<Document>();

		System.out.println("ccccccc");

		FindIterable<Document> cursor=collection.find();
		MongoCursor<Document> itr= cursor.iterator();

		while(itr.hasNext())
		{
			Document d=itr.next();
			list.add(d);
		}
		return list;

	}

	public List<Document> dailybooking(String bookedDate, Booking booking) throws ParseException
	{

        Document d1 = new Document();
        d1.append("bookedDate", bookedDate);
        MongoCollection<Document>  collection=mongodatabase.getCollection("booking");
        List<Document> list = (List<Document>) collection.find(d1).into(new ArrayList<>());
        FindIterable<Document> cursor = collection.find();
        MongoCursor<Document> itr = cursor.iterator();
        while(itr.hasNext()) {
            Document d = itr.next();
            String d2 = d.getString("bookedDate");

 

            if(bookedDate == d2) {
                list.add(d1);
            }
        }

 

      return list;	

}
	public boolean cancelOnRequest(Booking booking)
	{
	       MongoCollection<Document> mongoCollection = mongodatabase.getCollection("booking");
	        List<Document> documents = mongoCollection.find().into(new ArrayList<>());

	        System.out.println(" cancel on rqst ------");
	        String status = "cancelled";
	       
	        
	        Document refno = new Document();
	        refno.append("bookedDate", booking.getBookedDate());
	        refno.append("phno", booking.getPhno());
	       

	        Document d1 = new Document();
	        d1.append("$set", new Document("status",status));
	        mongoCollection.updateOne(refno,d1);
	        return true;
	}
}


	




