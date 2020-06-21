package DFS;
import java.util.*;
import java.io.*;

public class Q11403 {

	/*
	 * 경로 찾기
	 * - 가중치 없는 방향 그래프 G가 주어졌을 때, 모든 정점 (i, j)에 대해서, i에서 j로 가는 경로가 있는지 없는지 구하는 프로그램을 작성하시오.
	 * - 닿을 수 있는 모든 곳에 가자 => dfs 구현
	 * - 행 별로 생각하기
	 */
	
	static int n;
	static int[][] map;
	static boolean[] visited;
	
	public static void dfs(int start) {
		
		for(int i=1;i<=n;i++) {
			if(visited[i] == false && map[start][i] == 1) {
				visited[i] = true;
				dfs(i);
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		visited = new boolean[n+1];
		int ans[][] = new int[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j=1;j<=n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// dfs
		for(int i=1;i<=n;i++) {
			dfs(i);
			
			for(int j=1;j<=n;j++) {
				if(visited[j] == true) {
					ans[i][j] = 1;
				}
				
				visited[j] = false; // 초기화
			}
		}
		
		// 인출
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
