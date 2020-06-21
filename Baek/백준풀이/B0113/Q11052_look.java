package B0113;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q11052_look {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		/*
		 * 1. dynamic programming 이용하는 것 같다.
		 * 2. dp[n]에는 n+1개를 살 때 최대값이 담겨야 한다(max이용)
		 * 3. 점화식...?
		 * 4. 케이스를 따져보니 결국 카드n 하나만 사는 값과 dp[n-1]에 값에 한개짜리 카드 하나 더 사는 값을 더한 새로운 값 중 큰 값을 고르면 됨
		 * 5. 그런데 n=4인 경우부터는 예외가 생김...
		 * 6. 4번식대로 생각할 경우 p2+p2의 사례를 놓침... (막힘)
		 * 7. 다시 생각해봄
		 * 8. 1개 살때 -> p1(=dp[1])
		 *    2개 살때 -> p2 vs. dp[1]+p1
		 *    3개 살때 -> p3 vs. dp[2]+p1 vs. dp[1]+p2 
		 *    4개 살때 -> p4 vs. dp[3]+p1 vs. dp[2]+?(p2) vs. dp[1]+p3
		 *    (* ? 안에서 dp[2]+p1+p1의 경우는 무시해도 되는 이유를 깨달았다.
		 *    	==> 어짜피 그 경우는 dp[3]+p1에 포함되는 애. 왜냐하면 dp[3] 계산할 때 dp[2]+p1을 딴 애와 비교하여 그 중 큰 애를 dp[3]으로 하기로 했다.
		 *    		따라서 dp[2]+p1에다가 p1을 또 더한 애는 3개 살때 경우에서 dp[2]+p1이 가장 큰 경우에 dp[3]+p1과 같고, dp[2]+p1이 작으면 어짜피 dp[2]+p1+p1이 dp[3]+p1보다 작을 것이기 때문에 생각하지 않아도 된다.
		 *	  5개 살때 -> p5 vs. dp[4]+p1 vs. dp[3]+p2 vs. dp[2]+p3 vs. dp[1]+p4
		 *	  
		 *	  n개 살때 -> pn vs. dp[n-1]+p1 vs. dp[n-2]+p2 vs. ... vs. dp[1]+p(n-1)
		 * 9. 문제는 저 긴 애들을 어떻게 비교할 것인가임
		 * 10. 뒤에서부터 max를 사용하여 거꾸로 올라오자.
		 * 11. 일단 맨 뒤 두 개 비교 후 큰 값을 배열에 넣고, 그 다음 애와 배열에 담긴 값을 비교해주는 방식을 채택
		 * 12. 처음 두 값 비교 단계에서 배열 vs. 맨 뒤 값부터 비교하면 한 줄로 표현이 가능함
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] price = new int[n+1];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=1;i<=n;i++) {
			price[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+1]; // 최대값들
		
		dp[0] = 0;
		for(int i=1;i<=n; i++) {
			for(int j=1;j<=i;j++) {
				dp[i]=Math.max(dp[i],dp[i-j]+price[j]); //배열에 이미 들어있는 값과 비교해서 큰 값을 넣어줌@@@@ if문 쓰면 복잡하니까 이렇게 하자.
			}
		}
		
		bw.write(dp[n]+"\n");
		bw.flush();
	}

}
