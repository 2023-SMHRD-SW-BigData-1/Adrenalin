package View;

import java.util.Random;
import java.util.Scanner;

public class CardGame_main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("=====블랙잭 게임!!!====");
		
		System.out.println("당신은 블랙잭 게임에 참여하였습니다.");
		System.out.println("당신과 상대방의 카드에는 랜덤의 숫자로 각각 5장씩 부여됩니다");
		System.out.println("그 중 가장 높은 번호의 카드 2장을 선택하세요");
		System.out.println("그 2장의 번호의 합이 상대방보다 클 경우 이길것입니다.");
		System.out.println("다만 당신에게는 게임을 할 수 있는 3번의 기회가 있는데");
		System.out.println("상대방 카드의 합 보다 작을경우 당신이 게임에 참여할 수 있는 기회는 한번씩 사라지게 될것입니다.");
		System.out.println("상대방 보다 높은 숫자가 나올때마다 당신은 +3점씩 점수를 얻게 됩니다.");
		System.out.println("10점이상의 점수를 얻을 경우 당신은 최종 승리를 하게 됩니다.");
		
		System.out.print("게임에 참여하시겠습니까?(y or n) >> ");
		String choice = sc.next();
		if(choice =="y") { 
			 
		}else if(choice=="n") {
			System.out.println("잘가세요.");
		}
		
		
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
