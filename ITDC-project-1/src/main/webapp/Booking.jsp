<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body onload="addDate();" style="background-color: lightblue;">
	<form action="Booking">
	    
		Enter Date of Booking:<input type="text" name="fromDate"><br>
		Enter Vacating Date:<input type="text" name="toDate"><br>
		Enter No.of Rooms:<input type="number" name="brooms"><br>
		Booking date:<input type="text" id="date" name="bookedDate"
			readonly="readonly"><br> <input type="submit"
			value="book">
	</form>

	<script>
        function addDate() {
            date = new Date();
            var month = date.getMonth() + 1;
            var day = date.getDate();
            var year = date.getFullYear();

            if (document.getElementById('date').value == '') {
                document.getElementById('date').value = day + '-' + month + '-'
                        + year;
            }
        }
    </script>



</body>
</html>