<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Album</title>
</head>
<body>
    <h1>Update Album</h1>
    
    <form action="updateAlbum" method="post">
        <label for="albumId">Enter Album ID:</label>
        <input type="text" id="albumId" name="id">
        <br>
        <label for="albumName">New Album Name:</label>
        <input type="text" id="albumName" name="albumName">
        <br>
        <label for="bandName">New Band Name:</label>
        <input type="text" id="bandName" name="bandName">
        <br>
        <input type="submit" value="Update">
    </form>
    
    <p><a href="index.html">Back</a></p>
</body>
</html>