<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:lightpink;">
<form action="admincancel">
<center>
<h1>Daily Booking</h1>
<table>
<tr>
<th>Name</th>
<th>Adress</th>
<th>Phno</th>
<th>Rooms</th>
<th>Cost</th>
<th>FromDate</th>
<th>ToDate</th>
<th>BookedDate</th>
<th>Status</th>

 </tr>
<c:forEach var="s" items="${list}">
                 
                   <tr>     
                     <td><input type="hidden" name="username" value="${s.uname}">${s.uname}</td>
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
                       
                    </c:forEach>       
 </table>
</center>
</form>
</body>
</html>