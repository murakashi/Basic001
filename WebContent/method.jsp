<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MethodServletの入力</title>
</head>
<body>

	<H2>MethodServletの入力</H2>

	<a href="Method?message=hello">リンクで送信</a>

	<form action="Method" method="get">
		<input type="text" name="message">
		<input type="submit" value="フォームでGET送信">
	</form>

	<form action="Method" method="post">
		<input type="text" name="message">
		<input type="submit" value="フォームでPOST送信">
	</form>

</body>
</html>