package com.dxc.Service;

import java.util.List;

import org.bson.Document;

import com.dxc.Dao.AdminDao;
import com.dxc.Pojo.Booking;
import com.dxc.Pojo.Hotel;
import com.dxc.Pojo.User;
import com.sun.el.parser.ParseException;

public class AdminService {
	
	AdminDao adminDao=new AdminDao();

	 

    public boolean adminLogin(int id, int password) {
        
        return adminDao.adminLogin(id, password);
    }

 public boolean addUser(User user) {
        
        return adminDao.addUser(user);
    }

    public boolean addHotel(Hotel hotel) {
        
        return adminDao.addHotel(hotel);
    }



	public List<Document> Selecthotel(Hotel hotel) {
	
		return adminDao.selecthotel(hotel);
	}

	public List<Document> dailybooking(String bookedDate, Booking booking) throws ParseException {
		
		return adminDao.dailybooking( bookedDate,  booking);
	}

	public boolean cancelOnRequest(Booking booking) {
		
		return adminDao.cancelOnRequest( booking);
	}

}
