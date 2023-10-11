<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Song</title>
</head>
<body>
    <h1>Update Song</h1>
    <form action="updateSong" method="post">
        <label for="songId">Song ID:</label>
        <input type="text" id="songId" name="songId"><br>
        
        <label for="newSongName">New Song Name:</label>
        <input type="text" id="newSongName" name="newSongName"><br>
        
        <input type="submit" value="Update Song">
    </form>
    <p><a href="index.html">Back to Home</a></p>
</body>
</html>