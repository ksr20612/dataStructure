package 최단경로신장트리0310;
import java.util.*;
import java.io.*;

public class Q2887 {

	/*
	 * 행성 터널
	 *  - 계산해야하는 간선의 개수를 줄이자
	 *  - 최소신장트리는 일종의 그리디 알고리즘. 가장 길이가 작은 애부터 고른다(=걔보다 큰 애는 나중에 고려한다)
	 *  - 한 행성 a에서 b까지의 거리는 x1-x2 / y1-y2 / z1-z2 중 가장 작은 값.
	 *  - a(-11,-15,-15) / b(14,-5,-15) / c(-1,-1,-5) / d(10,-4,-1) / e(19,-4,19) 의 행성이 있다.
	 *  - x축 y축 z축으로 각각 정렬하여 인접한 간선들만을 고려한다.
	 */
	
	static class Planet{
		int idx;
		int x, y, z;
		public Planet(int idx, int x, int y, int z) {
			this.idx = idx;
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	static class Tunnel implements Comparable<Tunnel>{
		int planet1, planet2, dist;
		public Tunnel(int a, int b, int c) {
			this.planet1 = a;
			this.planet2 = b;
			this.dist = c;
		}
		
		public int compareTo(Tunnel t) {
			if(this.dist > t.dist) return 1;
			else if(this.dist < t.dist) return -1;
			else return 0;
		}
	}
	
	static int[] rootList;
	
	public static int find(int a) {
		
		if(rootList[a]==a) return a;
		else return find(rootList[a]);
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Planet> planetList = new ArrayList();
		ArrayList<Tunnel> tunnelList = new ArrayList();
		
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			planetList.add(new Planet(i,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
		}
		
		// x축으로 정렬
		Collections.sort(planetList, new Comparator<Planet>() {
            @Override
            public int compare(Planet a, Planet b) {
                if (a.x < b.x) {
                    return -1;
                } else if (a.x > b.x) {
                    return 1;
                } else return 0;
            }
		});
		
		for(int i=0;i<=planetList.size()-2;i++) {
			Planet planet1 = planetList.get(i);
			Planet planet2 = planetList.get(i+1);
			tunnelList.add(new Tunnel(planet1.idx,planet2.idx,Math.abs(planet1.x-planet2.x)));
		}
		
		// y축으로 정렬
		Collections.sort(planetList, new Comparator<Planet>() {
			
			public int compare(Planet a, Planet b) {
				if(a.y < b.y) return -1;
				else if(a.y > b.y) return 1;
				else return 0;
			}
		});
		
		for(int i=0;i<=planetList.size()-2;i++) {
			tunnelList.add(new Tunnel(planetList.get(i).idx,planetList.get(i+1).idx,Math.abs(planetList.get(i).y-planetList.get(i+1).y)));
		}
		
		// z축으로 정렬
		Collections.sort(planetList, new Comparator<Planet>() {
			
			public int compare(Planet a, Planet b) {
				if(a.z < b.z) return -1;
				else if(a.z > b.z) return 1;
				else return 0;
			}
		});
		
		for(int i=0;i<=planetList.size()-2;i++) {
			tunnelList.add(new Tunnel(planetList.get(i).idx,planetList.get(i+1).idx,Math.abs(planetList.get(i).z-planetList.get(i+1).z)));
		}
		
		////////// mst
		// 1. 초기화
		rootList = new int[n+1];
		for(int i=1;i<=n;i++) {
			rootList[i] = i;
		}
		
		// 2. 정렬
		Collections.sort(tunnelList);
		
		// 3. 연결
		int min = 0;
		for(int i=0;i<=tunnelList.size()-1;i++) {
			int planet1 = tunnelList.get(i).planet1;
			int planet2 = tunnelList.get(i).planet2;
			int dist = tunnelList.get(i).dist;
			
			int a = find(planet1);
			int b = find(planet2);
			if(a!=b) {
				if(a<b) rootList[b] = rootList[a];
				else rootList[a] = rootList[b];
				min += dist;
			}
		}
		System.out.println(min);
		
	}

}
