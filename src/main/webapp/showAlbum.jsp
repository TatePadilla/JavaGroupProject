<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Album's and Songs</title>
</head>
<body>
	<h1><u>List of all Songs and Albums: </u></h1>
	<table>
		<c:forEach items="${requestScope.allAlbums}" var="currentalbum">
			<tr>
				<td>${currentalbum.albumName} | </td>
				<td>${currentalbum.bandName}</td>
			</tr>
			<c:forEach items="${currentalbum.song}" var="currentsong">
					
				</c:forEach>
		</c:forEach>
		
	</table>
	
	<br />
	<a href="index.html">Home</a>

</body>
</html>