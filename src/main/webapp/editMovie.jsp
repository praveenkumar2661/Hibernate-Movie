<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import = "DAO.MovieDAO" %>
    <%@ page import = "DTO.MovieDTO" %>
    <%@ page import = "java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Movie</title>
</head>
<body>
	<h3>Edit Movie Details</h3>
	<%MovieDAO mdao = new MovieDAO(); %>
	<%MovieDTO mdto = mdao.findByID(Integer.parseInt(request.getParameter("movieID"))); %>
	<%session.setAttribute("movieID", request.getParameter("movieID")); %>
	 <form action="editMovieDetails" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="<%= mdto.getMovie_name()%>"></td>
            </tr>
            <tr>
                <td>Genre</td>
                <td><input type="text" name="genre" value="<%= mdto.getMovie_genre()%>"></td>
            </tr>
            <tr>
                <td>Language</td>
                <td><input type="text" name="lang" value="<%= mdto.getMovie_language()%>"></td>
            </tr>
            <tr>
                <td>Rating</td>
              	 <td><input type="number" name="rating" value="<%= mdto.getMovie_rating()%>" step = "0.01"></td>
             </tr>
            <tr>
                <td>Price</td>
                <td><input type="number" name="price" value="<%= mdto.getMovie_price()%>" step = "0.01"></td>
            </tr>
            <tr>
                <td>Image</td>
               
                <% String base64Image = Base64.getEncoder().encodeToString(mdto.getMovie_image()); %>
				<td class = "img"><img src = "data:image/jpeg;base64,<%= base64Image%>" alt = "Image" style = "height: 144px; width: 240px;">
				<td><input type = "file" name = "img" value = ""></td>
            </tr>
            <tr>
                <td><button>Save Changes</button><br><br></td>
            </tr>
        </table>
    </form>
</body>
</html>