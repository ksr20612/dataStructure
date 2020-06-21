package 재귀;

import java.util.Scanner;

public class Q10870 {
	
	static int 피보나치(int n) {
		
		if(n==0) return 0;
		if(n==1) return 1;
		
		return 피보나치(n-1)+피보나치(n-2);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 피보나치 수열의 n번째 수를 출력하라
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(피보나치(n));
		
	}

}
