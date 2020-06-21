package H0218;

import java.util.Scanner;

public class Q12813 {
	
	private static void calAnd(String[] listA, String[] listB) {
		// TODO Auto-generated method stub
		
		String[] result = new String[100000];
		
		for(int i=0;i<=listA.length-1;i++) {
			if(listA[i].equals(listB[i]) && listA[i].equals("1")) result[i] = "1";
			else result[i] = "0";
		}
		
		System.out.println(String.join("", result));
	}
	
	public static void calOr(String[] listA, String[] listB) {
		
		String[] result = new String[100000];
		
		for(int i=0;i<=listA.length-1;i++) {
			if(Integer.parseInt(listA[i])+Integer.parseInt(listB[i])>=1) result[i] = "1";
			else result[i] = "0";
		}
		
		System.out.println(String.join("", result));
	}
	
	public static void calXor(String[] listA, String[] listB) {
		
		String[] result = new String[100000];
		
		for(int i=0;i<=listA.length-1;i++) {
			if(!listA[i].equals(listB[i])) result[i] = "1";
			else result[i] = "0";
		}
		
		System.out.println(String.join("", result));
	}
	
	public static void calNot(String[] list) {
		
		String[] result = new String[100000];
		
		for(int i=0;i<=list.length-1;i++) {
			if(list[i].equals("1")) list[i] = "0";
			else list[i] = "1";
		}
		
		System.out.println(String.join("", result));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		String A = sc.next();
		String B = sc.next();
		
		String[] listA = A.split("");
		String[] listB = B.split("");
		
		calAnd(listA, listB);
		calOr(listA,listB);
		calXor(listA,listB);
		calNot(listA);
		calNot(listB);
		
	}

}
