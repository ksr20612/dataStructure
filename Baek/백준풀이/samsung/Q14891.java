package samsung;

import java.util.Scanner;

public class Q14891 {

	static String[] gear; //각 톱니바퀴의 상황을 저장
	static boolean[] visit;//재방문 여부
	
	// 3. 점수 구하기
	public static int score() {
		int sum = 0;
		for(int i=0;i<4;i++) {
			if(gear[i].charAt(0)=='1') // 맨 위의 애가 s극이면
				sum += Math.pow(2, i); // 점수를 더해준다
		}
		return sum;
	}
	
	// 1. 돌리기
	public static void rotate(int index, int dir) {
		
		if(dir==1) { //시계방향
			gear[index] = gear[index].charAt(7)+gear[index].substring(0, 7);
		}
		else if(dir==-1) { //반시계방향
			gear[index] = gear[index].substring(1)+gear[index].charAt(0);
		}
	}
	
	// 2. 돌아가는지 판단하기
	public static void run(int index,int dir) {
		
		if(index <0 || index>3 || visit[index]) { // 종료하기
			return;
		}
		
		visit[index]=true; // 이미 검사한 애임
		
		// 돌릴까 말까 판단해주기 ---> 재귀로
		if(index != 0 && !visit[index-1]) { // 왼쪽에 있는 톱니
			if(gear[index].charAt(6) != gear[index-1].charAt(2)) // 극이 다를 경우만 반대로 회전
				run(index-1,dir*-1);
		}
		
		if(index != 3 && !visit[index+1]) { // 오른쪽에 있는 톱니
			if(gear[index].charAt(2) != gear[index+1].charAt(6))
				run(index+1,dir*-1);
		}
		
		rotate(index,dir);// 그 애를 돌려주세요
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 필요한 메서드
		 * 1. 톱니바퀴 돌리기
		 * 2. 맞닿아 있는 바퀴가 돌아가는지 판단하기 -> 왼쪽 톱니가 돌아가냐? 내 6번과 왼쪽의 2번 비교 // 오른쪽 톱니가 돌아가냐? 내 2번과 오른쪽의 6번 비교
		 * 3. 점수 구하기
		 * 
		 * ===> 바퀴가 돌아가는지 몽땅 판단해준 뒤 톱니바퀴를 돌리고 12시 방향의 점수를 더해주기
		 */

		Scanner sc = new Scanner(System.in);
		gear = new String[4];
		
		for(int i=0;i<4;i++) {
			gear[i] = sc.next(); // 배열로 받지 않고 그냥 string으로 받음
		}
		int runCount = sc.nextInt();

		for(int t=1;t<=runCount;t++) {
			int gearNum = sc.nextInt()-1; // 몇번째 톱니냐?
			int dir = sc.nextInt(); // 어떤 방향으로 돌리냐?
			
			visit = new boolean[4]; // 이미 판단 끝난 애인지 확인하는 용도
			
			run(gearNum,dir);

		}
		System.out.println(score());
	}

}
