package B0106;

import java.util.Scanner;

public class Q9498 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		
		if(score<60) {
			System.out.println("F");
		}else if(score<70) {
			System.out.println("D");
		}else if(score<80) {
			System.out.println("C");
		}else if(score<90) {
			System.out.println("B");
		}else if(score<=100) {
			System.out.println("A");
		}
	}

}
