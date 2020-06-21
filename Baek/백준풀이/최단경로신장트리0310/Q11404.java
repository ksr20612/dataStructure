package 최단경로신장트리0310;
import java.util.*;
import java.io.*;

public class Q11404 {

	/*
	 * 플로이드
	 * 
	 * - 다익스트라와 다른점 : 얘는 출발점이 한 개가 아니다
	 * - 그냥 start를 다르게 해서 반복문을 노드의 개수만큼 추가하면 될듯...? (기존 다익스트라 알고리즘에 for문 한 번 더 씌우기)
	 * - 위 방식은 그냥 노가다... 구글링해서 코드 찾음
	 */
	
	static int cityN;
	static int busN;
	static int[][] map;
	
	public static void calculate() {
		
		for(int i=1;i<=cityN;i++) { // 경유지 i
			for(int j=1;j<=cityN;j++) { // 출발점 j
				for(int k=1;k<=cityN;k++) { // 도착점 k
					if(map[j][i]==Integer.MAX_VALUE || map[i][k]==Integer.MAX_VALUE) continue;
					if(map[j][i]+map[i][k]<map[j][k]) {
						map[j][k] = map[j][i]+map[i][k];
					}
				}
			}
		}
		
		for(int i=1;i<=cityN;i++) {
			for(int j=1;j<=cityN;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		cityN = Integer.parseInt(br.readLine());
		busN = Integer.parseInt(br.readLine());
		map = new int[cityN+1][cityN+1];
		
		for(int i=1;i<=cityN;i++) {
			for(int j=1;j<=cityN;j++) {
				if(i!=j) map[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i=1;i<=busN;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int city1 = Integer.parseInt(st.nextToken());
			int city2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			if(map[city1][city2]>cost) map[city1][city2] = cost; // 새로 받은 애가 작은 경우에만 넣어주기
		}
		
		calculate();
	}
}
