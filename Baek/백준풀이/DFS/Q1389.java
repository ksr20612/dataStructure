package DFS;
import java.util.*;
import java.io.*;

public class Q1389 {

	/*
	 * 케빈 베이컨의 6단계 법칙
	 * 플로이드 워셜 알고리즘에서 주의할 것 : 무한대로 초기화하기
	 */
	
	static int n;
	static int m;
	
	public static void floid(int[][] map) {
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				for(int k=1;k<=n;k++) {
					if(map[j][i]!=Integer.MAX_VALUE && map[i][k]!=Integer.MAX_VALUE) {
						if(map[j][k]>map[j][i]+map[i][k]) {
							map[j][k] = map[j][i]+map[i][k];
						}
					}
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		int sum = 0;
		int ans = 0; // 어떤 애?
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				sum+=map[i][j];
			}
			if(sum<min) {
				min = sum;
				ans = i;
			}
			sum = 0; //초기화
		}
		System.out.println(ans);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				map[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i=1;i<=m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
			map[b][a] = 1;
		}
		
		floid(map);
		
	}

}
