package DFS;
import java.util.*;
import java.io.*;

public class Q11724 {

	/*
	 * 연결 요소의 개수
	 * - 연결 요소(연결된 노드 덩어리 = 단지)
	 */
	
	static int v;
	static int e;
	static int[][] map;
	static boolean[] visited;
	
	public static void dfs(int start) {
		
		for(int i=1;i<=v;i++) {
			if(visited[i] == false && map[start][i] == 1) {
				visited[i] = true;
				dfs(i);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		map = new int[v+1][v+1];
		visited = new boolean[v+1];
		
		for(int i=1;i<=e;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			map[start][end] = 1;
			map[end][start] = 1;
		}
		
		int cnt = 0;
		for(int i=1;i<=v;i++) {
			if(visited[i] == false) {
				dfs(i);
				cnt++; // 한 연결요소 검색 종료 시 카운트 증가
			}
		}
		
		System.out.println(cnt);
	}

}
