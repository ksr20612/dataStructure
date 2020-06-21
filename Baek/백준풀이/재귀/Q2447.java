package 재귀;

import java.util.Scanner;

public class Q2447 {
	
	static String[][] map;
	
	static void draw(int n, int a, int b) {
		
		if(n==1) {
			map[a][b] = "*";
			return;
		}
		else {
			int m = n/3;
			for(int i=0;i<=2;i++) {
				for(int j=0;j<=2;j++) {
					if(i==1 && j==1) continue;
					draw(m,a+m*i,b+m*j);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * <규칙>
		 * ***
		 * * *
		 * *** 
		 * 의 원소가 3단계의 깊이로 배열됨
		 */
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		map = new String[n][n];
		
		for(int i=0;i<=n-1;i++) {
			for(int j=0;j<=n-1;j++) {
				map[i][j] = " ";
			}
		}
		
		draw(n,0,0);
		
		for(int i=0;i<=n-1;i++) {
			for(int j=0;j<=n-1;j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
