package DFS;
import java.util.*;
import java.io.*;

public class Q2583 {

	/*
	 * 영역 구하기
	 *  - 그냥 직사각형 얹혀 놓고, 단지 수와 단지 내 아파트 수 구하기
	 */
	
	static int m; //세로
	static int n; //가로
	static int k; //사각형 개수
	static int[][] map;
	static boolean[][] visited;
	static ArrayList<Integer> list = new ArrayList<Integer>(); //빈 영역 담기
	static int sqrNum = 1;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	public static void dfs(int x, int y) {
		
		visited[x][y] = true;
		for(int i=0;i<=3;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=1 && nx<=n && ny>=1 && ny<=m) {
				if(visited[nx][ny] == false && map[nx][ny] == 0) {
					dfs(nx,ny);
					sqrNum++;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringTokenizer st;
		 st = new StringTokenizer(br.readLine(), " ");
		 m = Integer.parseInt(st.nextToken());
		 n = Integer.parseInt(st.nextToken());
		 k = Integer.parseInt(st.nextToken());
		 map = new int[n+1][m+1];
		 visited = new boolean[n+1][m+1];
		 
		 for(int p=1;p<=k;p++) {
			 st = new StringTokenizer(br.readLine()," ");
			 int x1 = Integer.parseInt(st.nextToken());
			 int y1 = Integer.parseInt(st.nextToken());
			 int x2 = Integer.parseInt(st.nextToken());
			 int y2 = Integer.parseInt(st.nextToken());
			 
			 for(int i=x1+1;i<=x2;i++) {
				 for(int j=y1+1;j<=y2;j++) {
					 map[i][j] = 1;
				 }
			 }
		 }
		 
		 for(int i=1;i<=n;i++) {
			 for(int j=1;j<=m;j++) {
				 if(visited[i][j]==false && map[i][j] == 0) {
					 dfs(i,j);
					 
					 list.add(sqrNum);
					 sqrNum = 1; //초기화
				 }
			 }
		 }
		 
		 Collections.sort(list);
		 System.out.println(list.size());
		 for(int i=0;i<=list.size()-1;i++) {
			 System.out.print(list.get(i)+" ");
		 }
		 
	}

}
