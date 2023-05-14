package Model;

public class rankingDTO {
	private String id;
	private int round;
	private int score;
	private int life;
	
	public rankingDTO(String id, int round, int score, int life) {
		super();
		this.id = id;
		this.round = round;
		this.score = score;
		this.life = life;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
}
