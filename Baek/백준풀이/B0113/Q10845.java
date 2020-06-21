package B0113;

import java.util.ArrayList;
import java.util.Scanner;

public class Q10845 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 큐 --> 스택과 비슷.
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> cue = new ArrayList();
		
		for(int i=1;i<=n+1;i++) {
			
			String command = sc.nextLine();
			
			if(command.equals("back")) {
				if(cue.isEmpty()) System.out.println(-1);
				else System.out.println(cue.get(cue.size()-1));
			}else if(command.equals("front")) {
				if(cue.isEmpty()) System.out.println(-1);
				else System.out.println(cue.get(0));
			}else if(command.equals("empty")) {
				if(cue.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}else if(command.equals("size")) {
				System.out.println(cue.size());
			}else if(command.equals("pop")) {
				if(cue.isEmpty()) System.out.println(-1);
				else {
					System.out.println(cue.get(0));
					cue.remove(cue.get(0));
				}
			}else if(command.contains("push")) {
				cue.add(Character.getNumericValue(command.charAt(5))); // integer꼴로 형변환
			}
		}
		
	}

}
