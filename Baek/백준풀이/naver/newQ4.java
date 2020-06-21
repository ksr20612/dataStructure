package naver;

import java.util.ArrayList;

public class newQ4 {

	public static int solution(int A, int B) {
		
		/*
		 * 1. 곱하기
		 * 2. 이진수로 바꾸기
		 * 3. 1의 개수 세기
		 * 
		 * 1+2+3 합쳐서 코드 최적화해봄
		 * 
		 * 문제점 : 엄청나게 큰 수(10^16)를 감당 못한다
		 */

		// 1+2+3
		int cnt=0;
		
		for(int mul=A*B;mul>=1;mul/=2) {
			if(mul%2==1) cnt++;
		}
		
		return cnt;
	}
	
	public static int revised_Solution(int A, int B) {
		
		/*
		 * 큰 수를 사용할 수 있도록 string화 시켜서 처리해주는 방식(먼저 이진수화 시켜놓고 값을 배열에 저장해주기)
		 * 이진수의 곱셈도 결국 곱셈이더라
		 * 1. 이진수로 만들기, 배열에 저장
		 * 2. 곱하기
		 * 3. 1개수 판단해주기
		 */
		
		// 1
		int[] binA = decimalToBinary(A);
		int[] binB = decimalToBinary(B);
		
		// 2
		int[] result = new int[binA.length+binB.length];
		
		// 0으로 초기화
		for(int i=0;i<=result.length-1;i++) result[i]=0;
		
		for(int i=0;i<=binA.length-1;i++) {
			for(int j=0;j<=binB.length-1;j++) {
				result[i+j]+=binA[i]*binB[j];
			}
		}
		
		// 올려주기
		for(int i=0;i<=result.length-1;i++) {
			if(result[i]>=2) {
				result[i+1]+=result[i]/2;
				result[i]=result[i]%2;
			}
		}
		
		// 3
		int cnt=0;
		for(int i=0;i<=result.length-1;i++) {
			if(result[i]==1) cnt++;
		}
		
		return cnt;
	}
	
	private static int[] decimalToBinary(int a) {
		// TODO Auto-generated method stub
		
		// 배열의 크기 계산하기
		int cnt=0;
		for(int i=a;i>=1;i/=2) {
			cnt++;
		}
		
		// 이진수로 바꾸기
		// 참고로 제일 맨 뒷자리부터 배열의 맨 앞자리로 들어감
		int[] bin = new int[cnt];
		for(int i=1;i<=cnt;i++) {
			bin[i-1]=a%2;
			a/=2;
		}
		
		return bin;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(revised_Solution(3,7));
	}

}
