package model;

import java.io.Serializable;

public class Item implements Serializable {
	private static final long serialVersionUID = 1L;

	private String itemId;
	private String itemName;
	private String size;
	private int price;


	public Item() {};

	public Item(String itemId,String itemName, String size, int price ) {
			this.itemId = itemId;
			this.itemName = itemName;
			this.size = size;
			this.price = price;

	}

	public void setitemId(String itemId) {
			this.itemId = itemId;
	}

	public String getitemId() {
			return this.itemId;
	}

	public void setitemName(String itemName) {
			this.itemName = itemName;
	}

	public String getitemName() {
		return itemName;
	}

	public void setsize(String size) {
		this.size = size;
	}

	public String getsize() {
		return size;
	}

	public void setprice(int price) {
		this.price = price;
	}

	public int getprice() {
		return price;
	}


}
