package test;

import java.util.ArrayList;

import dao.ItemControlDBAccess;
import model.Item;

public class viewItemTable {
	public static void main(String[] args) throws Exception{
		//TODO 自動生成されたメソッドスタブ
		//DAOを生成する
		ItemControlDBAccess dao = new ItemControlDBAccess();

		//商品名にチキンが含まれる商品を検索
		ArrayList<Item> list_name = dao.searchItemByName("チキン");
		System.out.println("NAME=チキンの検索結果");
		System.out.println("商品ID\t商品名\t\t\tサイズ\t\t\t\t価格");
		for(Item bean : list_name) {
			System.out.println(bean.getitemId() + "\t\t" +
						bean.getitemName() + "\t\t" +
					    bean.getsize() + "\t\t" +
					    bean.getprice());
		}
		System.out.println();

		//ハワイアンデライトの商品IDを検索
		ArrayList<Item> list_id = dao.searchItemById("P010");
		System.out.println("ITMEID=P010での検索結果");
		System.out.println("商品ID\t商品名\t\t\tサイズ\t\t\t\t価格");

		for(Item bean : list_id) {
			System.out.println(bean.getitemId() + "\t\t" +
							   bean.getitemName() + "\t\t" +
							   bean.getsize() + "\t\t" +
							   bean.getprice());
		}
		System.out.println();


		ArrayList<Item> all = dao.findAll();
		System.out.println("商品情報の全件リストの検索結果");
		for(Item bean : all) {
			System.out.println("商品ID\t商品名\t\t\tサイズ\t\t\t\t価格");
		System.out.println(bean.getitemId() + "\t\t" +
				   bean.getitemName() + "\t\t" +
				   bean.getsize() + "\t\t" +
				   bean.getprice());
}
		System.out.println();

	}

}
