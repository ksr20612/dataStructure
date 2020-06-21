package 그리디BFSDFS0303;
import java.util.*;
import java.io.*;

public class Q1541 {

	/*
	 *  잃어버린 괄호
	 *  
	 *  ex1) 55-(50+40)
	 *  ex2) 55-(50+40)-10
	 *  ex3) 55-(50+40)-(10+30)
	 *   => 첫 마이너스 이후로 전부 빼면 됨
	 */
	
	public static void calculate(String a) {
		
		int sum = 0;
		String temp = a.replaceFirst("\\-", " ");
		String[] list = temp.split(" ");
		
		// list[0]은 전부 +로 구성되어 있기 때문에 각 값을 그냥 더해주기
		if(list[0].contains("+")) {
			String[] first = list[0].split("\\+");
			for(int i=0;i<=first.length-1;i++) {
				sum+=Integer.parseInt(first[i]);
			}
		}else { // 원소가 한개면
			sum+=Integer.parseInt(list[0]);
		}
		
		// list[1]은 +와 -로 구성되어 있기 때문에 일단 전부 +로 바꾸고 +를 없애주기
		if(list[1].contains("+") || list[1].contains("-")) {
			String secondString = list[1];
			if(list[1].contains("-")) secondString = list[1].replace("-","+"); // -를 전부 +로 바꿔주기
			String[] second = secondString.split("\\+");
			for(int i=0;i<=second.length-1;i++) {
				sum-=Integer.parseInt(second[i]);
			}
		}else { // 원소가 한개면
			sum-=Integer.parseInt(list[1]);
		}
		
		System.out.println(sum);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		calculate(sc.nextLine());
	}

}
