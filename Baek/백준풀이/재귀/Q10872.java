package 재귀;

import java.util.Scanner;

public class Q10872 {

	static int fac(int n) {
		if(n==1) {
			return 1;
		}
		return n*fac(n-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		System.out.println(fac(n));
		
	}

}
