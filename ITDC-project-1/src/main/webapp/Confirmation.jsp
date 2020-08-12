<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:lightblue;">

<form action="confirmed">
  
  <h2><input type="hidden" name="uname" value="${booking.uname}">User name:${booking.uname}<br></h2>  
<h2><input type="hidden" name="name" value="${hotel.name}">hotel:${hotel.name}<br></h2>
<h4><input type="hidden" name="address" value="${hotel.address}">Adress:${hotel.address}<br></h4>
<h4><input type="hidden" name="phno" value="${hotel.phno}">Phone no:${hotel.phno}<br></h4>
<h4><input type="hidden" name="brooms" value="${booking.brooms}">Rooms:${booking.brooms}<br></h4>

    <c:set var="cost" value="${hotel.cost}"></c:set>       
    <c:set var="brooms" value="${booking.brooms}"></c:set>   
    <c:set var="totalcost" value="${brooms * cost}"></c:set>   
    <c:set var="uname" value="${booking.uname} "></c:set>
    <c:set var="fromDate" value="${booking.fromDate} "></c:set>
    <c:set var="toDate" value="${booking.toDate} "></c:set>
    <c:set var="bookedDate" value="${booking.bookedDate} "></c:set>

 
   
    <h4><input type="hidden" name="cost" value="${totalcost}">Cost : ${totalcost}</h4>
    <h4><input type="hidden" name="fromDate" value="${booking.fromDate}">From Date : ${booking.fromDate} </h4>
    <h4><input type="hidden" name="toDate" value="${booking.toDate }"> To Date :${booking.toDate } </h4>
    <h4><input type="hidden" name="bookedDate" value="${booking.bookedDate}">Date You Booked : ${booking.bookedDate}  </h4>
    
   
    <input type="submit">
 </form>
</body>
</html>