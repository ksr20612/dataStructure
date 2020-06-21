package 그리디BFSDFS0303;
import java.util.*;
import java.io.*;

public class Q2667 {

	/*
	 * 단지 번호 붙이기
	 *  - DFS로 확인(재귀호출로 상하좌우에 1이 있는지 확인)
	 */
	
	static int n;
	static int[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static boolean[][] visited;
	
	static int developmentN = 0; // 단지 개수
	static ArrayList<Integer> Nlist = new ArrayList();
	static int houseN = 0; // 단지 내 집의 개수 
	
	public static void DFS(int x, int y) {

		visited[x][y] = true; // 방문했다 표시
		
		for(int i=0;i<=3;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0&&nx<=n-1&&ny>=0&&ny<=n-1) { // map안쪽
				if(visited[nx][ny]==false&&map[nx][ny]==1) {
					houseN++;
					DFS(nx,ny);
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0;i<=n-1;i++) {
			String line = br.readLine();
			for(int j=0;j<=n-1;j++) {
				map[i][j] = Integer.parseInt(line.substring(j, j+1));
			}
		}
		
		for(int i=0;i<=n-1;i++) {
			for(int j=0;j<=n-1;j++) {
				if(map[i][j]==1&&visited[i][j]==false) {
					houseN++;
					DFS(i,j);
					
					// 한 단지가 결정된 시점
					developmentN++; // 단지 개수 올리고
					Nlist.add(houseN); // 담아주고(마지막에 단지 개수 출력하기 위해서)
					houseN = 0; //초기화
				}
			}
		}
		
		System.out.println(developmentN);
		
		Collections.sort(Nlist);
		for(int i=0;i<=Nlist.size()-1;i++) {
			System.out.println(Nlist.get(i));
		}
	}
}
