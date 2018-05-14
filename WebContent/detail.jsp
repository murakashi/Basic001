<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>結果</title>
</head>
<body>

<% ArrayList<String[]> list = (ArrayList<String[]>)session.getAttribute("list"); %>

<table border="1">
<tr>
<td>s_id</td>
<td>s_name</td>
<td>d_id</td>
</tr>
<% for(String[] arr : list){ %>
	<tr>
	<% for(String s : arr){ %>
		<td><%= s %></td>
	<% } %>
	</tr>
<% } %>
</table>

</body>
</html>