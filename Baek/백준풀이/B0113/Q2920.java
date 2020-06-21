package B0113;

import java.util.Arrays;
import java.util.Scanner;

public class Q2920 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int[] list = new int[8];
		
		for(int i=0;i<8;i++) {
			list[i] = sc.nextInt();
		}
		sc.close();
		
		int asc=0, desc=0;
		for(int i=0;i<7;i++) {
			if(list[i]+1==list[i+1]) asc++; // 올라가는 음계 시 더해주고
			if(list[i]-1==list[i+1]) desc++; // 내려가는 음계 시 더해주기
		}
		
		if(asc==7) System.out.println("ascending");
		else if(desc==7) System.out.println("descending");
		else System.out.println("mixed");
		
	}

}
