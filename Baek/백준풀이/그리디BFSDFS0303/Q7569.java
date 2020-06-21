package 그리디BFSDFS0303;
import java.util.*;
import java.io.*;

public class Q7569 {

	/*
	 * 토마토(3차원)
	 *  - dx,dy,dz 3차원으로 표현 
	 */
	
	static class Node{
		int x;
		int y;
		int z;
		Node(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	static int n;
	static int m;
	static int h;
	static int[][][] cube;
	static int[] dx = {0,0,0,0,1,-1};
	static int[] dy = {0,0,1,-1,0,0};
	static int[] dz = {1,-1,0,0,0,0};
	
	public static void BFS() {
		
		Queue<Node> needVisit = new LinkedList<Node>();
		boolean[][][] visited = new boolean[m][n][h];
		
		// 토마토 위치 확인
		for(int i=0;i<=h-1;i++) {
			for(int j=0;j<=n-1;j++) {
				for(int k=0;k<=m-1;k++) {
					if(cube[k][j][i]==1) {
						Node node = new Node(k,j,i);
						needVisit.add(node);
					}
				}
			}
		}
		
		// 반복문 실행
		while(!needVisit.isEmpty()) {
			
			Node target = needVisit.poll();
			visited[target.x][target.y][target.z] = true;
			
			for(int i=0;i<=5;i++) {
				int nx = target.x + dx[i];
				int ny = target.y + dy[i];
				int nz = target.z + dz[i];
				
				if(nx>=0&&nx<=m-1&&ny>=0&&ny<=n-1&&nz>=0&&nz<=h-1) {
					if(cube[nx][ny][nz]==0&&visited[nx][ny][nz]==false) {
						Node newNode = new Node(nx,ny,nz);
						needVisit.add(newNode);
						visited[nx][ny][nz] = true;
						cube[nx][ny][nz] = cube[target.x][target.y][target.z] + 1;
					}
				}
			}
		}
		
		int max = 0;
		for(int i=0;i<=h-1;i++) {
			for(int j=0;j<=n-1;j++) {
				for(int k=0;k<=m-1;k++) {
					if(cube[k][j][i]==0) {
						System.out.println(-1);
						return;
					}else if(cube[k][j][i]>max) max = cube[k][j][i];
				}
			}
		}
		System.out.println(max-1);
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		
		m = Integer.parseInt(st.nextToken()); //가로
		n = Integer.parseInt(st.nextToken()); //세로
		h = Integer.parseInt(st.nextToken()); //높이
		cube = new int[m][n][h];
		
		boolean canRipen = false;
		for(int i=0;i<=h-1;i++) {
			for(int j=0;j<=n-1;j++) {
				st = new StringTokenizer(br.readLine()," ");
				for(int k=0;k<=m-1;k++) {
					cube[k][j][i] = Integer.parseInt(st.nextToken());
					if(cube[k][j][i]==0) canRipen = true;
				}
			}
		}
		
		if(canRipen) {
			BFS();
		}else {
			System.out.println(0);
		}
	}

}
