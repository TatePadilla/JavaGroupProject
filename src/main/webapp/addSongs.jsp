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
        <label for="songName">Song Name:</label>
        <input type="text" id="songName" name="songName">
        <br>
        
        <label for="songCreatedDate">Song Created Date:</label>
        <input type="text" id="songCreatedDate" name="songCreatedDate">
        <br>
        
        <label for="albumId">Album ID:</label>
        <input type="text" id="albumId" name="albumId">
        <br>
        <input type="submit" value="Add Song">
    </form>
    
    <div class="error-message">
        <c:if test="${not empty error}">
            ${error}
        </c:if>
    </div>
    
    <p><a href="index.html">Back</a></p>
</body>
</html>