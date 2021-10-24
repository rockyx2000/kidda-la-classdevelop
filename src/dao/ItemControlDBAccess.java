package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Item;

public class ItemControlDBAccess extends ControlDBAccess{

	public ArrayList<Item> findAll() throws Exception{

		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Item> list_all= new ArrayList<Item>();

		try {
				String sql = "select * from item";

				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();

				while(rs.next()) {
					String itemId = rs.getString("itemid");
					String itemName = rs.getString("itemname");
					String size = rs.getString("size");
					int price = rs.getInt("price");
					Item item = new Item(itemId, itemName, size,price);

					list_all.add(item);
				}
		}catch(SQLException e) {
			throw new Exception("顧客情報検索処理に失敗しました！");
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}

		closeConnection(con);
		return list_all;
	}

	public ArrayList<Item> searchItemByName(String s_name) throws Exception{

		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Item> list_name = new ArrayList<Item>();

		try {
			pstmt = con.prepareStatement(
					"select * from item where itemname LIKE ?");
				pstmt.setString(1, "%" + s_name + "%");
				rs = pstmt.executeQuery();

				while(rs.next()) {
					String itemId = rs.getString("itemid");
					String itemName = rs.getString("itemname");
					String size = rs.getString("size");
					int price = rs.getInt("price");
					Item item = new Item(itemId, itemName, size, price);

					list_name.add(item);
				}
		}catch(SQLException e) {
			throw new Exception("顧客情報検索処理に失敗しました！");
		}finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}

		closeConnection(con);
		return list_name;
	}

	public ArrayList<Item> searchItemById(String s_id) throws Exception{
		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Item> Item = new ArrayList<Item>();

		try {
			String sql = "select * from item where itemid = ?";

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, s_id);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String itemId = rs.getString("itemId");
				String itemName = rs.getString("itemName");
				String size = rs.getString("size");
				int price = rs.getInt("price");
				Item item = new Item(itemId, itemName, size, price);

				Item.add(item);
			}
		}catch(SQLException e) {
			System.out.println(e);
			throw new Exception("顧客情報検索処理に失敗しました！");
		}finally{
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		closeConnection(con);
		return Item;
	}
}

