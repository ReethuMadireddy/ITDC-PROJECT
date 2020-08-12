<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, tr, th, td {
                        border: 1px solid black;
                         width : 40%;
                        text-align: center;
}

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


 

    <table>
        
            <tr>
                <th>User Name</th>
                <th>Hotel Name</th>
                <th>Hotel Address</th>
                <th>Hotel Phone Number</th>
                <th>Rooms Booked</th>
                <th>Cost On Booking</th>
                <th>Booking Date</th>
                <th>Vacating Date</th>
                <th>Room Booked Date</th>
                <th>Status</th>
                <th>Request For Cancel</th>
            </tr>
               
        
            <c:forEach var="s" items="${list}">
             
         <form action="userGaveCancelRequest">
           <tr>
                    <td><input type="hidden" name="uname" value="${s.uname}">${s.uname}</td>
                    <td><input type="hidden" name="name" value="${s.name}">${s.name}</td>
                    <td><input type="hidden" name="address" value="${s.address}">${s.address}</td>
                    <td><input type="hidden" name="phno" value="${s.phno}">${s.phno}</td>
                    <td><input type="hidden" name="brooms" value="${s.brooms}">${s.brooms}</td>
                    <td><input type="hidden" name="cost" value="${s.cost}">${s.cost}</td>
                    <td><input type="hidden" name="fromDate" value="${s.fromDate}">${s.fromDate}</td>
                    <td><input type="hidden" name="toDate" value="${s.toDate}">${s.toDate}</td>
                    <td><input type="hidden" name="bookedDate" value="${s.bookedDate}">${s.bookedDate}</td>
                    <td><input type="hidden" name="status" value="${s.status}">${s.status}</td>
                    <td><button id="firstbutton" onclick="disablefirstbutton()">Cancel</button></td>
              </tr>  
            
              </form>  
                
            </c:forEach>
            
       </table>
   
   </body>
</html>