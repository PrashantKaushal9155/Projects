<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mobile Management System</title>
</head>
<body>
<h1 align="center">Mobile DashBoard</h1><br>
<form action="add-Mobile" method="post">
 <label for="mobileid">Mobile Id:</label>
 <input type="text" id="mobileid" name="mobileId"> <br><br>
  <label for="mobilemodel">Mobile Model::</label>
 <input type="text" id="mobilemodel" name="mobileModel"> <br><br>
  <label for="mobilebrand">Mobile Brand:</label>
 <input type="text" id="mobilebrand" name="mobileBrand"> <br><br>
  <label for="mobileprice">Mobile Price:</label>
 <input type="text" id="mobileprice" name="mobilePrice"> <br><br>
 <input type="submit" value="Add Mobile">
</form>
</body>
</html>