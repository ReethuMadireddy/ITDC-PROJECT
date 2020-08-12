package com.dxc;

import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.Pojo.Booking;
import com.dxc.Pojo.Hotel;
import com.dxc.Pojo.User;
import com.dxc.Service.AdminService;
import com.dxc.Service.UserService;
import com.sun.el.parser.ParseException;

@Controller
public class UserController {
	
	String msg;
	String rooms;
	String toDate;
	String fromDate;
	String bookedDate;
	Hotel hotel;
	private String uid = null;
    private String uname = null;
    private String brooms=null;
    private String u=null;
    User u1=new User();
	
	UserService uservice = new UserService(); 
	
	
	
	@RequestMapping("/User")
	public String userlogin(@RequestParam("uname") String uname,@RequestParam String password,HttpSession session,Model  m)
	{
		System.out.println("----------------");
		//String u=(String)session.setAttribute("uname", uname);
		u1.setUname(uname);
		this.u=uname;
		
		boolean b=uservice.userLogin(uname, password);
		if(b==true)
		{
			
			return "Customerlogin.jsp";
		}
		else
		{
			msg="user login failed !!!";
			m.addAttribute("msg", msg);
            return "message.jsp";
		}
	}
	
@RequestMapping("/details")
	
	public String Selecthotel(Model m,Hotel hotel) 
		{ 
	System.out.println("bbbbbb");
	 		List<Document> list=uservice.Selecthotel(hotel);
	 		m.addAttribute("list", list); 
	 		return "Viewhotel.jsp"; 
	 	} 

@RequestMapping("/show")
public String userbookroom(@ModelAttribute Hotel hotel,Model model) {
    this.hotel=hotel;
    model.addAttribute("hotel", hotel);
    return "Booking.jsp";

}

@RequestMapping("/Booking")
public String booking(HttpSession session,@RequestParam String fromDate,@RequestParam String toDate,
		@RequestParam String brooms,@RequestParam String bookedDate,Model m,@ModelAttribute Booking booking,@ModelAttribute User user) throws java.text.ParseException 
{
	
	this.fromDate = fromDate;
	this.toDate = toDate;
	this.rooms = brooms;
	this.bookedDate = bookedDate;
	
	//String u=(String) session.getAttribute("uname");
	String uu=u;
	booking.setUname(uu);
	System.out.println("!!!!!!!!!!!!!" + uu);
    booking.setFromDate(fromDate);
    booking.setToDate(toDate);
    booking.setBookedDate(bookedDate);
    booking.setBrooms(brooms);
    
    
    //int givenrooms=Integer.parseInt(userrroms);
    //int allrooms=Integer.parseInt(hotel.getHotelrooms());
	//Hotel h=new Hotel();
	int enteredRooms=Integer.parseInt(rooms);
	int totalRooms=Integer.parseInt(hotel.getRooms());	
	System.out.println(enteredRooms);
	System.out.println(totalRooms);
	SimpleDateFormat sdformat=new SimpleDateFormat("MM-dd-yyyy");
	Date from=sdformat.parse(fromDate);
	Date to=sdformat.parse(toDate);
	Date sys=sdformat.parse(bookedDate);
	
	if(from.compareTo(sys) >= 0 && to.compareTo(sys) >= 0)
	{
		System.out.println("first statment");
		if(to.compareTo(from)>=0)
		{
			System.out.println("second statement");
		if(enteredRooms < totalRooms)
		{
			System.out.println("third statement");
			m.addAttribute("hotel",hotel);
			m.addAttribute("booking",booking);
			m.addAttribute("user",user);
		    return "Confirmation.jsp";
		   
		}
		else
		{
			msg="rooms unavailable";
			m.addAttribute("msg",msg);
		}
		}	
		else
		{
			System.out.println("22");
			msg="invalid to date";
			m.addAttribute("msg",msg);
		}
		
	}
	else
	{
		msg="invalid from date";
		m.addAttribute("msg",msg);
	}
	return "message.jsp";
}

@RequestMapping("/confirmed")
public String confirmBooking(@ModelAttribute Booking booking,@ModelAttribute Hotel hotel,@ModelAttribute User user,Model model) {
//String uu = uname;
//String id = uphn;
	String uu=u;
String r = rooms;
boolean b=uservice.confirmBooking(booking, hotel, user, r,uu);
if(b==true) {
   
msg="confirmed booking";
model.addAttribute("msg", msg);
}
return "message.jsp";

}


@RequestMapping("/bookingsHistory")
    public String bookingHistory(@ModelAttribute Booking booking, Model m) {
	
        String id = u;
        System.out.println("hhii" +id);
        List<Document> list = uservice.bookingHistory(booking, id);
        m.addAttribute("list", list);
        return "Bookinghistory.jsp";


    }
    
    @RequestMapping("/userGaveCancelRequest")
    public String userGaveCancelRequest(@ModelAttribute Booking booking, Model m) {
        boolean b = uservice.userGaveCancelRequest(booking);
        if(b==true) {
        msg = "Request For Cancellation Successful";
        m.addAttribute("msg", msg);
        }
        return "message.jsp";
    }
 

}

