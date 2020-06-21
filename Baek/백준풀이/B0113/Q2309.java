package B0113;

import java.util.Arrays;
import java.util.Scanner;

public class Q2309 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 1. 배열 안에 9개의 값을 담는다
		 * 2. 0~8까지의 값 중 2개의 값을 고르는 loop를 돌린다
		 * 3. 난쟁이 키의 합에서 이 두 번호의 난쟁이의 키를 뺀 값이 100이 나오면 그 값들을 출력한다
		 */
		
		// 1
		Scanner sc = new Scanner(System.in);
		int[] list = new int[9];
		for(int i=1;i<=9;i++) {
			list[i-1] = sc.nextInt();
		}
		sc.close();
		
		// 2
		int a=0;
		int b=0; //뽑을 두 값 
		int sum=0; //난쟁이 키의 합
		boolean breakFlag = false; // for loop를 두 개나 탈출해야하는 상황이 벌어짐
		Arrays.sort(list); //오름차순 정렬
		for(int i=1;i<=9;i++) {
			sum += list[i-1];
		}
		
		for(int i=0;i<=8;i++) {
			for(int j=0;j<=8;j++) {
				
				if(i==j) continue; // 동일한 번호가 두 번 뽑힐 수는 없음
				
				// 3
				if(sum-list[i]-list[j]==100) {
					a = i;
					b = j;
					breakFlag = true;
				}
			}
			if(breakFlag) break;
		}
		
		for(int k=0;k<=8;k++) {
			if(k!=a&&k!=b) System.out.println(list[k]);
		}
		

		

	}
}
