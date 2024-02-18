<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Sign In</title>
</head>
<body>
<h3>User Sign In</h3>
<form action="usignup" method="post">
        <table>
            <tbody>
                <tr>
                    <td>Name</td>
                    <td>:</td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>Contact</td>
                    <td>:</td>
                    <td><input type="number" name="num"></td>
                </tr>
                <tr>
                    <td>Mail ID</td>
                    <td>:</td>
                    <td><input type="email" name = "mail"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>:</td>
                    <td><input type="password" name="pass"></td>
                </tr>
                <tr>
                    <td>Confirm Password</td>
                    <td>:</td>
                    <td><input type="password" name="cpass"></td>
                </tr>
                <tr>
                    <td><button type="submit">Sign Up</button></td>
                </tr>
            </tbody>
        </table>
    </form>
      <% String message = (String)request.getAttribute("message"); %>
	<% if(message!=null){ %>
	<b><%= message %></b>
	<% }%>
</body>
</html>