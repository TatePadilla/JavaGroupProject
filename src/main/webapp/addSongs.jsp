<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add Song</title>
</head>
<body>
    <h1>Add Song</h1>
    <form action="addSong" method="post">
        Song Name: <input type="text" name="songName"><br>
        Album Name: <input type="text" name="albumName"><br>
        Band Name: <input type="text" name="bandName"><br>
        <input type="submit" value="Add Song">
    </form>
    <p><a href="index.html">Back to Home</a></p>
</body>
</html>