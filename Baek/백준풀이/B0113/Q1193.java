package B0113;

import java.util.Scanner;

public class Q1193 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 1. 주어진 수 a가 대각선 상에서 몇번째 줄에 있는가를 파악하면 됨
		 * 2. 줄 안에서 몇번째에 위치하는가?
		 * 3. 짝수 줄은 분자에 위치, 분모에 열번호-분자 / 홀수 줄은 분자에 열번호-분모, 분모에 위치
		 */
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		
		int rowStart = 1; // 열의 시작번호
		int rowEnd = 1; // 열의 마지막번호
		int rowNum = 1; // 몇번 째 열이냐?
		for(int i=1;true;i++) {
			rowNum=i+1;
			rowStart=rowStart+i;
			rowEnd=rowStart+i;
			
			if(a>=rowStart&&a<=rowEnd) {
				int rowSum = rowNum+1; // 각 줄의 분모 분자 합
				if(rowNum%2==0) { // 짝수 줄(우->좌)
					int rowLocation = a-rowStart+1; // 한 줄에서 몇 번째에 위치하고 있냐?
					System.out.println(rowLocation+"/"+(rowSum-rowLocation));
					break;
				}else if(rowNum%2!=0){ // 홀수 줄(좌->우)
					int rowLocation = a-rowStart+1;
					System.out.println((rowSum-rowLocation)+"/"+rowLocation);
					break;
				}
			}
			
		}
			
	}

}
