<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="model.Customer, java.util.ArrayList" %>
<%
	ArrayList<Customer> list = (ArrayList<Customer>) session.getAttribute("customerList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>[顧客情報検索]:Kidda-La 業務管理システム</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script>
	function orderPageForward(custid){
		let tmpForm = document.forms.selectCustForm;
		tmpForm.s_custId.value = custid;
		alert('cust id = ' + tmpForm.s_custId.value + "command = " + tmpForm.command.value);
		tmpForm.method = "POST";
		tmpForm.submit();
	}
</script>
</head>
<body>
	<header>
		<h1>[顧客情報検索]:Kidda-La 業務管理システム</h1>
	</header>
	<section>
		<div align="center">
			<br><br>
			<h2>顧客情報検索フォーム</h2>
			<form action="FrontController" method="post">
				<table border="1">
				 <tr>
				 	<td><label>電話番号（ハイフンなし）</label></td>
				 	<td><input type="text" name="s_tel" size="50"><br>例:09012345678</td>
				 </tr>

				 <tr>
				 	<td><label>氏名（全角カタカナ）</label></td>
				 	<td><input type="text" name="s_kana" size="50"><br>例:キダタロウ</td>
				 </tr>

				 <tr>
				 	<td><button type="submit" name="command" value="CustomerSearch">送信</button>
				 			<button type="reset">入力消去</button></td>

				 </tr>

				</table>
			</form>
		</div>

		<div align="center">
			<br><br>
			<h2>顧客情報検索結果</h2>
			<form name="selectCustForm" action="FrontController" method="post">
				<input type="hidden" name="s_tel" value="">
				<input type="hidden" name="s_kana" value="">
				<input type="hidden" name="s_custId" value="">
				<input type="hidden" name="command" value="OrderFrame">
			</form>
			<table border="1">
				<tr><th>ID</th><th>氏名</th><th>カナ</th><th>TEL</th><th>住所</th></tr>
				<% if(list != null) { %>
					<% for(Customer lst : list) { %>

						<tr onclick="orderPageForward(<%= lst.getCustId() %>)">
							<td><%= lst.getCustId()  %></td>
							<td><%= lst.getCustName()  %></td>
							<td><%= lst.getKana()  %></td>
							<td><%= lst.getTel()  %></td>
							<td><%= lst.getAddress()  %></td>
						</tr>
					<%} %>
				<% } %>
			</table>
		</div>
	</section>

	<div class="go-home">
		<a href="FrontController">戻る</a>
	</div>

	<footer>
		<div>
			<p>2021(c) Kidda-La</p>
		</div>
	</footer>

</body>
</html>