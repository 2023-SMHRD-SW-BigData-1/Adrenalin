import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {

		// 미니프로젝트 주제: 학원탈출
		// 1. 스캐너 이용해서 이름 입력 받고 이름 나오는 부분 전부 name변수 처리
				Scanner sc = new Scanner(System.in);
				System.out.print("이름을 입력하세요 : ");
				int name = sc.nextInt();
		// 2. 보기를 통해 상황을 부여하여 탈출하는 방식
				System.out.println(name+"은 종례시간이 되었다. 어떻게 할까?");
				System.out.println("1. 지문을 찍고 집에가서 잔다.    2. 지문은 제끼고 후다닥 나간다.");
				int num1 = sc.nextInt();
				if(num1==1) {
					System.out.println("당신은 모범생입니다. 이 게임을 즐길 자격이 없습니다. 게임 종료.");
					
				}else if(num1==2){
					System.out.println("저녁 9시 게임을 하는중 전화가 온다. 정세연 선생님");
					System.out.println("선생님 : "+name+"씨 지문 안찍고 가셨네요? 지금 당장 오세요.. 하...");
					System.out.println(name+" : 하... 화난다... 일단 가야지..");
					System.out.println("저장하시겠습니까?");
					System.out.println("1. 네     2. 아니요");
					int num2 = sc.nextInt();
					if(num2==2) {
						System.out.println("당신은 급하고 신중하지 못합니다. 게임 자격미달. 게임 종료.");
					}else {
					System.out.println();
					System.out.println("당신은 1층에 도착했다. 어떻게 올라갈 것인가?");
					System.out.println("1. 엘레베이터를 타고 간다.   2. 계단으로 올라간다.");
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					}
					
					
				}
				
		// 3. 각자 한층씩 상황을 상상하여 만든 후 상의
		
		// 4. 중간중간에 데이터베이스나 자바 문제들을 넣기
		
		// 5. 어느정도 상황들이 이어질 수 있도록 조정하기
		
		
		
	}

}
