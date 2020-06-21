package B0113;

import java.util.Arrays;
import java.util.Scanner;

public class Q1427 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 오름차순시킨 후 뒤에서부터 출력시키면 됨
		Scanner sc = new Scanner(System.in);
		String n = sc.nextLine();
		String[] list = n.split("");
		Arrays.sort(list);
		
		for(int i=n.length();i>=1;i--) {
			System.out.print(list[i-1]);
		}
		
		// 만약 출력이 아니라 정말 정렬을 원하는 것이었다면... for loop 이용하여 list에 다시 담아주면 됨
	}
}
