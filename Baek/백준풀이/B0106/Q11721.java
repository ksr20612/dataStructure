package B0106;

import java.util.Scanner;

public class Q11721 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();

		for(int i=0;i<=a.length();i=i+10) {
			if(i+10>=a.length()) { //다음 애가 10칸보다 작은 경우
				System.out.println(a.subSequence(i,a.length()));
				break;
			}
			System.out.println(a.subSequence(i, i+10));
		}
	}
}
