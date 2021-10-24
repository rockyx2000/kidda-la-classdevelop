package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.OrderDetail;

public class OrderDetailControlDBAccess extends ControlDBAccess {

	public ArrayList<OrderDetail> findAll() throws Exception {
		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<OrderDetail> list = new ArrayList<OrderDetail>();

		try {
			pstmt = con.prepareStatement("SELECT * FROM orderdetail");
			rs = pstmt.executeQuery();

			while(rs.next()) {
				long no = rs.getLong("no");
				int custId = rs.getInt("custid");
				String itemId = rs.getString("itemid");
				String orderDate = rs.getString("orderdate");
				int quantity = rs.getInt("quantity");
				int taxId = rs.getInt("taxid");
				int status = rs.getInt("status");
				OrderDetail orderDetail = new OrderDetail(no, custId, itemId, orderDate, quantity, taxId, status);
				list.add(orderDetail);
			}
		} catch(SQLException e) {
			throw new Exception("注文詳細テーブルの全件検索に失敗しました");
		} finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		closeConnection(con);
		return list;
	}

	public ArrayList<OrderDetail> searchOrderDetailByCustId(int s_custId) throws Exception {
		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<OrderDetail> list = new ArrayList<OrderDetail>();

		try {
			pstmt = con.prepareStatement("SELECT * FROM orderdetail WHERE custid = ?");
			pstmt.setInt(1, s_custId);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				long no = rs.getLong("no");
				int custId = rs.getInt("custid");
				String itemId = rs.getString("itemid");
				String orderDate = rs.getString("orderdate");
				int quantity = rs.getInt("quantity");
				int taxId = rs.getInt("taxid");
				int status = rs.getInt("status");
				OrderDetail orderDetail = new OrderDetail(no, custId, itemId, orderDate, quantity, taxId, status);
				list.add(orderDetail);
			}
		} catch(SQLException e) {
			throw new Exception("注文詳細テーブルのID検索に失敗しました");
		} finally {
			if(rs != null) {
				try {
					rs.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		closeConnection(con);
		return list;
	}

	public int modifyOrderDetail(OrderDetail orderDetail) throws Exception {
		Connection con = createConnection();
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			long no = orderDetail.getNo();
			int custId = orderDetail.getCustId();
			String itemId = orderDetail.getItemId();
			String orderDate = orderDetail.getOrderDate();
			int quantity = orderDetail.getQuantity();
			int taxId = orderDetail.getTaxId();
			int status = orderDetail.getStatus();

			pstmt = con.prepareStatement("UPDATE orderdetail SET custid = ?, itemid = ?, orderdate = ?, quantity = ?, taxid = ?, status = ? WHERE no = ?");
			pstmt.setInt(1, custId);
			pstmt.setString(2, itemId);
			pstmt.setString(3, orderDate);
			pstmt.setInt(4, quantity);
			pstmt.setInt(5, taxId);
			pstmt.setInt(6, status);
			pstmt.setLong(7, no);
			count = pstmt.executeUpdate();

		} catch(SQLException e) {
			throw new Exception("注文詳細テーブルの更新に失敗しました");
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		closeConnection(con);
		return count;
	}
}