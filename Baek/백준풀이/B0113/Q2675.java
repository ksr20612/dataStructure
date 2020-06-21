package B0113;

import java.util.Scanner;

public class Q2675 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=1;i<=n;i++) {
			int m = sc.nextInt();
			String word = sc.next();
			
			String[] charList = word.split("");
			
			for(int j=0;j<=charList.length-1;j++) { //반복할 글자 선택
				for(int k=1;k<=m;k++) //반복할 횟수만큼 반복됨
					System.out.print(charList[j]);
			}
			System.out.println();
		}
	}

}
