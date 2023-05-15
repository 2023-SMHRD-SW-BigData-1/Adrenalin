package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import Model.jdbcDTO;

public class jdbcDAO {
   private Connection Conn;
   private PreparedStatement psmt;
   private ResultSet rs;
   int row = 0;

   private void getConn() {

      // 동적로딩 -- 어떤 클래스파일의 어떤 데이터베이스를 사용 할 것인지
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         String url = "jdbc:oracle:thin:@172.30.1.30:1521:xe";
         String db_id = "mini";
         String db_pw = "12345";

         Conn = DriverManager.getConnection(url, db_id, db_pw);

         if (Conn != null) {
            System.out.println("연결 성공");
         } else {
            System.out.println("연결 실패");
         }

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

   public int insertMember(String id, String pw) {
      getConn();

      String sql = "insert into gamemember values (?,?)";
      try {
         psmt = Conn.prepareStatement(sql);
         psmt.setString(1, id);
         psmt.setString(2, pw);

         row = psmt.executeUpdate();

      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
         getClose();
      }
      return row;
   }

   public jdbcDTO login(String id, String pw) {
      getConn();
      String sql = "select * from gamemember where id=? and pw=?";
      jdbcDTO cdto = null;
      try {
         psmt = Conn.prepareStatement(sql);
         psmt.setString(1, id);
         psmt.setString(2, pw);

         rs = psmt.executeQuery();
         if (rs.next()) {// 중복이 없다는 가정 하에 if문도 사용 가능
            String s_id = rs.getString(1);
            String s_pw = rs.getString(2);
            cdto = new jdbcDTO(id, pw);
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }finally {
    	  getClose();
      }
      return cdto;
   }

}