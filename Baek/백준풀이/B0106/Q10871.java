package B0106;

import java.util.ArrayList;
import java.util.Scanner;

public class Q10871 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.
		
		//입력
		Scanner sc = new Scanner(System.in);	
		int n = sc.nextInt();
		int x = sc.nextInt();
	
		ArrayList<Integer> a = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			a.add(sc.nextInt());
		}
		
		//출력
		for(int i=0;i<=a.size()-1;i++) {
			if(a.get(i)<x) {
				System.out.print(a.get(i)+" ");
			}
		}
	}

}
