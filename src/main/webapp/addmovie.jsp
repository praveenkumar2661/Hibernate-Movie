<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin AddMovie</title>
</head>
<body>
<h3>Add Movie</h3>
	<form action="addmovie" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td>Genre</td>
            <td><input type="text" name="genre"></td>
        </tr>
        <tr>
            <td>Language</td>
            <td><input type="text" name="lang"></td>
        </tr>
        <tr>
            <td>Rating</td>
            <td><input type="number" name="rating" step = "0.01"></td>
        </tr>
       
        <tr>
            <td>Price</td>
            <td><input type="number" name="price" step = "0.01"></td>
        </tr>
        <tr>
            <td>Image</td>
            <td><input type="file" name = "image"></td>
        </tr>
    </table>
    <button type = "submit">Add Product</button>
</form>
</body>
</html>