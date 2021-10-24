package test;

import model.Customer;

public class UnitTest_OrderControl101 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ

		// 項番1 デバッガにて途中で止めて、変数の値を確認する
		Customer cs1 = new Customer(1, "青木まゆみ", "アオキマユミ", "09012345678", "東京都千代田区神田小川町1-1-1");

		// 項番2 デバッガにて途中で止めて、変数の値を確認する
		Customer cs2 = new Customer(0, null, null, null, null);

		// 項番5 デバッガにて途中で止めて、変数の値を確認する
		System.out.println("cs1.getCustId() = " + cs1.getCustId());

		// 項番6 デバッガにて途中で止めて、変数の値を確認する
		System.out.println("cs2.getCustId() = " + cs2.getCustId());

		// 項番9 デバッガにて途中で止めて、変数の値を確認する
		System.out.println("cs1.getCustName() = " + cs1.getCustName());

		// 項番10 デバッガにて途中で止めて、変数の値を確認する
		System.out.println("cs2.getCustName() = " + cs2.getCustName());

		// 項番13 デバッガにて途中で止めて、変数の値を確認する
		System.out.println("cs1.getKana() = " + cs1.getKana());

		// 項番14 デバッガにて途中で止めて、変数の値を確認する
		System.out.println("cs2.getKana() = " + cs2.getKana());

		// 項番17 デバッガにて途中で止めて、変数の値を確認する
		System.out.println("cs1.getTel() = " + cs1.getTel());

		// 項番18 デバッガにて途中で止めて、変数の値を確認する
		System.out.println("cs2.getTel() = " + cs2.getTel());

		// 項番21 デバッガにて途中で止めて、変数の値を確認する
		System.out.println("cs1.getAddress() = " + cs1.getAddress());

		// 項番22 デバッガにて途中で止めて、変数の値を確認する
		System.out.println("cs2.getAddress() = " + cs2.getAddress());

		// 項番3 デバッガにて途中で止めて、変数の値を確認する
		cs1.setCustId(2);

		// 項番4 デバッガにて途中で止めて、変数の値を確認する
		cs1.setCustId(0);

		// 項番7 デバッガにて途中で止めて、変数の値を確認する
		cs1.setCustName("伊藤華英");

		// 項番8 デバッガにて途中で止めて、変数の値を確認する
		cs1.setCustName("null");

		// 項番11 デバッガにて途中で止めて、変数の値を確認する
		cs1.setKana("イトウハナエ");

		// 項番12 デバッガにて途中で止めて、変数の値を確認する
		cs1.setKana(null);

		// 項番15 デバッガにて途中で止めて、変数の値を確認する
		cs1.setTel("09023456781");

		// 項番16 デバッガにて途中で止めて、変数の値を確認する
		cs1.setTel(null);

		// 項番19 デバッガにて途中で止めて、変数の値を確認する
		cs1.setAddress("東京都千代田区2-1-1");

		// 項番20 デバッガにて途中で止めて、変数の値を確認する
		cs1.setAddress(null);

	}

}
