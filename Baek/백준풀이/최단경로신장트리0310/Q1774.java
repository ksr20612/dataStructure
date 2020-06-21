package 최단경로신장트리0310;
import java.util.*;
import java.io.*;

public class Q1774 {

	/*
	 * 우주신과의 교감
	 * 1. 입력받기
	 * 2. 간선 구하기
	 * 3. 초기화
	 * 4. 정렬
	 * 5. 연결
	 *  - 단, 미리 연결된 간선이 존재.
	 *  -> 초기화 단계에서 두 점이 애초에 이어져 있도록 설정
	 */
	
	static class God{
		int x, y;
		public God(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Dist implements Comparable<Dist>{
		int start, goal;
		float dist;
		public Dist(int start, int goal, float dist) {
			this.start = start;
			this.goal = goal;
			this.dist = dist;
		}
		public int compareTo(Dist n) {
			if(this.dist>n.dist) {
				return 1;
			}else if(this.dist<n.dist) {
				return -1;
			}else return 0;
		}
	}
	
	public static ArrayList<Dist> makeDist(God[] godList, int n){
		
		ArrayList<Dist> dist = new ArrayList<Dist>();
		
		for(int i=1;i<=n-1;i++) {
			for(int j=i+1;j<=n;j++) {
				dist.add(new Dist(i,j,calculateDist(godList[i],godList[j])));
			}
		}	
		
		return dist;
	}
	
	public static float calculateDist(God g1, God g2) {
		
		int x = Math.abs(g1.x-g2.x);
		int y = Math.abs(g1.y-g2.y);
		
		return (float)Math.sqrt(x*x+y*y);
	}
	
	public static int find(int a) {
		
		if(rootList[a]==a) return a;
		else return find(rootList[a]);
		
	}
	
	static int[] rootList;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken()); // 우주신
		int m = Integer.parseInt(st.nextToken()); // 이미 연결된 통로 개수
		
		God[] godList = new God[n+1];
		
		for(int i=1;i<=n;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			godList[i] = new God(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		}
		
		// 1. 거리 구하기
		ArrayList<Dist> distList = makeDist(godList, n);
		
		// 2. 초기화 -> 이미 연결된 애는 같은 부분집합으로 표시(앞의 것으로 표시)
		rootList = new int[n+1];
		for(int i=1;i<=n;i++) {
			rootList[i] = i;
		}
		
		for(int i=1;i<=m;i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 유니온
			if(a<b) rootList[b] = a;
			else rootList[a] = b;
		}
		
		// 3. 정렬
		Collections.sort(distList);
		
		// 4. 연결
		float min = 0;
		for(int i=0;i<=n-1;i++) {
			int start = distList.get(i).start;
			int goal = distList.get(i).goal;
			float dist = distList.get(i).dist;
			
			if(find(start)!=find(goal)) { // 작은 숫자가 부분 집합 이름
				int a = find(start);
				int b = find(goal);
				if(a<b) rootList[b] = a;
				else rootList[a] = b;
				
				min += dist;
			}
		}
		
		System.out.printf("%.2f\n", min);
	}

}
