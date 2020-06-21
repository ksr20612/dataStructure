package 최단경로신장트리0310;
import java.util.*;
import java.io.*;

public class Q4386 {

	/*
	 * 별자리 만들기
	 *  - mst문제인데, input 형식이 다름
	 *  - 그냥 input을 받아서 알고 있는 edge꼴로 바꿔주자
	 */
	
	static class Edge implements Comparable<Edge>{
		int star1, star2;
		double weight;
		public Edge(int node1, int node2, double weight) {
			this.star1 = node1;
			this.star2 = node2;
			this.weight = weight;
		}
		public int compareTo(Edge e) {
			return (int)this.weight-(int)e.weight;
		}
	}
	
	static class Star {
		double x,y;
		public Star(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static ArrayList<Edge> makeEdge(Star[] starList) {
		
		ArrayList<Edge> edgeList = new ArrayList<Edge>();
		
		// star 두 개 뽑아서 edge 만들기(조합)
		for(int i=1;i<=starList.length-2;i++) {
			for(int j=i+1;j<=starList.length-1;j++) {
				Star star1 = starList[i];
				Star star2 = starList[j];
				
				// 거리 구하기
				double 가로 = Math.abs(star1.x-star2.x);
				double 세로 = Math.abs(star1.y-star2.y);
				double weight = Math.sqrt(가로*가로 + 세로*세로);
				
				edgeList.add(new Edge(i,j,weight));
			}
		}
	
		return edgeList;
	}
	
	public static int find(int node) {
		
		if(rootList[node]!=node) {
			return rootList[node] = find(rootList[node]);
		}else return node;
	}
	
	static int[] rootList;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Star[] starList = new Star[n+1];
		rootList = new int[n+1];
		
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			double x = Float.parseFloat(st.nextToken());
			double y = Float.parseFloat(st.nextToken());
			starList[i] = new Star(x,y);
		}
		
		ArrayList<Edge> edgeList = makeEdge(starList);
		
		// 1. 초기화
		for(int i=1;i<=n;i++) {
			rootList[i] = i;
		}
		
		// 2. 정렬
		Collections.sort(edgeList);
		
		// 3. 연결
		double min = 0;
		for(int i=0;i<=edgeList.size()-1;i++) {
			
			int node1 = edgeList.get(i).star1;
			int node2 = edgeList.get(i).star2;
			double weight = edgeList.get(i).weight;
			
			if(find(node1)!=find(node2)) { // root가 같지 않다면 --> 붙여도 되니까 한 집합으로 만들어주자(root를 동일하게 바꾸기)
				rootList[find(node2)] = rootList[node1];
				min += weight;
			}
		}
		
		System.out.printf("%.2f\n", min);
		
	}

}
