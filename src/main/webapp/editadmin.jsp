<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "DAO.AdminDAO" %>
<%@ page import = "DTO.AdminDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Admin Details</title>
</head>
<body>
	<% String mail = (String) session.getAttribute("mail");%>
	
	<% AdminDAO adao = new AdminDAO(); %>
	<% AdminDTO adto = adao.findByMail(mail); %>	
	<h3>Edit your details!!!</h3>		
	<form action = "editAdmin" method = "post">
    <table>
        <tr>
            <td>Mail Id</td>
            <td><input type="text" name="mail" value="<%= adto.getAdmin_mail()%>" readonly></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" value="<%= adto.getAdmin_name()%>"></td>
        </tr>
        <tr>
            <td>Contact</td>
            <td><input type="number" name="contact" value="<%= adto.getAdmin_contact() %>"></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" value="<%= adto.getAdmin_password() %>"></td>
        </tr>
        <tr>
            <td>Confirm Password</td>
            <td><input type="password" name="cpassword" value="<%=adto.getAdmin_confirm_password() %>"></td>
        </tr>
        <tr></tr>
        <tr><td><button onclick= "window.location.href = 'editadmin.java';">Submit</button></td></tr>
    </table>
    <% String message = (String)request.getAttribute("pass"); %>
	<% if(message!=null){ %>
	<%= message %>
<% }%></div>
</form>
<br>
<br>

</body>
</html>