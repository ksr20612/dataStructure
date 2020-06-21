package B0113;

import java.util.Arrays;
import java.util.Scanner;

public class Q1932 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		/*
		 * 내 사고의 흐름 
		 * 0. 일단 dynamic programming 이용하는 것임을 파악
		 * 1. list에 list를 담아주는 그릇을 생성하고 입력받은 값을 담아줄것
		 * 2. list[i]의 새로운 열에는 list[i-1]을 이용하여 새로운 숫자들이 담긴다
		 * 3. 그렇게 도출된 마지막 list[i]에서 가장 큰 수를 가져온다
		 */
		
		// 1. 값 넣어주기
		int[][] list = new int[n][];
		for(int i=0;i<=n-1;i++) {
			list[i] = new int[i+1];
			for(int j=0;j<=i;j++) {
				list[i][j] = sc.nextInt();
			}
		}
		sc.close();	
		
		// 2. 새로운 리스트 만들어주기(루프 돌면서 기존의 값 더해주기)
		if(n==1) System.out.println(list[0][0]); // 피라미드가 그냥 한 줄일 경우에는 그냥 그 값 뽑아주기
		else {
			for(int i=1;i<=n-1;i++) { // 
				for(int j=0;j<=i;j++) {
					if(j==0) { // 피라미드 한 줄에서 가장 앞 숫자: 무조건 전 줄의 가장 앞 숫자를 더해옴
						list[i][j] = list[i][j] + list[i-1][j];
					}else if(i==j){ // 피라미드 한 줄에서 가장 마지막 숫자: 무조건 전 줄의 가장 마지막 숫자를 더해옴
						list[i][j] = list[i][j] + list[i-1][i-1];
					}else { // 가운데 낀 숫자들: 전 줄의 (자신-1) or (자신)번째 숫자에 해당하는 숫자 중 큰 수를 더해옴
						list[i][j] = list[i][j] + Math.max(list[i-1][j-1], list[i-1][j]);
					}
				}
			}
		
			// 3. 마지막 줄에서 가장 큰 값 뽑아주기: 오름차순 정렬 후 가장 마지막 숫자 가져오기
			int[] lastList = list[n-1];
			Arrays.sort(lastList);
			System.out.println(lastList[n-1]);
		}
	}

}
