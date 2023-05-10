package View;

import java.util.Random;
import java.util.Scanner;

public class 걍만들기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int CardArr[] = new int[5];
		Random rd = new Random();

		while (true) {
			System.out.print("1. 카드뽑기 2. 종료.");
			int select = sc.nextInt();

			if (select == 1) {
				for (int i = 0; i < CardArr.length; i++) {
					CardArr[i] = rd.nextInt(10) + 1;

					for (int j = 0; j < i; j++) {
						if (CardArr[i] == CardArr[j]) {
							i--;
							break;
						}
					}
				}
				System.out.println("새로운 카드를 뽑습니다!!");
				for (int i = 0; i < CardArr.length; i++) {
					System.out.print(CardArr[i] + " ");
				}
				System.out.println();
				
				System.out.println("카드를 고르시오.");
				int num = sc.nextInt();
				int num2 = sc.nextInt();
				int MyCard = CardArr[num - 1] + CardArr[num2 - 1];
				System.out.println("나의 카드의 합: " + MyCard);
				System.out.println("게임을 시작합니다.");

				int CardArr2[] = new int[5];
				Random rd2 = new Random();

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

				int first = CardArr2[0];
				int second = CardArr2[0];
				for (int i = 1; i < CardArr2.length; i++) {
					if (CardArr2[i] > first) {
						second = first;
						first = CardArr2[i];
					} else if (CardArr2[i] > second && CardArr2[i] != first) {
						second = CardArr2[i];
					}
				}
				int YourCard = first + second;
				System.out.print(first + second);
				System.out.println();

				if (MyCard > YourCard) {
					System.out.println("1라운드 승리! +3점");
				} else if (MyCard == YourCard) {
					System.out.println("1라운드 비김. +1점");
				} else {
					System.out.println("1라운드 패배 ㅠ 목숨 -1");
				}
			}else {
				System.out.println("게임 종료.");
				break;
			}
		}
	}
}
