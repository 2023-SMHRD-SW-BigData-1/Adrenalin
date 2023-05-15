package View;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import Controller.TableController;
import Model.jdbcDAO;
import Model.jdbcDTO;
import Model.rankingDAO;
import Model.rankingDTO;
import Model.tableDTO;
import javazoom.jl.player.MP3Player;

public class CardGame_main {

	public static void main(String[] args) {
		MP3Player mp3 = new MP3Player();
		Scanner sc = new Scanner(System.in);
		jdbcDAO cdao = new jdbcDAO();
		TableController tc = new TableController();
		rankingDAO rdao = new rankingDAO();

		mp3.play("C:\\Users\\smhrd\\git\\Adrenalin\\GitTest\\music\\Play!.mp3");
		System.out.println("=====블랙잭 게임!!!====");
		System.out.println("⢀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⠀⠀⣀⣀⣀⣀⣀⣀⣀⣀⣀⠀⠀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⠀⠀⣀⣀⣀⣀⣀⢀⣀⣀⣀⡀⠀\r\n"
		         +"⣼⣿⠿⠿⠿⠿⠿⢿⣿⡿⠿⣿⣿⣿⠿⠿⠿⠿⠿⠿⠿⠿⠿⣿⣿⡿⠿⠿⠿⣿⡿⠿⢿⡿⠿⣿⣷⣿⣿⠿⠛⠿⣿⣿⠛⢿⣿⡆\r\n"
		         +"⣿⣿⣤⣤⣤⣤⠀⢀⣿⡇⠀⣿⣿⣿⠀⠀⣤⣤⣤⣤⣤⣤⣤⣿⣿⣧⣤⣄⠀⢸⡇⠀⢸⡇⠀⣿⣿⡏⠀⣠⣶⣄⠀⢻⣿⠀⢸⣿⡇\r\n"
		         +"⣼⣿⠿⠿⠿⠿⠀⢸⣿⡇⠀⣿⣿⣿⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠸⠇⠀⢸⡇⠀⣿⣿⡇⠀⢿⣿⡿⠀⢸⣿⠀⢸⣿⡇\r\n"
		         +"⢻⣿⣦⣴⣦⡴⠀⢸⣿⡇⠀⠈⣹⣿⣄⠀⠉⠉⠉⠉⠉⠉⠉⣿⣿⣿⣿⡿⠀⢠⡄⠀⢸⡇⠀⣿⣿⣷⣄⠀⠉⢀⣠⣿⣿⠀⢸⣿⡇\r\n"
		         +"⣿⣿⣿⣿⡿⠁⢠⣾⣿⡇⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣯⣾⣿⠃⠀⣿⡇⠀⢸⡇⠀⣿⣿⣿⠋⠉⠉⠉⠉⠉⠉⠀⢸⣿⡇\r\n"
		         +"⣿⣿⠛⠉⣀⣴⣿⣿⣿⡇⠀⣿⣿⡟⠛⠛⠛⠛⠛⠛⠛⠛⠛⢿⣿⠟⠁⣠⣾⣿⡇⠀⢸⡇⠀⣿⣿⣿⠀⠀⡿⠿⠷⠶⠶⠀⢸⣿⡇\r\n"
		         +" ⣿⣶⣿⣿⣿⣿⣿⣿⣇⣀⣿⣿⣷⣶⣶⣶⣶⣶⣶⣶⣶⣶⣾⣿⣷⣾⣿⣿⣿⣇⣀⣸⣇⣀⣿⣿⣿⣦⣤⣄⣀⣀⣀⣀⣀⣸⣿⠇\r\n"
		         +"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀");

		System.out.print("게임에 참여하시겠습니까?(y or n) >> ");
		String choice = sc.next();
		if (choice.equals("n")) {
			System.out.println("잘가세요.");

		} else if (choice.equals("y")) {
			System.out.println("당신은 블랙잭 게임에 참여하였습니다.");
			System.out.println("당신과 상대방의 카드에는 랜덤의 숫자로 각각 5장씩 부여됩니다");
			System.out.println("그 중 가장 높은 번호의 카드 2장을 선택하세요");
			System.out.println("그 2장의 번호의 합이 상대방보다 클 경우 이길것입니다.");
			System.out.println("다만 당신에게는 게임을 할 수 있는 3번의 기회가 있는데");
			System.out.println("상대방 카드의 합 보다 작을경우 당신이 게임에 참여할 수 있는 기회는 한번씩 사라지게 될것입니다.");
			System.out.println("상대방 보다 높은 숫자가 나올때마다 당신은 +3점씩 점수를 얻게 됩니다.");
			System.out.println("10점이상의 점수를 얻을 경우 당신은 최종 승리를 하게 됩니다.");
			while (true) {
				System.out.print("[1] 회원가입 [2] 로그인 [3] 명예의 전당 [4] 종료 : ");

				int number = sc.nextInt();

				if (number == 1) {
					System.out.print("id 입력 : ");
					String id = sc.next();
					System.out.print("pw 입력 : ");
					String pw = sc.next();
					int row = cdao.insertMember(id, pw);
					if (row > 0) {
						System.out.println("회원가입 성공");
					} else {
						System.out.println("회원가입 실패");
					}

				} else if (number == 2) {
					System.out.print("id 입력 : ");
					String id = sc.next();
					System.out.print("pw 입력 : ");
					String pw = sc.next();
					jdbcDTO cdto = cdao.login(id, pw);
					if (cdto == null) {
						System.out.println("로그인 실패");
					} else {
						System.out.println("로그인 성공");
						System.out.println();

						int CardArr[] = new int[5];
						int CardArr2[] = new int[5];
						int score = 0;
						int life = 3;
						int num = 0;
						int num2 = 0;
						int round = 1;
						int select = 0;

						System.out.println("목숨 : 3   목표 점수: 10점");
						System.out.println("게임을 시작합니다.");
						while (true) {
							System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⠀⡀⣤⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣧⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⡿⠟⠛⠛⠛⠻⠿⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⡿⠋⠀⠀⠀⠈⠒⠀⠀⠀⠀⠀⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⡃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠿⠿⡿⠿⣿⠿⢛⠟⣛⠣⢘⠛⢿⣿⣿\r\n"
									+ "⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⣧⠀⠀⠀⠈⢿⡻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠁⠀⠀⠀⠀⠑⠒⠜⣊⠹⣮⡔⣧⢈⡐⠢⢌⢻\r\n"
									+ "⣿⣿⡇⠀⠀⠀⠀⠀⠈⠢⠀⠀⠀⠹⣷⡀⠀⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠂⡙⣤⠣⢸⣧⢚⡱⣊⡖\r\n"
									+ "⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⣿⣄⠀⣀⣬⣏⢉⣡⢠⠄⠻⣿⣿⣿⣿⣿⣿⣿⠟⣭⣩⢙⣛⠻⠿⢋⠙⠁⠀⠀⠀⠐⠁⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⢣⣟⢧⣋⡶⣯⣿\r\n"
									+ "⣿⣿⣿⣄⡀⠀⠀⠁⡀⠀⡀⢄⠀⠀⠀⠘⣿⡿⣽⣿⣿⣞⡛⣻⣟⠀⢸⣿⣿⣿⣿⡟⡅⢰⣿⡿⣾⣯⣿⣟⣾⡀⠀⢀⠊⠒⢄⠀⢀⣠⣴⠟⠁⠀⢀⣠⢔⡂⠁⠛⢌⣷⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣦⡀⠀⠘⢖⠁⠈⢆⠀⠀⠀⢹⣿⣿⣿⡟⢿⠻⣿⡷⠀⣼⣿⣿⣿⡟⠀⠇⣦⣿⣿⣿⡿⣿⣻⣿⣎⠂⠆⠀⠀⢌⣼⡿⠋⠀⡄⠀⣼⣾⣿⠋⠀⠀⣀⣼⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣄⠀⡀⠦⣀⢸⣆⠀⠀⠈⣿⣿⣯⣗⠺⣹⢶⠃⢀⣿⣿⡿⠯⢁⠒⠀⢻⣯⣿⢼⢧⣻⣟⡹⣿⡶⠀⠀⢀⣾⡿⠁⠀⢀⣼⣿⣿⠟⢀⠀⣄⣾⣽⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠈⡆⠃⠁⡀⠌⠀⢹⣿⣯⣽⣵⣻⡏⢁⣹⣿⣿⡿⠷⡂⠀⢰⣼⣿⢿⢾⣿⣿⣷⣿⣽⠁⣀⢤⣾⡿⠁⠀⣠⣿⣿⠟⠁⣐⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣬⣆⠢⡑⡰⠈⠠⡟⠛⠉⠙⠷⢡⣺⣿⣿⢟⣠⣾⡁⠈⡄⠿⢿⣻⣾⣺⡿⣿⣷⡇⠈⠐⣿⡟⠑⢜⣶⣿⢿⢁⣠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣧⣑⣠⣇⡀⠀⠀⠀⣵⡿⣋⣵⣿⣿⣿⣇⠀⠠⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⡆⡿⠀⡆⣴⣟⢡⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣦⣤⢡⣾⣿⣿⣿⣿⣿⣿⣦⣶⣶⣶⣶⣶⣿⣾⣷⣿⣦⣤⣷⣧⣮⣼⣷⣷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
									+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");

							System.out.print("1. 카드뽑기 2. 종료. >>");

							select = sc.nextInt();

							if (select == 1) {
								System.out.println("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
										+ "⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⠛⠛⠋⠛⠛⢛⣛⣉⣉⡉⠉⠿⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\r\n"
										+ "⣿⣿⣿⣿⣿⠟⠟⠃⣀⣤⣶⠟⣧⠀⢿⣿⣿⣿⣧⣿⠀⢶⡶⡆⠀⣉⠛⠿⠿⣿⣿⣿⣿⣿⣿\r\n"
										+ "⣿⠿⠛⠋⣡⣤⣄⠘⢿⣿⣿⣼⣿⣇⠈⢿⣿⣿⣿⣿⠀⢸⣷⣧⠀⣿⣿⣷⣶⣤⣍⠙⢻⣿⣿\r\n"
										+ "⡧⠀⢠⣾⢿⡗⣿⣦⡀⠙⣿⣿⣽⣿⣆⠈⣿⣿⣿⣿⠀⢸⣿⣿⠀⢿⡟⣿⢋⣤⡟⠀⡈⠛⢿\r\n"
										+ "⣤⣀⠉⠘⠷⢿⣿⣿⣦⡀⠻⣿⣿⣿⡄⠘⣿⣿⣿⡇⠸⣿⣿⠀⢸⣿⣿⣾⣿⠃⣸⣿⣶⣄\r\n"
										+ "⣾⣿⣿⣷⣤⡀⠙⠿⣿⣿⣿⣦⡈⠻⣿⣿⡄⠸⣿⣿⡇⠀⣿⣿⠀⢸⣿⣿⣿⡏⢀⣿⣿⣟⣻\r\n"
										+ "⣽⣿⣾⣿⣿⣿⣶⣄⠈⠉⢻⣿⣷⣄⠈⠻⣷⡀⠹⣿⣇⠀⣿⣿⠀⢸⣿⣿⡿⠀⣼⣿⣿⣯⣽\r\n"
										+ "⠻⢯⣽⣿⣿⣿⣿⣿⣿⣦⣄⠉⠻⢿⣷⣄⣼⣇⢀⣻⣿⠀⢻⣿⠀⢸⣿⣿⠃⢠⣿⣿⣿⣿⡿\r\n"
										+ "⣤⢀⣽⣿⣿⣿⣿⣿⣿⣿⣿⣿⡶⠖⢿⣿⣿⣿⣾⣿⢻⣤⣼⣿⠀⢸⣿⡟⠀⣾⣿⣿⣿⠟⠀\r\n"
										+ "⠸⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠁⠀⠈⠻⢿⣍⠻⢟⣬⡿⣿⣿⣿⡎⣿⠁⣸⣿⣿⡿⠁⣠ \r\n"
										+ "⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⢸⡏⠀⠈⠉⠶⠌⣿⣿⡷⣿⣧⣿⣿⠋⢀⣾⣿⡷\r\n"
										+ "⠀⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⢨⡁⠀⠀⠀⠀⠀⠉⠛⢻⣿⣾⡟⠁⣰⣿⡿⠋⠀ \r\n"
										+ "⣷⣤⡀⠉⠻⢿⣿⣿⡿⠟⠁⠀⠀⠀⠀⢀⣾⣿⡿⠿⣦⡀⠀⢠⣄⠛⢛⣿⣟⣾⠿⠋⠀⠀⠀\r\n"
										+ "⡿⠋⠙⠃⠀⠒⠚⠋⠀⠀⠀⠀⠀⠀⢀⣼⠋⠁⠀⣀⠈⢷⡀⠀⠙⣿⢟⣷⣿⡿⠀⣠⣾⡿⠃\r\n"
										+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⣇⠀⠀⠀⢙⣧⣼⣷⠀⠀⠀⣼⣿⠏⠡⠾⠋⢁⣀⠀ \r\n"
										+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣇⣀⣴⠾⠋⠁⢹⡆⠀⢀⣉⣥⣿⡗⣠⣶⣿⠿⠆\r\n"
										+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠹⠏⠁⠀⠀⠀⠀⣿⡀⠈⣋⣭⣿⡟⠉⢁⣠⣤⣴ ");

								if (mp3.isPlaying()) {
									mp3.stop();
								}
								mp3.play("C:\\Users\\smhrd\\git\\Adrenalin\\GitTest\\music\\포커카드 섞는 소리.mp3");
								System.out.println("새로운 카드를 뽑습니다!!");

								CardArr = tc.newCard(CardArr);

								for (int i = 0; i < CardArr.length; i++) {
									System.out.print((i + 1) + "번 카드 : " + CardArr[i] + "\t");
								}
								System.out.println();

								System.out.println("카드를 고르시오. (띄어쓰기 조심..)");

								boolean isRunning = true;
								while (isRunning) {
									num = sc.nextInt();
									num2 = sc.nextInt();

									isRunning = tc.checkBest(num, num2, CardArr);
									if (isRunning) {
										System.out.println("가장 큰 두 수가 아닙니다. 다시 고르세요.");
									}
								}
								int MyCard = CardArr[num - 1] + CardArr[num2 - 1];
								mp3.stop();
//                        System.out.println("게임을 시작합니다.");
								System.out.println("나의 카드의 합: " + MyCard);
								CardArr2 = tc.newCard(CardArr2);

								System.out.println();
								System.out.print("상대의 카드>>  ");
								for (int i = 0; i < CardArr2.length; i++) {
									System.out.print((i + 1) + "번 카드 : " + CardArr2[i] + "\t");
								}
								System.out.println();

								System.out.print("상대의 카드의 합: ");
								int YourCard = tc.SumYourCard(CardArr2);

								System.out.println(YourCard);
								System.out.println();

								if (MyCard > YourCard) {
									System.out.println(round + "라운드 승리! +3점");
									score += 3;
									System.out.println("현재 점수 : " + score + "   현재 목숨 : " + life);
								} else if (MyCard == YourCard) {
									System.out.println(round + "라운드 비김. +1점");
									score += 1;
									System.out.println("현재 점수 : " + score + "   현재 목숨 : " + life);
								} else {
									System.out.println(round + "라운드 패배 ㅠ 목숨 -1");
									life -= 1;
									System.out.println("현재 점수 : " + score + "   현재 목숨 : " + life);
								}
								round++;
								System.out.println();

							} else if (select == 2) {
								System.out.println("게임 종료.");
								break;
							}
							if (score >= 10) {
								System.out.println("게임 승리!!!");
								int row = rdao.insertRanking(id, round, score, life);
								if (row > 0) {
									System.out.println("명예의 전당 등록.");
								}
								break;
							}
							if (life == 0) {
								System.out.println("게임 패배 ㅠㅠ");
								break;
							}
						}
						mp3.stop();
						System.out.println("수고하셨습니다.");

					}

				} else if (number == 3) {
					ArrayList<rankingDTO> dtoList = rdao.ViewRanking();
					for (int i = 0; i < dtoList.size(); i++)
						System.out.println(dtoList.get(i).getId() + " / " + dtoList.get(i).getRound() + " / "
								+ dtoList.get(i).getScore() + " / " + dtoList.get(i).getLife());
				} else if (number == 4) {
					System.out.println("종료합니다.");
					mp3.stop();
					break;
				}
			}

		}

	}
	
}