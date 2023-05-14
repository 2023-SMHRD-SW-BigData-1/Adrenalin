package Model;

import java.util.Random;

public class tableDTO {
	private int CardArr[] = new int[5];
	private Random rd = new Random();
	private int CardArr2[] = new int[5];
	private Random rd2 = new Random();
	private int score = 0;
	private int life = 3;
	private int num = 0;
	private int num2 = 0;
	private int round = 1;
	private int MyCard=0;
	private int select=0;
	public tableDTO(int[] cardArr, Random rd, int[] cardArr2, Random rd2, int score, int life, int num, int num2,
			int round, int myCard, int select) {
		super();
		CardArr = cardArr;
		this.rd = rd;
		CardArr2 = cardArr2;
		this.rd2 = rd2;
		this.score = score;
		this.life = life;
		this.num = num;
		this.num2 = num2;
		this.round = round;
		MyCard = myCard;
		this.select = select;
	}

	public tableDTO(int round) {
		super();
		this.round = round;
	}

	public tableDTO(int[] cardArr, Random rd) {
		super();
		CardArr = cardArr;
		this.rd = rd;
	}
	public tableDTO(int myCard2, int[] cardArr3, int num, int num2) {
		// TODO Auto-generated constructor stub
	}
	public tableDTO(int rsRound, int rsLife, int rsScore) {
		this.score = rsScore;
		this.life = rsLife;
		this.round = rsRound;
	}

	public int[] getCardArr() {
		return CardArr;
	}
	public void setCardArr(int[] cardArr) {
		CardArr = cardArr;
	}
	public Random getRd() {
		return rd;
	}
	public void setRd(Random rd) {
		this.rd = rd;
	}
	public int[] getCardArr2() {
		return CardArr2;
	}
	public void setCardArr2(int[] cardArr2) {
		CardArr2 = cardArr2;
	}
	public Random getRd2() {
		return rd2;
	}
	public void setRd2(Random rd2) {
		this.rd2 = rd2;
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
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	public int getRound() {
		return round;
	}
	public void setRound(int round) {
		this.round = round;
	}
	public int getMyCard() {
		return MyCard;
	}
	public void setMyCard(int myCard) {
		MyCard = myCard;
	}
	public int getSelect() {
		return select;
	}
	public void setSelect(int select) {
		this.select = select;
	}


}
