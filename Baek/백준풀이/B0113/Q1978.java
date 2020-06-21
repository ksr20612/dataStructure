package B0113;

import java.util.Scanner;

public class Q1978 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] list = new int[n];
		
		// 1부터 n까지의 값 몽땅 넣어주기
		for(int i=1;i<=n;i++) {
			int a = sc.nextInt();
			list[i-1] = a;
		}
		sc.close();
		
		int count = 0;
		boolean flag = true;
		for(int i=0;i<n;i++) {
			int b = list[i];
			if(b==1) { // 1은 소수가 아니므로 아래 연산 패스
				continue;
			}
			for(int j=2;j<=b/2;j++) { // 2부터 n/2까지 반복(애초에 배열에 n/2까지있으면 더 간편할듯)
				if(b%j==0) {
					flag = false;
					break; // 한번이라도 나눠지면 소수가 아님
				}
			}
			//여전히 flag가 true다 = 한번도 안나눠졌다 = 소수다
			if(flag) count++;
		}
		System.out.println(count);
	
	}

}
