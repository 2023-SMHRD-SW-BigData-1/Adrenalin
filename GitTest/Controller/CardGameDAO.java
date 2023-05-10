package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardGameDAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	
	// DB연결 메소드
		public void getConn() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
				String db_id = "service";
				String db_pw = "12345";

				conn = DriverManager.getConnection(url, db_id, db_pw);

			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// DB연결끊기 메소드
		public void getClose() {
			try {
				if (rs != null)
					rs.close();
				if (psmt != null)
					psmt.close();
				if (conn != null)
					conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		// 회원가입 메소드
		public int insertUser(String id, String pw) {

			getConn();
			String sql = "INSERT INTO USER VALUES(?,?)";
			int cnt = 0;

			try {
				psmt = conn.prepareStatement(sql);

				psmt.setString(1, id);
				psmt.setString(2, pw);

				cnt = psmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				getClose();
			}
			return cnt;
		}
	
	
	
}
