package DFS;
import java.util.*;
import java.io.*;

public class Q2573 {

	/*
	 * 빙산
	 * 1. map
	 * 2. 녹이기
	 * 3. 덩어리 개수 세기
	 * 4. dfs
	 */
	
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static int iceNum() {
		
		int cnt = 0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(map[i][j]!=0 && visited[i][j]==false) {
					dfs(i,j);
					cnt++;
				}
			}
		}
		
		// visited 초기화 <=== 까먹음
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				visited[i][j] = false;
			}
		}
		
		return cnt;
	}
	
	public static void dfs(int x, int y) {
		
		visited[x][y] = true;
		for(int i=0;i<=3;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=1 && nx<=n && ny>=1 && ny<=m) {
				if(visited[nx][ny]==false && map[nx][ny]!=0) {
					dfs(nx,ny);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][m+1];
		visited = new boolean[n+1][m+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=m;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 녹이기
		int year = 0;
		while(iceNum()<2) {
			for(int i=1;i<=n;i++) {
				for(int j=1;j<=m;j++) {
					if(map[i][j]==0) continue;
					for(int k=0;k<=3;k++) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if(nx>=1 && nx<=n && ny>=1 && ny<=m) {
							if(map[nx][ny]==0) map[i][j]--;
						}
					}
				}
			}
			year++;
		}
		
		System.out.println(year);
	}

}
