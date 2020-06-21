package B0113;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Q1158_look {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 1. 3,6,9,12,15,18... k부터 시작해서 k씩 증가하는 루프 속에서 n으로 나눈 나머지가 다음 방출되는 타겟(단, 다음에는 n-1로 나눈 나머지임, 그 다음은 n-2 ... => 결국 size로 나눠짐)
		 * 2. 방출된 애들을 담아주는 list
		 * 3. 모두 방출되어 arrayList가 0이 되면 list를 출력 
		 */
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		LinkedList<Integer> list = new LinkedList<Integer>();
		for(int i=0; i<n; i++) {
			list.add(i+1);
		}
		System.out.print("<");
		int pos =1; // 위치 ----> 얘를 변수화시키면 편한데 처음부터 코드 단순화 먼저 생각하다보니 꼬여버렸음.
		for(int i=0; i<n-1; i++) {
				pos = pos+k-1;
				if(pos>list.size()) {
					if(pos%list.size()==0) // 나누어서 딱 떨어지면
						pos=list.size();
					else
						pos%=list.size(); // 
				}
				
				System.out.print(list.remove(pos-1)+", ");
			
		}
		System.out.print(list.poll());
		System.out.print(">");
	}

}
