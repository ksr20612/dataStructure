package H0218;

import java.util.Scanner;

public class Q2748 {

	// 피보나치 수열을 dp로 구현하자
	
	public static int 피보나치(int n) {
		
		int[] dp = new int[90];
		
		dp[0] = 0;
		dp[1] = 1;
		
		for(int i=2;i<=n;i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		
		return dp[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(피보나치(n));
		
	}

}
