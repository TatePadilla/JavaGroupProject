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
				 <td> Band Name: ${currentalbum.bandName} </td>
				
			</tr>
			
			<tr>
				<td>Album Name: ${currentalbum.albumName} </td>
			</tr>
			
			<c:forEach items="${currentalbum.song}" var="currentsong">
			
					<td>Song Name: ${currentsong.songName} <p>__________________</p></td>
					
			</c:forEach>
		</c:forEach>
		
	</table>
	
	<br />
	<a href="index.html"><button>Home</button></a>

</body>
</html>