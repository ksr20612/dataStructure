package B0106;

import java.util.Scanner;

public class Q10039 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double sum=0;
		for(int i=0;i<5;i++) {
			int score = sc.nextInt();
			if(score<40) score=40;
			sum+=score;
		}
		System.out.println(sum/5);
		
	}
}
