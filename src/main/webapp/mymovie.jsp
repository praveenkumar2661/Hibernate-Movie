<%@page import="DTO.UserMovieDTO"%>
<%@page import="java.util.*"%>
<%@page import="DTO.UserDTO"%>
<%@page import="DAO.UserDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Movies</title>
</head>
<body>
<h3>My Movies</h3>
	<%UserDAO udao = new UserDAO(); %>
	<%UserDTO udto = udao.findByMail((String) session.getAttribute("umail")); %>
	   <div>
        <table>
            <thead>
                <th>Name</th>
                <th>Image</th>
                <th>Genre</th>
                <th>Language</th>
                <th>Rating</th>
                <th>Price</th>
                <th>Delete</th>
              
            </thead>
           <%int sum = 0; %>
            <%List<UserMovieDTO> movies = udto.getUser_movie(); %>
            <%for(UserMovieDTO movie:movies)
            	{ %>
            	<tr>
            		<td><%= movie.getUmovie_name() %></td>
            		<% String base64Image = Base64.getEncoder().encodeToString(movie.getUmovie_image()); %>
            		<td><img src = "data:image/jpeg;base64,<%= base64Image %>" alt = "Image" style = "height 144px; width: 240px;"/></td>
            		<td><%= movie.getUmovie_genre() %></td>
            		<td><%= movie.getUmovie_language() %></td>
            		<td><%= movie.getUmovie_rating() %></td>
            		<td><%= movie.getUmovie_price() %></td>
            		<td><button onclick= "window.location.href = 'deleteum?movieID=<%= movie.getId()%>'">Delete</button></td>
            		<% sum+=movie.getUmovie_price(); %>
            	</tr>
            		
            	<%}%>       	
        </table>
   </div>
   <br>
   <br>
  Total Outlay:<b> <%= sum %> </b> 
</body>
</html>