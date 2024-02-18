<%@page import="DTO.UserMovieDTO"%>
<%@page import="DTO.UserDTO"%>
<%@page import="DAO.UserDAO"%>
<%@page import="DTO.MovieDTO"%>
<%@page import="java.util.*"%>
<%@page import="DAO.MovieDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Buy Movie</title>
</head>
<body>
<h3>Purchase Details</h3>
		<%MovieDAO mdao = new MovieDAO(); %>
		<%MovieDTO mdto = mdao.findByID(Integer.parseInt((String)session.getAttribute("movieID"))); %>

		 <form action="buyMovie" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="<%= mdto.getMovie_name()%>" readonly></td>
            </tr>
            <tr>
                <td>Genre</td>
                <td><input type="text" name="genre" value="<%= mdto.getMovie_genre()%>" readonly></td>
            </tr>
            <tr>
                <td>Language</td>
                <td><input type="text" name="lang" value="<%= mdto.getMovie_language()%>" readonly></td>
            </tr>
            <tr>
                <td>Rating</td>
              	 <td><input type="number" name="rating" value="<%= mdto.getMovie_rating()%>" readonly></td>
             </tr>
            <tr>
                <td>Price</td>
                <td><input type="number" name="price" value="<%= mdto.getMovie_price()%>" readonly step = "0.01"></td>
            </tr>
            <tr>
                <td>Image</td>
               
                <% String base64Image = Base64.getEncoder().encodeToString(mdto.getMovie_image()); %>
				<td class = "img"><img src = "data:image/jpeg;base64,<%= base64Image%>" alt = "Image" style = "height: 144px; width: 240px;">
				<td><input type = "" name = "image" value = "<%= base64Image%>" readonly style = "display:none;"></td>
            </tr>
            <tr>
            	<td>Enter the amount</td>
            	<td><input type = "number" name = "useramount" placeholder = "<%=mdto.getMovie_price() %>">
            </tr>
       
            <tr>
                <td><button>Buy</button><br><br></td>
            </tr>
        </table>
       
    </form>
</body>
</html>