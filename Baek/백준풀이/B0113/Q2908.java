package B0113;

import java.util.Scanner;

public class Q2908 {
	
	// 그냥 따로 메서드를 하나 만들었습니다.
	public static int sangsu(String a) {
		
		int new_a;
		String[] list = new String[3];
		list = a.split("");
		
		// 일의자리와 백의자리 바꿔줌
		String x = list[2];
		list[2] = list[0];
		list[0] = x;
		
		// join으로 붙여주고 int로 형변환시켜줌
		new_a = Integer.parseInt(String.join("", list));
		
		return new_a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		String b = sc.next();
		
		System.out.println(Math.max(sangsu(a), sangsu(b)));
		
	}

}
