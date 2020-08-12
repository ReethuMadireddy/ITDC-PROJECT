package com.dxc.Service;

import java.util.List;

import org.bson.Document;

import com.dxc.Dao.UserDao;
import com.dxc.Pojo.Booking;
import com.dxc.Pojo.Hotel;
import com.dxc.Pojo.User;

public class UserService {
	UserDao udao=new UserDao();

	public boolean userLogin(String uname, String password)
	{
				return udao.userLogin(uname,password);
	}

	public List<Document> Selecthotel(Hotel hotel) 
	{
		return udao.Selecthotel(hotel);
	}

	public boolean confirmBooking(Booking booking, Hotel hotel, User user, String r,String uu) {
		
		return udao.confirmBooking(booking, hotel, user,  r,uu);
	}

	public List<Document> bookingHistory(Booking booking, String id) {
		
		return udao.bookingHistory( booking,  id);
	}

	public boolean userGaveCancelRequest(Booking booking) {
		
		return udao.userGaveCancelRequest(booking);
	}
	

}
