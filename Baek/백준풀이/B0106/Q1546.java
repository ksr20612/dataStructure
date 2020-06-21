package B0106;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q1546 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int j=1;j<=n;j++) {
			array.add(sc.nextInt());
		}
		
		Collections.sort(array); //최대값 찾기 위해 정렬
		int m = array.get(n-1); //최대값
		
		System.out.println(array.get(0));
		int sum = 0; //평균 구하기 위한 점수 합계
		for(int i=0;i<=array.size()-1;i++) {
			sum += (double)array.get(i)/m *100;
		}
		System.out.println(sum/n);
	}

}
