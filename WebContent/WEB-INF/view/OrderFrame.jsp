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
    <title>[注文/配達確認/顧客情報変更]　KIDDA-LA業務管理システム</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script>
        function autoCalc() {
            //同じnameの項目を配列として取得する
            var price = document.getElementsByName("price");
            var quantity = document.getElementsByName("quantity");
            var amount = document.getElementsByName("amount");

            //IDを指定して単一データとして取得する
            var subtotal = document.getElementById("subtotal");
            var taxtotal = document.getElementById("taxtotal");
            var payamount = document.getElementById("payamount");

            var calc_subtotal = 0;
            var calc_taxtotal = 0.0;
            var calc_payamount = 0;

            for (let i = 0; i < price.length; i++) {
                if (quantity[i].value !== "") {
                    amount[i].value = price[i].value * quantity[i].value;
                    calc_subtotal += Number(amount[i].value);
                    console.log("no = "+(i+1)+"金額 = "+price[i].value+" * "+quantity[i].avlue+" = "+amount[i].value);
                }
            }
            console.log(subtotal+""+taxtotal+""+payamount);
            calc_taxtotal = calc_subtotal * 0.08;
            calc_payamount = calc_subtotal + Math.floor(calc_taxtotal);

            subtotal.value = calc_subtotal;
            taxtotal.value = Math.floor(calc_taxtotal);
            payamount.value = calc_payamount;

            console.log("小計		= "+calc_subtotal);
            console.log("消費税		= "+calc_taxtotal);
            console.log("支払金額		= "+calc_payamount);
        }
    </script>
</head>
<body>
    <header>
        <h1>[注文/配達確認/顧客情報変更]：Kidda-La 業務管理システム</h1>
    </header>
    <section>
        <div align="center">
            <br><br>
            <h2>
                顧客情報
            </h2>
            <table border="1">
                <tr>
                    <td><label>顧客ID</label></td>
                    <td><%= customer.getCustId() %></td>
                    <td rowspan="5" align="center">
                        <form action="FrontController" method="POST">
                            <input type="hidden" value="<%= customer.getCustId() %>">
                            <input type="hidden" value="<%= customer.getCustName() %>">
                            <input type="hidden" value="<%= customer.getKana() %>">
                            <input type="hidden" value="<%= customer.getTel() %>">
                            <input type="hidden" value="<%= customer.getAddress() %>">
                            <button type="submit" name="command" value="CustomerEdit">
                                顧客情報の編集
                            </button>
                        </form>
                    </td>
                </tr>
                <tr>
                    <td><label>顧客名</label></td>
                    <td><%= customer.getCustName() %></td>
                </tr>
                <tr>
                    <td><label>カナ</label></td>
                    <td><%= customer.getKana() %></td>
                </tr>
                <tr>
                    <td><label>電話番号</label></td>
                    <td><%= customer.getTel() %></td>
                </tr>
                <tr>
                    <td><label>住所</label></td>
                    <td><%= customer.getAddress() %></td>
                </tr>
            </table>
        </div>
        <div align="center">
            <br><br>
            <h2>
                注文受付
            </h2>
            <table border="1">
                <tr><th>No</th><th>商品ID</th><th>商品名</th><th>サイズ</th><th>価格</th><th>個数</th><th>金額</th></tr>
                <% if(itemList != null) { %>
                    <form name="OrderForm" action="" method="POST">
                        <% int i=0; %>
                        <% for(Item lst:itemList) { %>
                            <tr>
                                <td><%= i+1 %></td>
                                <td>
                                    <%= lst.getitemId() %>
                                    <input type="hidden" name="f_itemid" value="<%= lst.getitemId() %>">
                                </td>
                                <td><%= lst.getitemName() %></td>
                                <td align="center"><%= lst.getsize() %></td>
                                <td align="right">
                                    <%= lst.getprice() %>
                                    <input type="hidden" name="price" value="<%= lst.getprice() %>" disable>
                                </td>
                                <td align="right">
                                    <input type="text" size="5" name="quantity" onchange="autoCalc()" style="text-align: right">個
                                </td>
                                <td align="right">
                                    <input type="text" size="5" name="amount" style="text-align: right">円
                                </td>
                            </tr>
                            <% i++; %>
                        <% } %>
                        <tr>
                            <td colspan="6" align="right">小計</td>
                            <td align="right"><input type="text" id="subtotal" size="5" style="text-align: right;">円
                            </td>
                        </tr>

                        <tr>
                            <td colspan="6" align="right">消費税</td>
                            <td align="right">
                                <input type="text" id="taxtotal" size="5" style="text-align: right">円
                            </td>
                        </tr>

                        <tr>
                            <td colspan="6" align="right">合計金額</td>
                            <td align="right">
                                <input type="text" id="payamount" size="5" style="text-align: right">円</td>
                        </tr>

                        <tr>
                            <td colspan="7" align="center"><button type="submit">注文完了</button></td>
                        </tr>
                    </form>
                <% } %>
            </table>
        </div>
    </section>
    <footer>
        <div>
            <p>
                2021（c）Kidda-La
            </p>
        </div>
    </footer>
</body>
</html>