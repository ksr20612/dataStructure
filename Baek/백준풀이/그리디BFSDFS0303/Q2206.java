package 그리디BFSDFS0303;
import java.util.*;
import java.io.*;

public class Q2206 {

	/*
	 * 벽 부수고 이동하기
	 *  - BFS
	 *  - 특이한 조건 : 벽을 1회 부술 수 있다.
	 *  
	 *  시도1
	 *  --> 벽 안 부수고 하기 + 벽 한 개씩 부수고 하기(문을 한 개 선택해서 없애고 bfs돌리기)
	 *  --> 더 최소값인 애를 인출
	 *  --> 시간초과 @@@@@@@
	 *  
	 *  시도2
	 *  --> 동일한 temp map을 만들어주고 
	 */
	
	static int n;
	static int m;
	static int[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int min = -2; // 골인지점에 올 수 있는 최소값 : 왜 -2? 결과값에는 +1 해줄 것임(시작+끝칸 세야함), 근데 도달 못하는 경우 -1을 출력해야하므로
	
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void BFS() {
		
		Queue<Node> needVisit = new LinkedList<Node>();
		boolean[][] visited = new boolean[n][m];
		
		Node node = new Node(0,0);
		needVisit.add(node);
		
		while(!needVisit.isEmpty()) {
			
			Node target = needVisit.poll();
			visited[target.x][target.y] = true;
			
			for(int i=0;i<=3;i++) {
				int nx = target.x + dx[i];
				int ny = target.y + dy[i];
				
				if(nx>=0&&nx<=n-1&&ny>=0&&ny<=m-1) {
					if(map[nx][ny]==0&&visited[nx][ny]==false) {
						map[nx][ny] = map[target.x][target.y] + 1;
						Node newNode = new Node(nx,ny);
						needVisit.add(newNode);
					}
				}
			}
		}
		
		// 교체하기
		if(map[n-1][m-1]!=0&&map[n-1][m-1]>min) {
			min = map[n-1][m-1];
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		for(int i=0;i<=n-1;i++) {
			String line = br.readLine();
			for(int j=0;j<=m-1;j++) {
				map[i][j] = Integer.parseInt(line.substring(j,j+1));
			}
		}
		
		// 그냥 돌리기
		BFS();
		
		// 벽 부수고 돌리기
		for(int i=0;i<=n-1;i++) {
			for(int j=0;j<=m-1;j++) {
				if(map[i][j]==1) {
					map[i][j] = 0; //부수기
					BFS(); //돌리기
					map[i][j] = 1; //초기화하기
				}
			}
		}
		
		System.out.println(min+1);
	}

}
