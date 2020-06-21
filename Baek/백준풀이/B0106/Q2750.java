package B0106;

import java.util.Arrays;
import java.util.Scanner;

public class Q2750 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] list = new int[5];
		for(int j=1;j<=n;j++) {
			list[j-1] = sc.nextInt();
		}
		
		Arrays.sort(list);
		
		for(int i=1;i<=n;i++) {
			System.out.println(list[i-1]);
		}
	}

}
