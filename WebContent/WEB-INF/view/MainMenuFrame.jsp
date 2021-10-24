<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[メインメニュー] KIDDA-LA業務管理システム</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<header>
	<h1>[メインメニュー]:KIDDA-LA業務管理システム</h1>
</header>
<div align="center">
	<br><br><br>
	<form action="FrontController" method="post">
		<button name="command" value="OrderControl">
			01:注文管理
		</button>
	</form>
	<br><br><br>
</div>
<footer>
 <div>
 	<p>2021(c) Kidda-La</p>
 </div>
</footer>

</body>
</html>