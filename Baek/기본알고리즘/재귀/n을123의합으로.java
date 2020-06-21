package 재귀;

import java.util.Scanner;

public class n을123의합으로 {

	/*
	 * n을 1,2,3의 합으로 나타내는 모든 경우의 수를 출력하기
	 *   ===> 규칙찾기
	 */
	
	public static int solution(int n) {
		if(n==1) return 1;
		if(n==2) return 2;
		if(n==3) return 4;
		
		return solution(n-1) + solution(n-2) + solution(n-3);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(solution(n));
	}

}
