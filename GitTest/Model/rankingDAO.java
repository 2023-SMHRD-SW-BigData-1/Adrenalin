package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class rankingDAO {
	private Connection Conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	int row = 0;
	
	
	
	

	private void getConn() {

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@172.30.1.30:1521:xe";
			String db_id = "mini";
			String db_pw = "12345";

			Conn = DriverManager.getConnection(url, db_id, db_pw);



		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void getClose() {

		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (Conn != null)
				Conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public int insertRanking(String id,int round,int score,int life) {

		getConn();
		String sql = "insert into ranking values (?,?,?,?)";
		try {
			psmt=Conn.prepareStatement(sql);
			psmt.setString(1, id);
			psmt.setInt(2, round);
			psmt.setInt(3, score);
			psmt.setInt(4, life);
			
			row = psmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
			
		}
		return row;
	}
	
	public ArrayList<rankingDTO> ViewRanking() {
		
		String sql = "select * from ranking order by score desc , life desc, round";
		rankingDTO rdto = null;
		ArrayList<rankingDTO> dtoList = new ArrayList<>();

		getConn();
		try {
			psmt = Conn.prepareStatement(sql);

			rs = psmt.executeQuery();
			System.out.println("ID"+" \t"+"ROUND"+" \t"+"SCORE"+" \t"+"LIFE");
			
			while (rs.next()) {
				
				String r_id = rs.getString("id");
				
				int r_round = rs.getInt(2);
				int r_score = rs.getInt(3);
				int r_life = rs.getInt(4);

				rdto = new rankingDTO(r_id, r_round,r_score,r_life);
				dtoList.add(rdto);

				
			}

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			getClose();
		}
		return dtoList;
	}
	
}

