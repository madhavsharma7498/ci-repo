<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="AddProductServlet" method="post">
	Enter ID: <input type="text" name="id"/> <br/>
	Enter Name: <input type="text" name="name"/><br/>
	Enter Price: <input type="text" name="price"/><br/>
	<button type="submit">Add</button>
</form>
</body>
</html>