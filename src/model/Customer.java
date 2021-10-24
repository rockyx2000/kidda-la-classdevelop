/**
 * ClassName	:	Customer
 * Summary		:	Manage Customer information
 * CreatorName  :	Ohtake
 * CreateDate 	:	2021/05/17
 * EditerName	:
 * EditDate		:
 */


package model;

import java.io.Serializable;

public class Customer implements Serializable {
		private static final long serialVersionUID = 1L;

		private int custId;
		private String custName;
		private String kana;
		private String tel;
		private String address;

		public Customer() {};

		public Customer(int custId,String custName, String kana, String tel, String address ) {
				this.custId = custId;
				this.custName = custName;
				this.kana = kana;
				this.tel = tel;
				this.address = address;
		}

		public void setCustId(int custId) {
				this.custId = custId;
		}

		public int getCustId() {
				return this.custId;
		}

		public void setCustName(String custName) {
				this.custName = custName;
		}

		public String getCustName() {
			return custName;
		}

		public void setKana(String kana) {
			this.kana = kana;
		}

		public String getKana() {
			return kana;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		public String getTel() {
			return tel;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getAddress() {
			return address;
		}
}
