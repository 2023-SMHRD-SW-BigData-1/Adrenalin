package View;

import java.util.Random;
import java.util.Scanner;

public class CardGame_main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("=====블랙잭 게임!!!====");
		
		while(true) {
			System.out.print("[1] 회원가입 [2] 로그인 [3]게임시작 : ");
			
			int num = sc.nextInt();
 
			if(num==1) {
				System.out.print("id 입력 : ");
				String id = sc.next();
				System.out.print("pw 입력 : ");
				String pw = sc.next();
				 
			}
		}
		
		
		
		
		
		
		
		

	}

}
