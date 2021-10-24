package test;

import java.util.ArrayList;

import dao.OrderDetailControlDBAccess;
import model.OrderDetail;

public class viewOrderDetailTable {

    public static void main(String[] args) throws Exception {
        OrderDetailControlDBAccess dao = new OrderDetailControlDBAccess();

        // 顧客IDで、DAOから注文詳細リストを取得する
        ArrayList<OrderDetail> list_custid = dao.searchOrderDetailByCustId(197);
        System.out.println("CUSTID = 197 の検索結果");
        System.out.println("No custId itemid orderdate  quantity taxid status ");
        for(OrderDetail bean : list_custid) {
            System.out.printf("%2d %4d %7s %11s %4d %7d %5d\n",
                    bean.getNo(),bean.getCustId(), bean.getItemId(), bean.getOrderDate(),
                    bean.getQuantity(), bean.getTaxId(), bean.getStatus());
            System.out.println();
        }

        // 注文詳細情報の全件リストを取得する
        ArrayList<OrderDetail> list_all = dao.findAll();
        System.out.println("注文詳細情報の全件リストの検索結果");
        System.out.println("No custId itemid orderdate  quantity taxid status ");
        for(OrderDetail bean : list_all) {
            System.out.printf("%2d %4d %7s %11s %4d %7d %5d\n",
                    bean.getNo(),bean.getCustId(), bean.getItemId(), bean.getOrderDate(),
                    bean.getQuantity(), bean.getTaxId(), bean.getStatus());
            System.out.println();
        }
    }
}