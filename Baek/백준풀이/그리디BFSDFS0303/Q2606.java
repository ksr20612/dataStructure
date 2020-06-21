package 그리디BFSDFS0303;
import java.util.*;
import java.io.*;

public class Q2606 {

	/*
	 * 바이러스(웜바이러스)
	 * 그냥 dfs나 bfs 하나 선택해서 개수 세기
	 *  - 난 dfs 선택함(재귀로 구현할 수 있어 편리함)
	 */
	
	static int nodeN;
	static int edgeN;
	static int[][] arr;
	static boolean[] visited;
	static int count = 0;
	
	public static void DFS(int idx) {
		
		for(int i=1;i<=nodeN;i++) {
			if(arr[idx][i]==1 && visited[i]==false) {
				count++;
				visited[i] = true;
				DFS(i);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		nodeN = sc.nextInt();
		edgeN = sc.nextInt();
		arr = new int[nodeN+1][nodeN+1];
		visited = new boolean[nodeN+1];
		
		for(int i=0;i<=edgeN-1;i++) {
			int node1 = sc.nextInt();
			int node2 = sc.nextInt();
			arr[node1][node2] = 1;
			arr[node2][node1] = 1;
		}
		
		visited[1] = true;
		DFS(1);
		System.out.println(count);
	}

}
