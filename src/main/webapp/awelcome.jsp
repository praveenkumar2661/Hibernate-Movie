<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "java.util.*" %>
    <%@ page import = "DAO.AdminDAO" %>
    <%@ page import = "DTO.MovieDTO" %>
    <%@ page import = "DTO.AdminDTO" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Welcome</title>
</head>
<body>
	<%String mail = (String)session.getAttribute("mail"); %>
	<%AdminDAO adao = new AdminDAO(); %>
	<%AdminDTO adto = adao.findByMail((String) session.getAttribute("mail")); %>
	<%String name = adto.getAdmin_name(); %>
	<h3>Welcome, <%= name %>!!! </h3><br>
	<button onclick= "window.location.href = 'addmovie.jsp';">Add Movie</button><br><br>
	<button onclick= "window.location.href = 'editadmin.jsp';">Edit Admin Details</button><br><br>
	
	
	
	   <div>
        <table>
            <thead>
                <th>Name</th>
                <th>Image</th>
                <th>Genre</th>
                <th>Language</th>
                <th>Rating</th>
                <th>Price</th>
                <th>Edit</th>
                <th>Delete</th>
            </thead>
           
            <%List<MovieDTO> movies = adto.getMovie(); %>
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
            		<td><button onclick= "window.location.href = 'editMovie.jsp?movieID=<%= movie.getId()%>'">Edit</button></td>
					<td><button onclick= "window.location.href = 'deleteam?movieID=<%= movie.getId()%>'">Delete</button></td>
            	</tr>
            		
            	<%}%>       	
        </table>
   </div>
   <br>
   <br>
   <button>Logout</button>
</body>
</html>