/**
 * ClassName    :    ControlDBAccess
 * Summary      :    Manage KIDDA-LA DB connect and disconnect
 * CreatorName  :    Ohtake
 * CreateDate   :    2021/05/17
 * EditerName   :
 * EditDate     :
 */


package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ControlDBAccess {

		protected Connection createConnection() throws Exception{
			Connection con = null;
			try {

				//load JDBC Driver
				Class.forName("org.mariadb.jdbc.Driver");

				//connect DB
				con = DriverManager.getConnection(
						"jdbc:mariadb://localhost/kidda_la","kbcstudent","kbcstudent");
			}catch(ClassNotFoundException e) {
				throw new Exception("DB接続処理に失敗しました！");
			}catch(SQLException e) {
				throw new Exception("DB接続処理に失敗しました！");
			}
			return con;
		}

		protected void closeConnection(Connection con) throws Exception{
			try {
				if(con != null) {
					con.close();
				}
			}catch(SQLException e) {
				throw new Exception("DB切断処理に失敗しました!");
			}
		}
}
