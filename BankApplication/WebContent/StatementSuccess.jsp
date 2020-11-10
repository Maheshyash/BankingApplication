<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success Page</title>
</head>
<body>
	<%
		session =request.getSession();
		out.println("Sender Information:"+session.getAttribute("sal"));
		out.println("<br>");
		out.println("Reciever Information:"+session.getAttribute("ral"));
		out.println("<br>");
		out.println("Amount you sended:"+session.getAttribute("al"));
	%>
</body>
</html>