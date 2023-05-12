package Model;

import java.util.Random;

public class tableDTO {

	//아이디
	private String id;
	
	//비밀번호
	private String pw;

	// 생성자
	public tableDTO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public tableDTO(int myCard, int[] cardArr, int first, int second) {
	}

	public tableDTO(int[] cardArr, Random rd) {
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
