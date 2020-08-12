<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
    table, tr,th, td
                    {
                         border: 1px solid black;
                         width : 40%;
                        text-align: center;
                    }
​    
    </style>   


<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<table>
<tr>
<th>Name</th>
<th>Adress</th>
<th>Phno</th>
<th>Rooms</th>
<th>Cost</th>


 </tr>
<c:forEach var="p" items="${list}">
                        
                        
                            <tr>
                                <td>
                                    <h5><c:out value="${p.name}"></c:out></h5>
                                </td>
                                <td>
                                    <h5><c:out value="${p.address}"></c:out></h5>
                                </td>
                                 <td>
                                    <h5><c:out value="${p.phno}"></c:out></h5>
                                </td> 
                                <td>
                                    <h5><c:out value="${p.rooms}"></c:out></h5>
                                </td>
                                <td>
                                    <h5><c:out value="${p.cost}"></c:out></h5>
                                </td>
                                
                                    
                                  
                            </tr>
                       
                    </c:forEach>       
 </table>
</center>
</body>
</html>