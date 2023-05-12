package Model;

public class jdbcDTO {

   //아이디
   private String id;
   
   
   //비밀번호
   private String pw;


   public jdbcDTO(String id, String pw) {
      super();
      this.id = id;
      this.pw = pw;
   }


   public String getId() {
      return id;
   }


   public void setId(String id) {
      this.id = id;
   }


   public String getPw() {
      return pw;
   }


   public void setPw(String pw) {
      this.pw = pw;
   }
   
}