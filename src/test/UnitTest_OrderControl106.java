package test;

import java.util.ArrayList;

import dao.CustomerControlDBAccess;
import model.Customer;

public class UnitTest_OrderControl106 {

	public static void main(String[] args) throws Exception {
		// TODO 自動生成されたメソッド・スタブ

		ArrayList<Customer> list = null;
		CustomerControlDBAccess dao = new CustomerControlDBAccess();

		// 項番1(正常系)、5(異常系)
		list = dao.searchCustomerByTel("08012345678");
		System.out.println("項番1、5:searchCustomerByTel(\"08012345678\"):要素数 : = " + list.size());

		for(int i=0; i<list.size(); i++) {
			Customer customer = list.get(i);
			System.out.println("       " + customer.getCustId() + " " + customer.getCustName() + " " + customer.getKana());
		}

		// 項番2(異常系)
		list = dao.searchCustomerByTel("0120345678");
		System.out.println("項番2:searchCustomerByTel(\"0120345678\") : 要素数 : = " + list.size());

		for(int i=0; i<list.size(); i++) {
			Customer customer = list.get(i);
			System.out.println("      " + customer.getCustId() + " " + customer.getCustName() + " " + customer.getKana());
		}

		// 項番3(異常系)
		list = dao.searchCustomerByTel("");
		System.out.println("項番3:searchCustomerByTel(\"\") : 要素数 : = " + list.size());

		for(int i=0; i<list.size(); i++) {
			Customer customer = list.get(i);
			System.out.println("      " + customer.getCustId() + " " + customer.getCustName() + " " + customer.getKana());
		}

		// 項番4(異常系)
		list = dao.searchCustomerByTel(null);
		System.out.println("項番4:searchCustomerByTel(null) : 要素数 : = " + list.size());

		for(int i=0; i<list.size(); i++) {
			Customer customer = list.get(i);
			System.out.println("      " + customer.getCustId() + " " + customer.getCustName() + " " + customer.getKana());
		}

		// 項番6(正常系)、10(異常系)
		list = dao.searchCustomerByKana("シバタリュウイチ");
		System.out.println("項番6、10:searchCustomerByKana(\"シバタリュウイチ\") : 要素数 : = " + list.size());

		for(int i=0; i<list.size(); i++) {
			Customer customer = list.get(i);
			System.out.println("      " + customer.getCustId() + " " + customer.getCustName() + " " + customer.getKana());
		}

		// 項番7(異常系)

		list = dao.searchCustomerByKana("キタジマコウスケ");
		System.out.println("項番7:searchCustomerByKana(\"キタジマコウスケ\") : 要素数 : = " + list.size());

		for(int i=0; i<list.size(); i++) {
			Customer customer = list.get(i);
			System.out.println("      " + customer.getCustId() + " " + customer.getCustName() + " " + customer.getKana());
		}

		// 項番8(異常系)

		list = dao.searchCustomerByKana("");
		System.out.println("項番8:searchCustomerByKana(\"\") : 要素数 : = " + list.size());

		for(int i=0; i<list.size(); i++) {
			Customer customer = list.get(i);
			System.out.println("      " + customer.getCustId() + " " + customer.getCustName() + " " + customer.getKana());
		}

		// 項番9(異常系)

		list = dao.searchCustomerByKana("null");
		System.out.println("項番9:searchCustomerByKana(\"null\") : 要素数 : = " + list.size());

		for(int i=0; i<list.size(); i++) {
			Customer customer = list.get(i);
			System.out.println("      " + customer.getCustId() + " " + customer.getCustName() + " " + customer.getKana());
		}

	}

}
