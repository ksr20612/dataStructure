package 그리디BFSDFS0303;
import java.util.*;
import java.io.*;

public class Q1697 {
	
	/*
	 * 숨바꼭질
	 *  - 이동하는 경우의 수가 3개(+1,-1,*2)
	 *  - 주의 : -1로 이동하는 경우가 있으므로 도로의 길이는 goal+2로 만들어줄것.
	 */
	
	static int[] move = {1,-1,2};
	
	public static void BFS(int start,int goal) {
		
		int[] street = new int[goal+2];
		Queue<Integer> needVisit = new LinkedList<Integer>();
		boolean[] visited = new boolean[goal+2];
		
		needVisit.add(start);
		
		while(!needVisit.isEmpty()) {
			
			int target = needVisit.poll();
			visited[start] = true;
			
			for(int i=0;i<=2;i++) {
				int nx;
				if(i==2) nx = target * move[i];
				else nx = target + move[i];
				
				if(nx>=0&&nx<=goal+1) {
					if(street[nx]==0&&visited[nx]==false) {
						street[nx] = street[target] + 1;
						needVisit.add(nx);
					}
				}
			}
		}
		System.out.println(street[goal]);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int me = sc.nextInt();
		int sis = sc.nextInt();
		
		BFS(me,sis);
		
	}

}
