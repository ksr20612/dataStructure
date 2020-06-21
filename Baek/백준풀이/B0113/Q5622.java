package B0113;

import java.util.Scanner;

public class Q5622 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 1. 배열을 만들어서 문자열을 하나씩 넣어준다.
		 * 2. String[] list = new String[10] (0~9까지의 숫자, 각 숫자에 해당하는 문자열로 이루어져 있음)
		 * 3. 배열에서 문자를 하나씩 꺼내서 list의 각 원소와 비교해보고 숫자로 치환한다.
		 * 4. 시간을 판단해준다.
		 */
		
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		
		// 1
		String[] wordList = word.split("");
		
		// 2
		String[] list = {null, null, "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
		
		// 3 + 4
		int sum  = 0;
		for(int i=1;i<=word.length();i++) {
			for(int j=2;j<=9;j++) {
				if(list[j].contains(wordList[i-1])) sum+=j+1; // 다이얼 n은 n+1초가 걸림
			}
		}
		System.out.println(sum);
	}

}
