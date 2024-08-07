<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Displaying Records</title>
</head>
<body>

<% ResultSet rs = (ResultSet) request.getAttribute("resultSet"); %>
<h1 align="center">All Mobile Details</h1>

<table align="center" border = "2" cellpadding = "15px" cellspacing="10px">
   <tr>
     <th>MobileId</th>
     <th>MobileModel</th>
     <th>MobileBrand</th>
     <th>MobilePrice</th>
     <th>Update</th>
     <th>Delete</th>
   </tr>
   
   <% 
      while(rs.next()) {
   %>
   
   <tr>
       <td><%=rs.getInt(1) %></td>
       <td><%=rs.getString(2) %></td>
       <td><%=rs.getString(3) %></td>
       <td><%=rs.getInt(4) %></td>
       <td><a href="existing-data?mobileId=<%=rs.getInt(1)%>">Update</a></td>
       <td><a href="delete-mobile?mobileId=<%=rs.getInt(1)%>">Delete</a></td>
   </tr>
   <%} %>
</table>
<h3>
<a href="result.jsp">Go back to DashBoard</a>
</h3>
</body>
</html>