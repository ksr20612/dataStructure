package 재귀;

import java.util.Scanner;

public class 홀수짝수다른연산 {

	/*
	 * 정수 n에 대하여, 
	 * 1. n이 홀수면 3*n+1을,
	 * 2. n이 짝수면 n/2를 한다
	 * n이 1이 될때까지 계속하며, 그 과정 사이에 있는 모든 n의 값을 인출한다.
	 */
	
	public static void solution(int n) {
		if(n==1) System.out.println(1);
		else {
			System.out.println(n);
			if(n%2!=0) solution(3*n+1);
			else solution(n/2);
		}
	}
	
	// fastCampust 코드
	
	public static int fastSolution(int n) {
		System.out.println(n); // 어차피 함수를 타면 인출해야 하니까 
		if(n==1) return 1;
		
		if(n%2==1) return fastSolution(3*n+1);
		else return fastSolution(n/2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		solution(sc.nextInt());
	}

}
