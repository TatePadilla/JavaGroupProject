<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Album</title>
</head>
<body>
    <h1>Add an Album</h1>
    <form action="AddAlbumServlet" method="post">
        <label for="albumName">Album Name:</label>
        <input type="text" id="albumName" name="albumName" required><br><br>
        
        <label for="bandName">Band Name:</label>
        <input type="text" id="bandName" name="bandName" required><br><br>
        
        <input type="submit" value="Add Album">
        <p><a href="index.html">Back to Home</a></p>
    </form>
</body>
</html>