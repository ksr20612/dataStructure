package 그리디BFSDFS0303;
import java.util.*;
import java.io.*;

public class Q7576 {

	/*
	 * 토마토(2차원)
	 *  - BFS접근
	 *  - 단, 시작점이 한개 이상일 수 있음(최초에 제공되는 익은 토마토가 여러 개일 수 있음)
	 *  - 따라서 시작점을 가지고 BFS에 들어가지 말고, for문을 전체적으로 돌려서 모든 좌표 중 그 값이 1 이상인 애를 찾아서 식을 시행시킴, visited 배열 만들기
	 *  ----- 라고 생각했으나, 그냥 시작점 모두를 queue에 먼저 담아주면 됨(내가 우려했던 건 한 쪽 시작점이 더 우세해지는 것이었는데, queue의 특성상 그 균형(순서)이 엎어질 경우는 없음)
	 *  - 지도 자체에 일자가 표시됨
	 *  - 조건 : 다 익을 수 없을 때 -1, 이미 다 익어있을 때 0
	 */
	
	static int n;
	static int m;
	static int[][] map;
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};	

	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void BFS() {
		
		boolean[][] visited = new boolean[m][n];
		Queue<Node> needVisit = new LinkedList<Node>();
		
		// 익은 토마토 찾기
		for(int i=0;i<=m-1;i++) {
			for(int j=0;j<=n-1;j++) {
				if(map[i][j]==1) {
					Node node = new Node(i,j);
					needVisit.add(node);
				}
			}
		}
		
		while(!needVisit.isEmpty()) {

			Node target = needVisit.poll();
			visited[target.x][target.y] = true;
	
			// 수행
			for(int k=0;k<=3;k++) {
				int nx = target.x + dx[k];
				int ny = target.y + dy[k];
							
				if(nx>=0&&nx<=m-1&&ny>=0&&ny<=n-1) {
					if(map[nx][ny]==0&&visited[nx][ny]==false) {
					
						visited[nx][ny] = true;
						map[nx][ny] = map[target.x][target.y] + 1;
						
						Node newNode = new Node(nx,ny);
						needVisit.add(newNode);
					}
				}
			}
		}
		
		// 모두는 익지 못한 경우(=0이 남아있는 경우) -> -1 출력
		int max = 0; // 최대값 찾기
		for(int i=0;i<=m-1;i++) {
			for(int j=0;j<=n-1;j++) {
				if(map[i][j]==0) {
					System.out.println(-1);
					return;
				}else if(map[i][j]>max){
					max = map[i][j];
				}
			}
		}
		System.out.println(max-1);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		
		// 모든 토마토가 익어있는 경우(하나라도 0이면 익을 수 있음)
		boolean canRipen = false;
		
		for(int i=0;i<=m-1;i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<=n-1;j++) {
				map[i][j] = Integer.parseInt(st1.nextToken());
				if(map[i][j]==0) canRipen = true;
			}
		}
		
		if(canRipen) {
			BFS();
		}else {
			System.out.println(0);
		}

		
	}

}
