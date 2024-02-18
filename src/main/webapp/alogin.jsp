<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
</head>
<body>
<h3>Admin Login</h3>
 <form action="alogin" method="post">
        <table>
            <tr>
                <td>Mail ID</td>
                <td>:</td>
                <td><input type="email" name="mail"></td>
            </tr>
            <tr>
                <td>Password</td>
                <td>:</td>
                <td><input type="password" name="pass"></td>
            </tr>
            <tr>
                <td><button type="submit">Login</button></td>
            </tr>
        </table>
    </form>
    <% String message = (String)request.getAttribute("message"); %>
	<% if(message!=null){ %>
	<b><%= message %></b>
	<% }%>
</body>
</html>