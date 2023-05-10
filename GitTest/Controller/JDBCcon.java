package Controller;

public class JDBCcon {
	
	// 1. 필드
	// 아이디
	private String id;
	// 비밀번호
	private String pw;
	
	// 2. 생성자 
	public JDBCcon(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}
	
	// 3. getter/setter
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
