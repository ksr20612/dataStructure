package 재귀;

import java.util.Scanner;

public class Q11729 {

	public static int cnt;
	public static StringBuilder sb = new StringBuilder();
	
	public static void hanoi(int n, int a, int b, int c) {
		
		if(n==1) {
			sb.append(a+" "+c+"\n");
			cnt++;
		}else {
			hanoi(n-1,a,c,b); // n-1개를 1->2으로 옮기기
			sb.append(a+" "+c+"\n"); // 1번자리에 남은 1개를 3번자리로 옮기기
			cnt++;
			hanoi(n-1,b,a,c);
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * <하노이의 탑 문제>
		 *  - 방법을 쪼개면,
		 *  1. 1번 자리에 놓인 n개의 원판 중 n-1개를 가운데 자리로 옮긴다
		 *  2. 1번 자리에 놓인 1개의 원판을 3번 자리로 옮긴다
		 *  3. 가운데 자리에 놓인 n-1개의 원판을 3번자리로 옮긴다
		 *  
		 *  옮기는 횟수를 카운팅
		 */
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		hanoi(n,1,2,3);
		
		System.out.println(cnt);
		System.out.println(sb);
		
	}

}
