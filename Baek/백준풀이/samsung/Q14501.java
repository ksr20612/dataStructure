package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q14501 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		/*
		 * 1. dynamic programming으로 풀면 될듯(dp[i]에는 i일까지 일할 때 벌 수 있는 최대 금액이 담김)
		 * 2. 점화식을 못 찾겠다... ==> 기간의 값이 걸려있어서 복잡하다...
		 */
		
		// 값 받아오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] time = new int[n+1];
		int[] price = new int[n+1];
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			time[i] = Integer.parseInt(st.nextToken());
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+1];
		
		/* dp에는 최대 수익이 담기나, 7일차부터 ((거꾸로)) 수익을 따지는 방식으로 생각해볼 것.
		*  dp[7] 에는 7일날에 벌 수 있는 돈이 담김(만약 걸리는 시간이 하루면 수행할 수 있으므로 dp[7]=price[7])
		*  dp[6] 에는 6일날에 벌 수 있는 돈을 고려한 최대값을 선택해줌( 하루 걸리냐,	
		*/
		
	}

}
