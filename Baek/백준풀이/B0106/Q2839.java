package B0106;

import java.util.Scanner;

public class Q2839 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		//i=3kg 봉지 개수, j=5kg 봉지 개수, sum=총 봉지 개수
		int i = 0;
		int j = 0;
		int sum = n/3; //최대 봉지 개수에서 시작
		for(i=0;i<=n/3;i++) {
			for(j=0;j<=n/5;j++) {
				if(3*i+5*j==n && i+j<sum) {
					sum = i+j;
				}
			}
		}
		if(sum != n){
			System.out.println(sum);
		}else {
			System.out.println("-1");
		}
	}

}
