package B0113;

import java.util.Scanner;

public class Q2747 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int a=0,b=1;
		for(int i=1;i<=n-1;i++) { // 번호 상 두번째 숫자가 1번임. 따라서 n-1번 돌림
			
			// b는 a+b로, a는 b로 교체
			int c=b;
			b=a+b;
			a=c;
			
		}
		System.out.println(b);
	}

}
