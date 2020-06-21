package B0113;

import java.util.Scanner;

public class Q11727 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 0. dynamic programming 이용하면 될 것 같다.
		 * 1. 가장 최소의 원소로 분해하면 1*2, 2*2, 2*2가 가로로 잘린 것
		 * 2. dp[n] = dp[n-1] + 2*dp[n-2] 이 도출됨
		 */
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] dp = new int[n+1];
		dp[1]=1;
		dp[2]=3;
		
		for(int i=3;i<=n;i++) {
			dp[i]=dp[i-1]+2*dp[i-2];
		}
		
		System.out.println(dp[n]%10007);
		
	}

}
