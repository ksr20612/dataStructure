package DFS;
import java.util.*;
import java.io.*;

public class Q10026 {

	/*
	 * 적녹색약
	 *  - 정상인의 dfs / 색약자의 dfs 따로 만들기
	 *  - 색약자의 경우 dfs 재귀 호출의 조건문 조정하기(r,g <-> b 경우 분리)
	 */
	
	static int n;
	static String[][] map;
	static boolean[][] visitedNormal;
	static boolean[][] visitedBlind;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void dfsNormal(int x, int y) {
		
		visitedNormal[x][y] = true;
		for(int i=0;i<=3;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=1 && nx<=n && ny>=1 && ny<=n) {
				if(visitedNormal[nx][ny]==false && map[x][y].equals(map[nx][ny])) {
					dfsNormal(nx,ny);
				}
			}
		}
	}
	
	public static void dfsBlind(int x, int y) {

		visitedBlind[x][y] = true;
		for(int i=0;i<=3;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=1 && nx<=n && ny>=1 && ny<=n) {
				if(map[x][y].equals("G") || map[x][y].equals("R")) { 
					if(visitedBlind[nx][ny]==false) {
						if(map[nx][ny].equals("G") || map[nx][ny].equals("R")) {
							dfsBlind(nx,ny);
						}
					}
				}else
					if(visitedBlind[nx][ny]==false && map[x][y].equals(map[nx][ny])) {
						dfsBlind(nx,ny);
					}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new String[n+1][n+1];
		visitedNormal = new boolean[n+1][n+1];
		visitedBlind = new boolean[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			String[] list = br.readLine().split("");
			for(int j=1;j<=n;j++) {
				map[i][j] = list[j-1];
			}
		}
		
		// 정상인
		int normal = 0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(visitedNormal[i][j] == false) {
					dfsNormal(i,j);
					normal++;
				}
			}
		}
		
		// 적녹색약자
		int blind = 0;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(visitedBlind[i][j] == false) {
					dfsBlind(i,j);
					blind++;
				}
			}
		}
		
		System.out.println(normal+" "+blind);
	}

}
