<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
 <c:forEach var="hotel" items="${list}">
    <fieldset style="width: 300px; height: 360px; border-radius: 10px; border: solid 2px black;">
        <form action = "show">
            <h2><input type="hidden" name="name" value="${hotel.name}">Hotel Name : ${hotel.name}</h2>
            <h4><input type="hidden" name="address" value="${hotel.address}">Address : ${hotel.address}</h4>
            <h4><input type="hidden" name="phno" value="${hotel.phno}">Phone Number : ${hotel.phno}</h4>
            <h4><input type="hidden" name="rooms" value="${hotel.rooms}"> Rooms : ${hotel.rooms}</h4>
            <h4><input type="hidden" name="cost" value="${hotel.cost}">  Cost : ${hotel.cost}</h4>
           
            <input type ="submit" value="Book Now">
        </form>
      </fieldset> <br>
    </c:forEach>
    <input type="hidden">
    </center>
</body>
</html>