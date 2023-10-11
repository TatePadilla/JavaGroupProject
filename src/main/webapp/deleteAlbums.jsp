<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Album</title>
</head>
<body>
    <h1>Delete Album</h1>
    
    <form action="DeleteAlbumServlet" method="get">
        <label for="albumId">Enter Album ID:</label>
        <input type="text" id="albumId" name="id">
        <input type="submit" value="Delete">
    </form>
    
    <p><a href="index.html">Back</a></p>
</body>
</html>