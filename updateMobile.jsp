<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Mobile</title>
</head>
<body>

<%ResultSet rs = (ResultSet) request.getAttribute("resultSet"); 
  rs.next();
%>

<h1>Enter the Updated Mobile Details</h1>
<form action="update-mobile" method="post">
   <label for="mobileId">Mobile Id:</label>
   <input type="text" value="<%=rs.getInt(1)%>" name="mobileId" readonly="readonly"><br><br>
   <label for="mobileBrand">Mobile Brand:</label>
   <input type="text" value="<%=rs.getString(2)%>" name="mobileBrand" required><br><br>
   <label for="mobileModel">Mobile Model:</label>
   <input type="text" value="<%=rs.getString(3)%>" name="mobileModel" required><br><br>
   <label for="mobilePrice">Mobile Price:</label>
   <input type="text" value="<%=rs.getInt(4)%>" name="mobilePrice" required><br><br>
   
   <input type="submit" value="Update Mobile">
</form>
</body>
</html>