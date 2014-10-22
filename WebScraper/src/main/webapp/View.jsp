<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action = "search" method = "POST">

<table style="width: 384px">
<tr style="width: 720px; ">
<td>
Sites to search
   <p><input type="url" placeholder="site" name="site" required autofocus></p>
</td>
<td>
words to search
   <p><input type="text" placeholder="word" name="word" required autofocus></p>
</td>
<td>
<input type="submit" value="Submit">
</td>
</tr>

</table>

</form>

Results:<br>

parameter1 : ${parameter1} <br>
parameter2 : ${parameter2} <br>



</body>
</html>