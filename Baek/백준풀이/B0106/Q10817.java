package B0106;

import java.util.Arrays;
import java.util.Scanner;

public class Q10817 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int[] arr = {a,b,c};
		
		Arrays.sort(arr);
		System.out.print(arr[1]);
	}
}
