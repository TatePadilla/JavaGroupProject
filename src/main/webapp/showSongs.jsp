<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		<u>List of all songs: </u>
	</h1>
	<table>
		<c:forEach items="${requestScope.allSongs}" var="currentsong">
			<tr>
				<td>Song Title: ${currentsong.songName} |
					<p>__________________________</p>
				</td>
				
			</tr>
		</c:forEach>
	</table>
	<br />
	<a href="index.html">Home</a>
</body>
</html>