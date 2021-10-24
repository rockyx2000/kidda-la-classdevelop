<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Customer, model.Item, java.util.ArrayList" %>
<%
    Customer customer = (Customer) session.getAttribute("customer");
    ArrayList<Item> itemList = (ArrayList<Item>) session.getAttribute("itemList");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>[顧客情報変更] KIDDA-LA業務管理システム</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script>

    </script>
</head>
<body>

    <header>
        <h1>
            [顧客情報変更]：Kidda-La業務管理システム
        </h1>
    </header>
    <section>
        <div align="center">
            <br><br>
            <h2>
                顧客情報
            </h2>
            <form action="FrontController" method="POST">
                <table border="1">
                    <tr>
                        <td>
                            <label>顧客ID</label>
                        </td>
                        <td>
                            <input type="text" name="s_custId" value="<%= customer.getCustId() %>" readonly>
                            (変更不可)
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>顧客名</label>
                        </td>
                        <td>
                            <input type="text" name="s_name" value="<%= customer.getCustName() %>" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>カナ</label>
                        </td>
                        <td>
                            <input type="text" name="s_kana" value="<%= customer.getKana() %>" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>電話番号</label>
                        </td>
                        <td>
                            <input type="text" name="s_tel" value="<%= customer.getTel() %>" >
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label>住所</label>
                        </td>
                        <td>
                            <input type="text" size="50" name="s_address" value="<%= customer.getAddress() %>" >
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <button type="submit" name="command" value="CustomerUpdate">変更確認</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </section>
    <div class="go-home">
		<a href="FrontController">戻る</a>
	</div>

    <footer>
        <div>
            <p>
                2021（c）Kidda-La
            </p>
        </div>
    </footer>
</body>
</html>