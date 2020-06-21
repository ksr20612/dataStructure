package B0106;

import java.util.Scanner;

public class Q10809 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		
		for(char i='a';i<='z';i++) {
			System.out.print(s.indexOf(i)+" ");
		}
		
	}

}
