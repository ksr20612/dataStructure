package B0106;

import java.util.Scanner;

public class Q1463__ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		float n = sc.nextInt();
		
		int count = 0;
		while(true) {
			count++;
			if(n%3==0) n /= 3;
			if(n%2==0) n /= 2;
			n-=1;
			
			if(n==1) break; 
		}
		
		System.out.println(count);
	}

}
