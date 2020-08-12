package com.dxc.Dao;

import java.util.ArrayList;

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

public class UserDao {

	MongoClient mongoclient=new MongoClient("localhost",27017);
	MongoDatabase mongodatabase=mongoclient.getDatabase("itdc");

public boolean userLogin(String uname, String password)
{
	MongoCollection<Document>  collection=mongodatabase.getCollection("user");
	List<Document> list=(List<Document>) collection.find().into(new ArrayList<>());
	
	for (Document d : list) {

		String u=(String) d.get("uname");
		String p=(String) d.get("password");
		//double p=(double) d.get("password");

		if(uname.equals(u) && password.equals(p))
		{
			return true;
		}
	}

	return false;

	
}

public List<Document> Selecthotel(Hotel hotel) {
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

public boolean confirmBooking(Booking booking, Hotel hotel, User user,  String r,String uu) 
{
	
	  Document d2 = new Document();
      d2.append("rooms", r);
      MongoCollection<Document> collection = mongodatabase.getCollection("hotel1");

      List<Document> list = (List<Document>) collection.find(d2).into(new ArrayList<>());
      FindIterable<Document> cursor = collection.find();

      MongoCursor<Document> itr = cursor.iterator();
      System.out.println(hotel.getName() +" ==-=-=-=-=-=-=-=-");
      System.out.println(hotel.getRooms()+" ;;;;;;;;;;;;;;");
      while (itr.hasNext())
      {
          Document d = itr.next();
          String dbName = d.getString("name");
            
          if (hotel.getName().equals(dbName))
          {
        	  
        	 
               int userGivenRooms =Integer.parseInt(r)  ;
              int hotelRooms =Integer.parseInt( d.getString("rooms"));
              System.out.println("aaaaaa" +hotelRooms);
             int finalRooms = hotelRooms - userGivenRooms;
             System.out.println("-------"+ userGivenRooms);
             String fr = Integer.toString(finalRooms);
             System.out.println("BBBBbbb" +finalRooms);

              Document o = new Document();
              o.append("name", d.getString("name"));

              Document u = new Document();
              u.append("$set", new Document("rooms", fr));
              collection.updateOne(o, u);
              cursor = collection.find();
              itr = cursor.iterator();
              while (itr.hasNext()) {
                  list.add(itr.next());
              }
          }
      }
     MongoCollection<Document> mongoCollection = mongodatabase.getCollection("booking");
    List<Document> documents = mongoCollection.find().into(new ArrayList<>());
    
    
    String phno = hotel.getPhno();
    String name = hotel.getName();
    String address = booking.getAddress();
    String brooms = booking.getBrooms();
    System.out.println(brooms);
    String cost = booking.getCost();
    String fdate = booking.getFromDate();
    String tdate = booking.getToDate();
    String bdate = booking.getBookedDate();
    String status = "booked";
       
    Document d1 = new Document();
   
    d1.append("uname",uu);
    d1.append("name", name);
    d1.append("address", address);
    d1.append("phno", phno);
    d1.append("brooms", brooms);
    d1.append("cost", cost);
    d1.append("fromDate", fdate);
    d1.append("toDate", tdate);
    d1.append("bookedDate", bdate);
    d1.append("status", status);
    mongoCollection.insertOne(d1);
    return true;
	
}

public List<Document> bookingHistory(Booking booking, String id) {
	 Document d2 = new Document();
     d2.append("uname", id);

     MongoCollection<Document> collection = mongodatabase.getCollection("booking");
   List<Document> list = (List<Document>) collection.find(d2).into(new ArrayList<>());
     FindIterable<Document> cursor = collection.find();
     
    

     MongoCursor<Document> itr = cursor.iterator();
      while (itr.hasNext()) {
         Document d = itr.next();
         String d1 = d.getString("uname");
         System.out.println(d1);

         System.out.println("999999999999999999999");
         if (id == d1 ) {
        	 System.out.println("helloooooooooo");
             list.add(d2);
             System.out.println(list);
         }
     }
	return list;
}

public boolean userGaveCancelRequest(Booking booking) {
	MongoCollection<Document> mongoCollection = mongodatabase.getCollection("booking");
    List<Document> documents = mongoCollection.find().into(new ArrayList<>());

    String status = "requested";
    System.out.println(booking.getBookedDate());
    
    Document refno = new Document();
    refno.append("bookedDate", booking.getBookedDate());


    Document d1 = new Document();
    d1.append("$set", new Document("status",status));
    mongoCollection.updateOne(refno,d1);
    return true;

}
}
