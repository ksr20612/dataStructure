package B0106;

import java.util.Scanner;

public class Q2577 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		String n = Integer.toString(a*b*c);
		for(int i=0;i<=9;i++) {
			int count = 0; //각 숫자의 개수
			for(int j=0;j<=n.length()-1;j++) {
				if(Character.getNumericValue(n.charAt(j))==i) {
					count++;
				}
			}
			System.out.println(count);
		}
		
	}

}
