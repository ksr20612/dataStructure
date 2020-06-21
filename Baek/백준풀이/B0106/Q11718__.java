package B0106;

import java.util.ArrayList;
import java.util.Scanner;

public class Q11718__ {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<>();
		
		while(sc.hasNextLine()) {
			arr.add(sc.nextLine());
		}
		sc.close();
		
		for(int i=0;i<=arr.size()-1;i++) {
			System.out.println(arr.get(i));
		}
	}
}
