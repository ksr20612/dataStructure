package B0106;

import java.util.ArrayList;
import java.util.Scanner;

public class Q1924 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//첫째 줄에 빈 칸을 사이에 두고 x(1≤x≤12)와 y(1≤y≤31)이 주어진다. 참고로 2007년에는 1, 3, 5, 7, 8, 10, 12월은 31일까지, 4, 6, 9, 11월은 30일까지, 2월은 28일까지 있다.
		
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		int date = sc.nextInt();
		
		//총 날짜 수 구하기
		int[] months = {31,28,31,30,31,30,31,31,30,31,30,31};
		int sum_days = 0;
		for(int i=0;i<month-1;i++) {
			sum_days = sum_days + months[i];
		}
		sum_days += date;
		
		//요일 구하기
		int division = sum_days%7;
		if(division==0) System.out.println("sun");
		if(division==1) System.out.println("mon");
		if(division==2) System.out.println("tue");
		if(division==3) System.out.println("wed");
		if(division==4) System.out.println("thu");
		if(division==5) System.out.println("fri");
		if(division==6) System.out.println("sat");
		
	}

}
