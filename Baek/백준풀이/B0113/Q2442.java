package B0113;

import java.util.Scanner;

public class Q2442 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		for(int i=1;i<=a;i++) { // 돌아가는 바퀴 수
			for(int j=a-i;j>=1;j--) { // j = 공백의 개수
				System.out.print(" ");
			}
			for(int k=1;k<=2*i-1;k++) { // k = 별의 개수
				System.out.print("*");
			}
			System.out.println();

		}
		
	}

}
