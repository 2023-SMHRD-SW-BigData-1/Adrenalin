package View;

import java.util.Random;
import java.util.Scanner;

public class main에모두담기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int CardArr[] = new int[5];
		Random rd = new Random();
		int CardArr2[] = new int[5];
		Random rd2 = new Random();
		int score = 0;
		int life = 3;
		int num = 0;
		int num2 = 0;
		int round = 1;
		int MyCard=0;
		

		System.out.println("목숨 : 3   목표 점수: 10점");
		while (true) {
			System.out.print("1. 카드뽑기 2. 종료. >>");

			int select = sc.nextInt();

			if (select == 1) {

				System.out.println("새로운 카드를 뽑습니다!!");
				for (int i = 0; i < CardArr.length; i++) {
					CardArr[i] = rd.nextInt(10) + 1;

					for (int j = 0; j < i; j++) {
						if (CardArr[i] == CardArr[j]) {
							i--;
							break;
						}
					}
				}
				
				for (int i = 0; i < CardArr.length; i++) {
					System.out.print((i+1)+"번 카드 : "+CardArr[i] + "\t");
				}
				System.out.println();

				System.out.println("카드를 고르시오. (띄어쓰기 조심..)");
				int first=0;
				int second=0;

				while (true) {
					num = sc.nextInt();
					num2 = sc.nextInt();
					MyCard = CardArr[num - 1] + CardArr[num2 - 1];

					for (int i = 0; i < CardArr.length; i++) {
						if (CardArr[i] > first) {
							second = first;
							first = CardArr[i];
						} else if (CardArr[i] > second && CardArr[i] != first) {
							second = CardArr[i];
						}
					}

					if (MyCard == first + second) {
						break;
					} else {
						System.out.println("가장 큰 두 수가 아닙니다. 다시 고르세요.");

					}
				}

				System.out.println("게임을 시작합니다.");
				System.out.println("나의 카드의 합: " + MyCard);

				for (int i = 0; i < CardArr2.length; i++) {
					CardArr2[i] = rd2.nextInt(10) + 1;

					for (int j = 0; j < i; j++) {
						if (CardArr2[i] == CardArr2[j]) {
							i--;
							break;
						}
					}
				}
				System.out.print("상대의 카드: ");
				for (int i = 0; i < CardArr2.length; i++) {
					System.out.print(CardArr2[i] + " ");
				}
				System.out.println();
				System.out.print("상대의 카드의 합: ");
				int first2 = 0;
				int second2 = 0;

				for (int i = 0; i < CardArr2.length; i++) {
					if (CardArr2[i] > first2) {
						second2 = first2;
						first2 = CardArr2[i];
					} else if (CardArr2[i] > second2 && CardArr2[i] != first2) {
						second2 = CardArr2[i];
					}
				}
				int YourCard = first2 + second2;
				System.out.print(first2 + second2);
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
			if (score > 10) {
				System.out.println("게임 승리!!!");
				break;
			}
			if (life == 0) {
				System.out.println("게임 패배 ㅠㅠ");
				break;
			}
		}
		System.out.println("수고하셨습니다.");
	}
}
