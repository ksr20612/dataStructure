package B0106;

import java.util.Scanner;

public class Q2439 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=1;i<=n;i++) {
			for(int j=n;j>i;j--) {
				System.out.print(" ");
			}
			int k = i;
			while(k>0) {
				System.out.print("*");
				k--;
			}
			System.out.println();
		}
	}

}
