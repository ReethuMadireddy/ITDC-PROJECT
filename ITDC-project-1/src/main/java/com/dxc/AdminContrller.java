package com.dxc;

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
import com.sun.el.parser.ParseException;

@Controller
public class AdminContrller {
	
	String msg;
	AdminService service=new AdminService();
	
	@RequestMapping("/home")
	public String home()
	{
		return "home.jsp";
	}

	@RequestMapping("/Admin")
	public String adminlogin(@RequestParam int id,@RequestParam int password,HttpSession session,Model  m)
	{
		System.out.println("----------------");
		session.setAttribute("id", "id");
		
		boolean b=service.adminLogin(id, password);
		if(b==true)
		{
			System.out.println("aaaaa");
			return "Adminlogin.jsp";
		}
		else
		{
			msg="admin login failed !!!";
			m.addAttribute("msg", msg);
            return "message.jsp";
		}
	}
	@RequestMapping("/adduser")
	public String addUser(@ModelAttribute User user,Model m) {
	    
	    boolean b=service.addUser(user);
	    if(b==true) {
	        msg="User added succesfully";
	    }
	    else
	    {
	        msg="unable to add user";
	    }
	    m.addAttribute("msg", msg);
	    return "message.jsp";
	    
	}
	
	@RequestMapping("/addhotel")
	public String addHotel(@ModelAttribute Hotel hotel,Model m) {
	    
	    boolean b=service.addHotel(hotel);
	    if(b==true) {
	        msg="Add hotel details success";
	    }
	    else
	    {
	        msg="Add hotel details success";
	    }
	    m.addAttribute("msg", msg);
	    return "message.jsp";
	    
	}
	
@RequestMapping("listofhotels")
	
	public String Selecthotels(Model m,Hotel hotel) 
		{ 
	System.out.println("bbbbbb");
	 		List<Document> list=service.Selecthotel(hotel);
	 		m.addAttribute("list", list); 
	 		return "Displayhotel.jsp"; 
	 	} 

@RequestMapping("/dailybook")
public String dailybooking(@RequestParam String bookedDate,@ModelAttribute Booking booking,Model model) throws ParseException {
    
    List<Document> list=service.dailybooking(bookedDate,booking);
    model.addAttribute("list", list);
    return "Adminbook.jsp";
}
@RequestMapping("/admincancel")
public String cancelOnRequest(@ModelAttribute Booking booking, Model m) {
boolean b = service.cancelOnRequest(booking);
msg = "booking cancelled ";
m.addAttribute("msg",msg);
return "message.jsp";
}

}
