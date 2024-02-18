<%@page import="DAO.UserDAO"%>
<%@page import="DTO.UserDTO"%>
<%@page import="DTO.MovieDTO"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "DAO.MovieDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Welcome</title>
</head>
<body>
	<%MovieDAO mdao = new MovieDAO(); %>
	<%UserDAO udao = new UserDAO();%>
	<%UserDTO udto = udao.findByMail((String)session.getAttribute("umail")); %>
	<h3>Welcome, <%= udto.getUser_name() %></h3>
	<button class = "btn1" onclick= "window.location.href = 'mymovie.jsp';">My Movies</button><br><br>
	<button class = "btn1" onclick= "window.location.href = 'edituser.jsp';">Edit User Details</button><br><br>
	<% String message = (String)request.getAttribute("message"); %>
	<% if(message!=null){ %>
	<%= message %>
	<% }%>
	 <table>
            <thead>
                <th>Name</th>
                <th>Image</th>
                <th>Genre</th>
                <th>Language</th>
                <th>Rating</th>
                <th>Price</th>
                <th>Buy</th>
                </thead>
           
            <%List<MovieDTO> movies = mdao.findAll(); %>
            <%for(MovieDTO movie: movies)
            	{ %>
            	<tr>
            		<td><%= movie.getMovie_name() %></td>
            		<% String base64Image = Base64.getEncoder().encodeToString(movie.getMovie_image()); %>
            		<td><img src = "data:image/jpeg;base64,<%= base64Image %>" alt = "Image" style = "height 144px; width: 240px;"/></td>
            		<td><%= movie.getMovie_genre() %></td>
            		<td><%= movie.getMovie_language() %></td>
            		<td><%= movie.getMovie_rating() %></td>
            		
            		<td><%= movie.getMovie_price() %></td>
            		<td><button onclick= "window.location.href = 'checkMovie?movieID=<%= movie.getId()%>'">Buy</button></td>
            		
            	</tr>
            		
            	<%}%>       	
        </table>
        <br><br>
        <button>Logout</button>
</body>
</html>