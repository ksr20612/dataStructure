package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q17837 {

	static int n;
	static int k;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		int[][] colorMap = new int[n+1][n+1];
		
		// 맵에 넣기
		for(int i=1;i<=n;i++) {
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			for(int j=1;j<=n;j++) {
				
				colorMap[i][j] = Integer.parseInt(st2.nextToken());
				
			}
		}
		
		// 체스 상황 정리하기
		
		
		// 개인톡에 있는 것 확인하기
		
	}

}
