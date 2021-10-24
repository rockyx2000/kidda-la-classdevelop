package test;

import java.util.ArrayList;

import dao.CustomerControlDBAccess;
import model.Customer;


public class viewCustomerTable {

	public static void main(String[] args) throws Exception{
		//TODO 自動生成されたメソッドスタブ
		//DAOを生成する
		CustomerControlDBAccess dao = new CustomerControlDBAccess();

		//TELでDAOから顧客リストを取得する
		ArrayList<Customer> list_tel = dao.searchCustomerByTel("09056781234");
		System.out.println("TEL=0905681234の検索結果");
		System.out.println("顧客ID\t氏名\t\t\tカナ\t\t\t\tTEL\t\t\t住所");
		for(Customer bean : list_tel) {
			System.out.println(bean.getCustId() + "\t\t" +
						bean.getCustName() + "\t\t" +
					    bean.getKana() + "\t\t" +
						bean.getTel() + "\t\t" +
					    bean.getAddress());
		}
		System.out.println();

		//カナで、DAOから顧客リストを取得する
		ArrayList<Customer> list_kana = dao.searchCustomerByKana("イトウハナエ");
		System.out.println("KANA=イトウハナエでの検索結果");
		System.out.println("顧客ID\t氏名\t\t\tカナ\t\t\t\tTEL\t\t\t住所");

		for(Customer bean : list_kana) {
			System.out.println(bean.getCustId() + "\t\t" +
							   bean.getCustName() + "\t\t" +
							   bean.getKana() + "\t\t" +
							   bean.getTel() + "\t\t" +
							   bean.getAddress());
		}
		System.out.println();

		//電話番号で、DAOから顧客リストを取得する
		Customer customer = dao.searchCustomerById(209);
		System.out.println("CUSTID=209での検索結果");
		System.out.println("顧客ID\t氏名\t\t\tカナ\t\t\t\tTEL\t\t\t住所");
		System.out.println(customer.getCustId() + "\t\t" +
						   customer.getCustName() + "\t\t" +
						   customer.getKana() + "\t\t" +
						   customer.getTel() + "\t\t" +
						   customer.getAddress());
		System.out.println();


		//全件検索
		ArrayList<Customer> findAll = dao.findAll();
		System.out.println("全件検索");
		System.out.println("顧客ID\t氏名\t\t\tカナ\t\t\t\tTEL\t\t\t住所");

		for(Customer bean : findAll) {
			System.out.println(bean.getCustId() + "\t\t" +
							   bean.getCustName() + "\t\t" +
							   bean.getKana() + "\t\t" +
							   bean.getTel() + "\t\t" +
							   bean.getAddress());
		}
		System.out.println();


	}


}
