package View;

import java.util.Random;

public class CardGame_main {

	public static void main(String[] args) {

		
		Random rd = new Random();

		int[] arr = new int[5];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = rd.nextInt(10) + 1;

			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.println("카드 숫자 : " + arr[i]);
		}

	}

}
