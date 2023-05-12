package Controller;

import java.util.Random;

import Model.tableDTO;

public class TableController {
//data access object -- db 
	Random rd = new Random();
	Random rd2 = new Random();

	public int SumYourCard(int[] CardArr2) {
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
		return YourCard;

	}

	public int[] newCard(int CardArr[]) {
		for (int i = 0; i < CardArr.length; i++) {
			CardArr[i] = rd.nextInt(10) + 1;

			for (int j = 0; j < i; j++) {
				if (CardArr[i] == CardArr[j]) {
					i--;
					break;
				}
			}
		}

		return CardArr;
	}

	public int[] yourCard(int CardArr2[]) {
		for (int i = 0; i < CardArr2.length; i++) {
			CardArr2[i] = rd2.nextInt(10) + 1;

			for (int j = 0; j < i; j++) {
				if (CardArr2[i] == CardArr2[j]) {
					i--;
					break;
				}
			}
		}

		return CardArr2;
	}

	public boolean checkBest(int num, int num2, int[] CardArr) {

		int MyCard = CardArr[num - 1] + CardArr[num2 - 1];
		int first = 0;
		int second = 0;

		for (int i = 0; i < CardArr.length; i++) {
			if (CardArr[i] > first) {
				second = first;
				first = CardArr[i];
			} else if (CardArr[i] > second && CardArr[i] != first) {
				second = CardArr[i];
			}
		}

		if (MyCard == first + second) {
			return false;
		} else {
			return true;

		}

	}

	public tableDTO NewCard(int CardArr[], Random rd) {

		tableDTO tdto = null;
		for (int i = 0; i < CardArr.length; i++) {
			CardArr[i] = ((java.util.Random) rd).nextInt(10) + 1;

			for (int j = 0; j < i; j++) {
				if (CardArr[i] == CardArr[j]) {
					i--;
					break;
				}
			}
		}

		for (int i = 0; i < CardArr.length; i++) {
			System.out.print((i + 1) + "번 카드 : " + CardArr[i] + "\t");
		}
		System.out.println();
		tdto = new tableDTO(CardArr, rd);
		return tdto;
	}

}