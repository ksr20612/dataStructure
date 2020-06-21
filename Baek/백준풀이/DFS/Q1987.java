package DFS;
import java.util.*;
import java.io.*;

public class Q1987 {

	/* 
	 * 알파벳
	 * - dfs를 재귀 호출하는 조건을 조정해야함(이미 지나온 알파벳이 아닌 경우에만 가자)
	 */
	
	static int r;
	static int c;
	static String[][] map;
	static ArrayList<String> visited = new ArrayList<String>();
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int cnt = 1;
	
	public static void dfs(int x, int y) {
		
		visited.add(map[x][y]);
		for(int i=0;i<=3;i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(nx>=1 && nx<=r && ny>=1 && ny<=c) {
				if(!visited.contains(map[nx][ny])) {
					dfs(nx,ny);
					cnt++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new String[r+1][c+1];
		
		for(int i=1;i<=r;i++) {
			String[] list = br.readLine().split("");
			for(int j=1;j<=c;j++) {
				map[i][j] = list[j-1];
			}	
		}
		
		dfs(1,1);
		System.out.println(cnt);
		
	}

}
