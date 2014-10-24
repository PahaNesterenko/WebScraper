<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Web scraper</title>
</head>
<body style="background-color: lightgrey">
	<h1 style="color: blue; text-align: center">Web scraper</h1>
	<form action="search" method="POST">
		<table style="padding:5px">
			<tr>
				<td>Sites to search
					<p>
						<input type="url" placeholder="site" name="site" required
							autofocus>
					</p>
				</td>
				<td>words to search
					<p>
						<input type="text" placeholder="word" name="word" required
							autofocus>
					</p>
				</td>
				<td><input type="checkbox" checked name="time" value="true">time
					spend on data scraping and data processing<Br> <input
					type="checkbox" checked name="countWords" value="true">count
					number of provided word(s) occurrence on webpage(s)<Br> <input
					type="checkbox" checked name="countChars" value="true">count
					number of characters of each web page<Br> <input
					type="checkbox" checked name="sentences" value="true">extract
					sentences which contain given words<Br> <input type="submit"
					value="Submit"><br>
			</tr>
		</table>
	</form>

	Results:
	<%@ page import="java.util.List"%>
	<%@ page import="java.util.ArrayList"%>
	<%
		List<List<String>> totalResults = (List<List<String>>) request.getAttribute("results");
		if (totalResults != null) {
			for (int i = 0; i < totalResults.size(); ++i) {
				List<String> result = totalResults.get(i);
	%>

	<p><%= result.get(0) %></p>
	<% for( int k = 1 ; k < result.size(); ++k){ %>
	<%= result.get(k) %><br>
	<%} %>

	<%
}
}
 %>



</body>
</html>