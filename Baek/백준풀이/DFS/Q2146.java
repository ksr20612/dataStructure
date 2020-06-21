package DFS;
import java.util.*;
import java.io.*;

public class Q2146 {

	/*
	 * 다리 만들기
	 *  배운 것 : bfs의 시작점이 여러 개인 경우 ===> 일단 queue에 해당 점을 모두 넣고 안에 queue의 크기만큼 for문 돌리기 (이런 방식으로도 할 수 있다...)
	 *         꼭 map 자체에 최소경로를 입력해줄 필요는 없다 -> 전달하는 노드에 달고 다닐 수도, 따로 변수를 지정할 수도 있다
	 */
	
	static int n;
	static int[][] map;
	static int[][] con; // 대륙에 구분 숫자 매겨준 지도
	static boolean[][] visited;
	
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	
	static class Node {
		int x, y;
		int dist;
		public Node(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	public static void dfs(int x, int y, int conIdx) {
		
		visited[x][y] = true;
		con[x][y] = conIdx;
		for(int i=0;i<=3;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=1 && nx<=n && ny>=1 && ny<=n) {
				if(visited[nx][ny]==false && map[nx][ny]==1) {
					dfs(nx,ny,conIdx);
				}
			}
		}
	}
	
	public static int bfs(int conIdx) {
		
		Queue<Node> needVisit = new LinkedList<Node>();
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(con[i][j]==conIdx) needVisit.add(new Node(i,j,0));
			}
		}
		
		while(!needVisit.isEmpty()) {
			
			Node target = needVisit.poll();
			visited[target.x][target.y] = true; 
			
			for(int i=0;i<=3;i++) {
				int nx = target.x + dx[i];
				int ny = target.y + dy[i];
				
				if(nx>=1 && nx<=n && ny>=1 && ny<=n) {
					if(map[nx][ny]==0 && visited[nx][ny]==false) {
						needVisit.add(new Node(nx,ny,target.dist+1)); 
					}else if(con[nx][ny]!=0 && con[nx][ny]!=conIdx) {
						return target.dist; 
					}
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		con = new int[n+1][n+1];
		visited = new boolean[n+1][n+1];
		
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=n;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 대륙에 번호 매기기(dfs)
		int conIdx = 1;
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				if(map[i][j]==1 && visited[i][j]==false) {
					dfs(i,j,conIdx);
					conIdx++;
				}
			}
		}
		
		int[][] temp2 = con;
		
		// 대륙 확장시키기(bfs)
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=conIdx-1;i++) {
			int cnt = bfs(i);
			if(cnt<min) min = cnt;
			
			// visited 초기화
			for(int k=1;k<=n;k++) {
				for(int j=1;j<=n;j++) {
					visited[k][j] = false;
				}
			}
		}

		System.out.println(min);
	}

}
