package B0113;

import java.util.Scanner;

public class Q10872 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 팩토리얼 계산하기
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int fac = 1;
		for(int i=n;i>=1;i--) {
			fac*=i;
		}
		System.out.println(fac);
	}

}
