<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Song</title>
</head>
<body>
    <h1>Delete Song</h1>
    <form action="deleteSong" method="post">
        Song ID: <input type="text" name="songId"><br>
        <input type="submit" value="Delete Song">
    </form>
    <p><a href="index.html">Back to Home</a></p>
</body>
</html>