package 최단경로신장트리0310;
import java.util.*;
import java.io.*;

public class Q1197_Prim {

	static class Edge implements Comparable<Edge>{
		int start, end, weight;
		public Edge(int a, int b, int c) {
			this.start = a;
			this.end = b;
			this.weight = c;
		}
		@Override
		public int compareTo(Edge n) {
			return this.weight-n.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[v+1][v+1];
		
		for(int i=1;i<=e;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			map[start][end] = weight;
			map[end][start] = weight;
		}
		
		// Prim
		
		ArrayList<Integer> nodeConnected = new ArrayList<Integer>();
		PriorityQueue<Edge> candidate = new PriorityQueue<Edge>();
		
		int start = 1;
		nodeConnected.add(start);
		for(int i=1;i<=v;i++) {
			if(map[1][i]==0) continue;
			candidate.add(new Edge(1,i,map[1][i]));
		}
		
		int min = 0; // 최소 가중치
		while(!candidate.isEmpty()) {
			// 1. 가장 작은 간선 뽑아내기 
			Edge a = candidate.poll();
	
			if(!nodeConnected.contains(a.end)) {
				min += a.weight; // 더해주고
				// 후보군에 인접 간선 넣어주고(새로운 노드의 간선을 찾기)
				for(int i=1;i<=v;i++) {
					if(map[a.end][i]==0) continue;
					if(nodeConnected.contains(i)) continue; // 애초에 연결된 노드에 있으면 안 넣어준다
					candidate.add(new Edge(a.end,i,map[a.end][i]));
				}	
				// nodeConnected에 담아주고
				nodeConnected.add(a.end);
			}
		}
		
		System.out.println(min);
	}

}
