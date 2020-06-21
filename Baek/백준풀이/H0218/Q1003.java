package H0218;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q1003 {
	
	// 피보나치 수열을 재귀호출로 구현할 때 0과 1을 몇 번이나 호출하냐?
	// 피보나치 수열을 재귀로 구현하자
	
	static int cnt0 = 0;
	static int cnt1 = 0;
	
	public static int solution(int n) {
		
		if(n==0) {
			cnt0++;
			return 0;
		}else if(n==1) {
			cnt1++;
			return 1;
		}else {
			return solution(n-1) + solution(n-2);
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<=t-1;i++) {
			int n = Integer.parseInt(br.readLine());
			solution(n);
			System.out.println(cnt0+" "+cnt1);
			cnt0 = 0;
			cnt1 = 0;
		}
	}

}
