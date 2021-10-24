/**
 * ClassName    :    CustomerControlDBAccess
 * Summary      :    Manage KIDDA-LA DB access(Customer information)
 * CreatorName  :    Ohtake
 * CreateDate   :    2021/05/17
 * EditerName   :
 * EditDate     :
 */


package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Customer;

public class CustomerControlDBAccess extends ControlDBAccess {

	public ArrayList<Customer> searchCustomerByTel(String s_tel) throws Exception{

		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();

		try {
				String sql = "select * from customer where tel= ?";

				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, s_tel);
				rs = pstmt.executeQuery();

				while(rs.next()) {
					int custId = rs.getInt("custid");
					String custName = rs.getString("custname");
					String kana = rs.getString("kana");
					String address = rs.getString("address");
					Customer customer = new Customer(custId, custName, kana, s_tel, address);

					list.add(customer);
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
		return list;
	}

	public ArrayList<Customer> findAll() throws Exception{

		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();

		try {
				String sql = "select * from customer";

				pstmt = con.prepareStatement(sql);

				rs = pstmt.executeQuery();

				while(rs.next()) {
					int custId = rs.getInt("custid");
					String custName = rs.getString("custname");
					String kana = rs.getString("kana");
					String address = rs.getString("address");
					String tel = rs.getString("tel");
					Customer customer = new Customer(custId, custName, kana, tel, address);

					list.add(customer);
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
		return list;
	}

	public ArrayList<Customer> searchCustomerByKana(String s_kana) throws Exception{
		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Customer> list = new ArrayList<Customer>();

		try {
			pstmt = con.prepareStatement(
					"SELECT CUSTID, CUSTNAME, KANA, TEL, ADDRESS FROM CUSTOMER WHERE KANA LIKE ?");
			pstmt.setString(1, "%" + s_kana + "%");
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int custId = rs.getInt("custid");
				String custName = rs.getString("custname");
				String kana = rs.getString("kana");
				String tel = rs.getString("tel");
				String address = rs.getString("address");
				Customer customer = new Customer(custId, custName, kana, tel, address);

				list.add(customer);
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
		return list;
	}


	public Customer searchCustomerById(int s_custId) throws Exception{
		Connection con = createConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Customer customer = null;
		try {
			pstmt = con.prepareStatement(
					"SELECT CUSTID, CUSTNAME, KANA, TEL, ADDRESS FROM CUSTOMER WHERE CUSTID = ?");
			pstmt.setInt(1,s_custId);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				String custName = rs.getString("custname");
				String kana =rs.getString("kana");
				String tel = rs.getString("tel");
				String address = rs.getString("address");
				customer = new Customer(s_custId, custName,kana,tel,address);
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
		return customer;
	}

	public int modifyCustomer(Customer customer) throws Exception{
		Connection con = createConnection();
		PreparedStatement pstmt = null;
		int count = 0;

		try {
			int custId = customer.getCustId();
			String custName = customer.getCustName();
			String kana = customer.getKana();
			String tel = customer.getTel();
			String address = customer.getAddress();

			pstmt = con.prepareStatement(
					"UPDATE CUSTOMER SET CUSTNAME = ?. KANA = ?, TEL = ?, ADDRESS = ? WHERE CUSTID = ?");
			pstmt.setString(1, custName);
			pstmt.setString(2, kana);
			pstmt.setString(3, tel);
			pstmt.setString(4, address);
			pstmt.setInt(5, custId);
			count = pstmt.executeUpdate();
		}catch(SQLException e) {
			throw new Exception("顧客情報更新処理に失敗しました！");
		}finally {
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
    public ArrayList<Customer> searchAll() throws Exception{
        Connection con = createConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<Customer> list = new ArrayList<Customer>();

        try {
            pstmt = con.prepareStatement("select custid, custname, kana, tel, address from customer ");

            rs = pstmt.executeQuery();

            while (rs.next()) {
                int custId = rs.getInt("custid");
                String custName = rs.getString("custname");
                String kana = rs.getString("kana");
                String tel = rs.getString("tel");
                String address = rs.getString("address");
                Customer customer = new Customer(custId, custName, kana, tel, address);
                list.add(customer);
            }
        } catch (SQLException e) {
            System.out.println(e);
            throw new Exception("顧客情報検索処理に失敗しました");
        }finally{
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        closeConnection(con);
        return list;
    }
}
