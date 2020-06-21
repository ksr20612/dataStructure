package B0113;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2609 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 최대공약수와 최소공배수
		
		/*
		 * 사고의 흐름
		 * 1. a의 약수들을 arrayList에 넣는다.
		 * 2. b를 a의 약수들로 차례차례 나눠볼 때 나머지가 0인 가장 큰 수가 최대공약수이다.
		 * 3. 최소공배수는 a와 b를 곱하고 그 수를 최소공배수를 나눈 것이다.
		 */
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		// 1	
		ArrayList<Integer> aElement = new ArrayList();
		for(int i=1;i<=a;i++) {
			if(a%i==0) aElement.add(i);
		}
		
		// 2
		int max=1; //최대공약수
		for(int i=0;i<=aElement.size()-1;i++) {
			if(b%aElement.get(i)==0) {
				int processMax = aElement.get(i); // '최대'공약수와 비교될 아이
				if(processMax>max) max=processMax; // 나눠진 애가 더 크면 최대공약수 갱신
			}
		}
		System.out.println(max);
		
		// 3
		System.out.println(a*b/max);
	}

}
