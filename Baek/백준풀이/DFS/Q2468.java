package DFS;
import java.util.*;
import java.io.*;

public class Q2468 {

	/*
	 * 안전 영역
	 * - 연구소 문제(q14502)와 비슷
	 */
	
	static int n;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void dfs(int[][] temp, int x, int y) {
		
		visited[x][y] = true;
		for(int i=0;i<=3;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=1 && nx<=n && ny>=1 && ny<=n) {
				if(visited[nx][ny] == false && temp[nx][ny] == 0) {
					dfs(temp, nx, ny);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		visited = new boolean[n+1][n+1];
		
		// 1. 인풋
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=n;j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a<min) min = a;
				if(a>max) max = a;
				map[i][j] = a;
			}
		}
		
		// 2. 사전 작업
		int[][] temp = new int[n+1][n+1];
		int maxAreaNum = 1; // 아무 지역도 안 잠기는 경우에는 최소 한 개
		for(int prec=min;prec<=max;prec++) {
			
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(map[i][j]<=prec) temp[i][j] = 1; //강수량보다 낮은 지대는 잠김(1)
				}
			}
			
			int cnt = 0;
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					if(visited[i][j] == false && temp[i][j] == 0) {
						dfs(temp, i, j);
						cnt++;
					}
				}
			}
			
			if(cnt>maxAreaNum) maxAreaNum = cnt;
			
			// visited 초기화 --> 최초 시도에 깜빡함
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=n;j++) {
					visited[i][j] = false;
				}
			}
		}
		
		System.out.println(maxAreaNum);
	}

}
