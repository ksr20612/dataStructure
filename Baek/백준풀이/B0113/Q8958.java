package B0113;

import java.util.Scanner;

public class Q8958 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			String line = sc.next();
			String[] list = line.split("X"); // X를 기점으로 분리

			int score = 0;
			for(int j=1;j<=list.length;j++) {
				if(list[j-1].length()!=0) {
					for(int k=1;k<=list[j-1].length();k++) {
						score+=k;
					}	
				}
			}
			System.out.println(score);
		}
	}
}
