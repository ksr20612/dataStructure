package B0113;

import java.util.Scanner;

public class Q9095 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
		
		/* 
		 * f(n)=f(n-3)+f(n-2)+f(n-1)
		*/
		
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt(); // 입력 받을 숫자의 개수
		
		int[] list = new int[11]; // 11보다 작은 n(조건)
		list[1] = 1;
		list[2] = 2;
		list[3] = 4;
		
		for(int i=1;i<=t;i++) {
			int n = sc.nextInt(); // 입력 받은 숫자
			
			for(int j=4;j<=n;j++) {
				list[j] = list[j-3]+list[j-2]+list[j-1];
			}
			
			System.out.println(list[n]);
		}
	}

}
