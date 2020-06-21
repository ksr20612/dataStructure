package B0113;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2292 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 벌집 문제
		
		/*
		 * 사고의 흐름
		 * 1. dynamic programming? - 그런데 표현하는 게 어려워 보인다.
		 * 2. 몇 개의 방을 지나가냐라는 말은 결국 그 방의 위치가 몇번째 겹에 있냐라는 말이라는 것을 깨달음, dynamic programming 없이도 풀 수 있겠다.
		 * 3. 1(1개) / 2~7(6개) / 8~19(12개) / 20~37(18개) / ... n번째 겹은 6*(n-1)개의 숫자를 담는다(단, 첫번째 겹은 1개)
		 * 4. 각 겹의 시작 숫자와 마지막 숫자를 계산하여 그 숫자 사이에 최초에 제시되는 숫자(방 번호)가 존재할 때 루프의 횟수를 출력한다.
		 */
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		if(n==1) System.out.println(1); // 첫번째 겹일 경우 그냥 1 출력하기
		else{
			int rowEnd = 1;
			for(int i=2;true;i++) {
				int rowStart = rowEnd+1; // 겹의 시작 숫자
				rowEnd += 6*(i-1); // 두번째 겹부터 더해주기(겹의 마지막 숫자와도 동일)
				
				if(n>=rowStart&&n<=rowEnd) {
					System.out.println(i); 
					break;
				}	
			}
		}
		
	}

}
