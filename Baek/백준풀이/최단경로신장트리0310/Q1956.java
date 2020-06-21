package 최단경로신장트리0310;
import java.util.*;
import java.io.*;

public class Q1956 {

	/*
	 * 운동
	 * 
	 *  - 플로이드 워셜로 모든 한 점에서 한 점까지 가는 최소경로를 구한 다음
	 *  - 반대로 그 지점에서 원점으로 가는 최소경로를 더해준다
	 *  - ex1) (1 -> 2) + (2 -> 1) 
	 *  - ex2) (3 -> 1) + (1 -> 3)
	 *  - 이 방식으로 계산한 모든 쌍들 중 최소값을 인출해준다
	 */
	
	static int cityN;
	static int roadN;
	static int[][] map;
	
	public static void calculate() {
		
		for(int i=1;i<=cityN;i++) {
			for(int j=1;j<=cityN;j++) {
				for(int k=1;k<=cityN;k++) {
					if(map[j][i]!=Integer.MAX_VALUE && map[i][k]!=Integer.MAX_VALUE) {
						if(map[j][k]>map[j][i]+map[i][k]) {
							map[j][k] = map[j][i]+map[i][k];
						}
					}
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=1;i<=cityN;i++) {
			for(int j=1;j<=cityN;j++) {
				if(i==j) continue;
				if(map[i][j]==Integer.MAX_VALUE || map[j][i]==Integer.MAX_VALUE) continue;
				if(min>map[i][j]+map[j][i]) min = map[i][j]+map[j][i];
			}
		}
		
		if(min==Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(min);
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine(), " ");
		
		cityN = Integer.parseInt(st.nextToken());
		roadN = Integer.parseInt(st.nextToken());
		map = new int[cityN+1][cityN+1];
		
		for(int i=1;i<=cityN;i++) {
			for(int j=1;j<=cityN;j++) {
				map[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i=1;i<=roadN;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());
			map[start][end] = time;
		}
		
		calculate();
		
	}

}
