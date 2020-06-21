package 그리디BFSDFS0303;
import java.util.*;
import java.io.*;

public class Q1012 {

	/*
	 * 유기농 배추
	 *  - 결국에 단지수 구하는 2667문제와 동일.
	 *  - DFS로 풀자.
	 */
	
	static int width;
	static int length;
	static int[][] map;
	static boolean[][] visited;
	static int count=0;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	
	public static void DFS(int x, int y) {
		
		visited[x][y] = true;
		
		for(int i=0;i<=3;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0&&nx<=width-1&&ny>=0&&ny<=length-1) {
				if(visited[nx][ny]==false&&map[nx][ny]==1) {
					DFS(nx,ny);
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testN = Integer.parseInt(br.readLine());
		
		for(int i=0;i<testN;i++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			width = Integer.parseInt(st.nextToken()); //가로
			length = Integer.parseInt(st.nextToken()); //세로
			int baeN = Integer.parseInt(st.nextToken());
			
			map = new int[width][width];
			visited = new boolean[width][width];
			
			for(int j=0;j<=baeN-1;j++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
				map[Integer.parseInt(st1.nextToken())][Integer.parseInt(st1.nextToken())] = 1;
			}
			
			for(int x=0;x<=width-1;x++) {
				for(int y=0;y<=width-1;y++) {
					if(map[x][y]==1&&visited[x][y]==false) {
						DFS(x,y);
						
						//한 배추더미 끝난 시점
						count++;
					}
				}
			}
			
			System.out.println(count);
			count = 0; // 초기화
		}
		
	}

}
