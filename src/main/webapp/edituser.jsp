<%@page import="DTO.UserDTO"%>
<%@page import="DAO.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit User</title>
</head>
<body>
	<h3>Edit your details!!!</h3>
	<% UserDAO udao = new UserDAO(); %>
	<% UserDTO udto = udao.findByMail((String) session.getAttribute("umail")); %>			
	<form action = "editUser" method = "post">
    <table>
        <tr>
            <td>Mail Id</td>
            <td><input type="text" name="mail" value="<%= udto.getUser_mail()%>" readonly></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="<%= udto.getUser_name()%>"></td>
        </tr>
        <tr>
            <td>Contact</td>
            <td><input type="number" name="contact" value="<%= udto.getUser_contact() %>"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" value="<%= udto.getUser_password() %>"></td>
        </tr>
        <tr>
            <td>Confirm Password</td>
            <td><input type="password" name="cpassword" value="<%=udto.getUser_confirm_password() %>"></td>
        </tr>
        <tr></tr>
        <tr><td><button onclick= "window.location.href = 'editadmin.java';">Submit</button></td></tr>
    </table>
    <% String message = (String)request.getAttribute("pass"); %>
	<% if(message!=null){ %>
	<b><%= message %></b>
<% }%></div>
</form>
</body>
</html>