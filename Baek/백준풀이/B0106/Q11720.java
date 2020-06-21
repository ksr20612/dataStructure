package B0106;

import java.util.Scanner;

public class Q11720 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		
		int sum = 0; 
		for(int i=1;i<=n-1;i++) {
			sum = sum + a%10;
			a = (int)a/10;
		}
		sum += a;
		System.out.println(sum);
	}
}
