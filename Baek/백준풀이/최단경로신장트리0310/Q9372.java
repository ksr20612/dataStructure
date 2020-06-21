package 최단경로신장트리0310;
import java.util.*;
import java.io.*;

public class Q9372 {

	/*
	 * 상근이의 여행
	 *  - 연결 그래프 : 떨어진 노드가 없는 경우
	 *  - bsf로 풀려다가 복잡해지는 것 같아서 dsf로 풀기로 함
	 *  - 한 점에서 시작하는 dsf를 돌림(모든 점이 체크될때까지 돌림)
	 *  - 최소의 값을 결정하여 인출함
	 *  
	 *  - 착각했던 것 : 비행기 타는 횟수를 구하는 게 아니라 "종류"를 구하는 것이었음 (왕복으로 갔다와도 한 종류를 탄 것임...)
	 */
	
	static int cityN;
	static int planeN;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	static int cnt = 0;
	
	public static void DFS(int start) {
		
		for(int i=1;i<=cityN;i++) {
				
			if(i!=start) {
				if(map[start][i]!=0) {
					cnt++;
					DFS(i);
				}
			}
		}
			
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0;i<=t-1;i++) {
			
			StringTokenizer st;
			st = new StringTokenizer(br.readLine()," ");
		
			cityN = Integer.parseInt(st.nextToken());
			planeN = Integer.parseInt(st.nextToken());
			map = new int[cityN+1][cityN+1];
			
			for(int j=0;j<=planeN-1;j++) {
				st = new StringTokenizer(br.readLine()," ");
				int city1 = Integer.parseInt(st.nextToken());
				int city2 = Integer.parseInt(st.nextToken());
				
				map[city1][city2] = 1;
				map[city2][city1] = 1;
			}
			
			System.out.println(cityN-1);
			
		}
	}

}
