package 최단경로신장트리0310;
import java.util.*;
import java.io.*;

public class Q1197 {

	/*
	 * 최소 신장 트리(기본)
	 * 1. 초기화
	 * 2. 정렬
	 * 3. 싸이클이 아닐때까지 연결해주기(union-find)
	 */
	
	static class Edge implements Comparable<Edge>{
		int node1, node2, weight;
		public Edge(int node1, int node2, int weight) {
			this.node1 = node1;
			this.node2 = node2;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			return this.weight-o.weight;
		}
	}
	
	static int v;
	static int e;
	static int[] rootList; // 어떤 특정 노드 i(배열의 index를 지칭)의 root가 무엇인가를 저장
	
	static int find(int num) {
		if(num != rootList[num])
			return rootList[num] = find(rootList[num]);
		else
			return num;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine()," ");
		
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		
		ArrayList<Edge> edgeList = new ArrayList<Edge>();
		rootList = new int[v+1];
		
		for(int i=0;i<=e-1;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList.add(new Edge(node1, node2, weight));
		}
		
		// 1. 초기화 (node의 root가 자기 자신을 가리키게끔 설정)
		for(int i=1;i<=v;i++) {
			rootList[i] = i;
		}
		
		// 2. 정렬(weight 오름차순 정렬)
		Collections.sort(edgeList);
		
		// 3. 연결하기
		long min = 0;
		for(int i=0;i<=e-1;i++) {
			int node1 = edgeList.get(i).node1;
			int node2 = edgeList.get(i).node2;
			int weight = edgeList.get(i).weight;
			
			if(find(node2)!=find(node1)) {
				//root를 동일하게 만들어준다(=같은 집합 내에 속하게 만들어준다)
				rootList[find(node2)] = rootList[node1];
				min += weight;
			}
		}
		
		System.out.println(min);
		
	}

}
