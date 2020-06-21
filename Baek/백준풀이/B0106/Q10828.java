package B0106;

import java.util.ArrayList;
import java.util.Scanner;

public class Q10828 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		ArrayList<Integer> stack = new ArrayList<>();
		
		for(int i=0;i<=n;i++) {
			String command = sc.nextLine();
			
			if(command.equals("top")) {
				System.out.println(stack.get(stack.size()-1));
			}else if(command.equals("empty")) {
				if(stack.size()==0) {
					System.out.println(-1);
				}else System.out.println(0);
			}else if(command.equals("size")) {
				System.out.println(stack.size());
			}else if(command.equals("pop")) {
				if(stack.size()==0) {
					System.out.println(-1);
				}else {
					System.out.println(stack.get(stack.size()-1));
					stack.remove(stack.size()-1);
				}
			}else if(command.contains("push")){
				int x = Character.getNumericValue(command.charAt(5));
				stack.add(x);
			}
		}
	}
}
