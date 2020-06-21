package 최단경로신장트리0310;
import java.util.*;
import java.io.*;

public class Q1865 {

	/*
	 * 웜홀(벨만 포드 알고리즘)
	 * 
	 * - 음수싸이클이 존재하냐????
	 * - 노드의 개수만큼 반복문을 돌리고, (모든 weight가 양수라면 (노드개수-1) 횟수까지는 갱신이 될 것임. 연결된 노드에 한해서는 갱신이 되어야 하기 때문에)
	 * - 만약 돌렸는데, 값이 또 갱신된다 (=> 음수싸이클이 존재한다)
	 */
	
	static class Node implements Comparable<Node>{
		int goal;
		int weight;
		Node(int goal, int weight){
			this.goal = goal;
			this.weight = weight;
		}
		@Override public int compareTo(Node n) { 
			return this.weight - n.weight; 
		}
	}
	
	static int n;
	static int m;
	static int w;
	static ArrayList<Node>[] list;
	static int[] route;
	static boolean isUpdate = false;
	
	public static void calculate() {
		
		PriorityQueue<Node> needVisit = new PriorityQueue<Node>();
		
		needVisit.add(new Node(1,0));
		
		int cyCnt = 0;
		while(!needVisit.isEmpty()){
			
			Node current = needVisit.poll();
			cyCnt++;
			
			if(current.weight>route[current.goal]) {
				continue;
			}
			
			for(int i=0;i<=list[current.goal].size()-1;i++) {
				
				// 하나 뽑기
				Node next = list[current.goal].get(i);
				
				if(route[current.goal]+next.weight<route[next.goal]) {
					route[next.goal] = route[current.goal]+next.weight;
					needVisit.add(next);
					// 갱신했는데... 이미 싸이클은 한 바퀴 돈 상태다????
					if(cyCnt>=n) {
						isUpdate = true;
						break;
					}
				}
			}
			
			if(isUpdate) break;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int i=0;i<=test-1;i++) {
			StringTokenizer st;
			st = new StringTokenizer(br.readLine()," ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			list = new ArrayList[n+1];
			route = new int[n+1];
			
			for(int j=1;j<=n;j++) {
				list[j] = new ArrayList<Node>();
				route[j] = 10000000;
			}
			route[1] = 0;
			
			// 일반 도로
			for(int j=0;j<=m-1;j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int node1 = Integer.parseInt(st.nextToken());
				int node2 = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				list[node1].add(new Node(node2,weight)); // 양방향이니까
				list[node2].add(new Node(node1,weight));
			}
			
			// 웜홀
			for(int j=0;j<=w-1;j++) {
				st = new StringTokenizer(br.readLine(), " ");
				int start = Integer.parseInt(st.nextToken());
				int goal = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				list[start].add(new Node(goal,-weight));
			}
			
			calculate();
			
			if(isUpdate) System.out.println("YES");
			else System.out.println("NO");
			
			// 초기화
			isUpdate = false;
		}
		
	}

}
