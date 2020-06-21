package naver;

import java.util.ArrayList;
import java.util.Scanner;

public class solution {

	public static int solution(int A, int B) {
		
		int mul = A*B;
		int rest;
		ArrayList<String> list = new ArrayList();
		int count = 0;
		
		while(true) {
			rest = mul%2;
			list.add(Integer.toString(rest));
			if(mul/2>=1) {
				mul=mul/2;
			}
			if(mul==1) {
				list.add("1");
				break;
			}
		}
		
		// 판단
		for(int i=0;i<=list.size()-1;i++) {
			if(list.get(i).equals("1")) {
				count++;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 1. 2진수로 바꾸기
		 * 2. 1의 개수 도출하기
		 */
		
		System.out.println(solution(2,5));
	}

}
