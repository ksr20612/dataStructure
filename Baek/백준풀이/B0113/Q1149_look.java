package B0113;

import java.util.Scanner;

public class Q1149_look {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 1. dynamic programming 이용
		 * 2. 배열에 담아주기
		 * 3. index는 최솟값
		 * 4. value[n][0~2]에 담기는 값은 본인을 제외한 색의 value[n-1]의 값 중 작은 값을 택하는 것.
		 */
		
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			
			// 배열에 담아주기
			int[][] value = new int[n][3];
			
			for(int i=0; i<n;i++) {
				value[i][0]=sc.nextInt();//red
				value[i][1]=sc.nextInt();//green
				value[i][2]=sc.nextInt();//blue
			
				if(n==1 || i==0) {
				}
				else {
					value[i][0]+=Math.min(value[i-1][1], value[i-1][2]);
					value[i][1]+=Math.min(value[i-1][0], value[i-1][2]);
					value[i][2]+=Math.min(value[i-1][0], value[i-1][1]);
				}
				
			}
			System.out.println(Math.min(value[n-1][0],
					Math.min(value[n-1][1],value[n-1][2])));

		}
}
