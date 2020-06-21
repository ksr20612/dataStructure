package 최단경로신장트리0310;
import java.util.*;
import java.io.*;

public class Q1753 {

	/*
	 * 최단경로(다익스트라 알고리즘)
	 * 
	 * - bfs의 응용(간선마다 weight가 있다는 차이점)
	 * - int[][] map 만들고, 두 노드를 잇는 점에 weight를 넣는다
	 * - bfs를 돌리면서 최소 경로가 발견될 때마다 그 점의 값을 갱신한다
	 * - 갱신되는 값의 위치는 (i,i) (얘는 start 노드에서 i 노드까지 가는 최소 경로를 의미)
	 */
	
	static int v;
	static int e;
	static int[][] map;
	
	public static void BFS(int start) {
		
		Queue<Integer> needVisit = new LinkedList<Integer>();
		needVisit.add(start);

		while(!needVisit.isEmpty()) {
			
			int node = needVisit.poll(); //시작
			
			// 시작 노드와 이어진 노드 찾기(본인이 아니고, 다시 start로 가는 node가 아니고, 0이 아닌 weight가 담겨있는 노드)
			for(int i=1;i<=v;i++) {
				if(i!=node&&map[node][i]!=0&&i!=start) {
					int weight = map[node][i]; 
					if(!needVisit.contains(i)) needVisit.add(i); // 이미 needVisit에 들어있으면 넣지 말자
					
					// 갱신하기 
					if(map[i][i]==0) { // 한번도 방문을 안한 경우
						map[i][i] = map[node][node] + weight;
					}else { // 방문을 한 경우
						if(map[node][node]+weight<map[i][i]) { // 최소 경로일때만
							map[i][i] = map[node][node] + weight;
						}
					}
				}
			}
		}	
		
		// 출력
		for(int i=1;i<=v;i++) {
			if(i!=start&&map[i][i]==0) System.out.println("INF");
			else System.out.println(map[i][i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		int start = Integer.parseInt(br.readLine());
		
		map = new int[v+1][v+1];
		
		for(int i=0;i<=e-1;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			map[node1][node2] = Integer.parseInt(st.nextToken());
		}
		
		BFS(start);
		
	}

}
