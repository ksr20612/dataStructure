package B0113;

import java.util.Scanner;

public class Q2444 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 1. boolean 이용하기 -> 근데 어짜피 한 번만 교체되니까 그냥 다른 for문으로 분리함
		 */
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
        for(int i = 1; i < n; i++){
            for(int j = 1; j <= n-i; j++) System.out.print(" ");
            for(int k = 1; k <= i*2-1; k++) System.out.print("*");
            System.out.println();
        }
        for(int i = n; i >= 0; i--){
            for(int j = 1; j <= n-i; j++) System.out.print(" ");
            for(int k = 1; k <= i*2-1; k++) System.out.print("*");
            System.out.println();
        }
	}

}
