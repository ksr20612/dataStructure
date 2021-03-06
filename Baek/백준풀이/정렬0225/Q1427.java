package 정렬0225;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Q1427 {
	
	public static void reverseBubbleSort(String n) {
		
		int[] list = new int[n.length()];
		for(int i=0;i<=n.length()-1;i++) {
			list[i] = Integer.parseInt(n.substring(i, i+1));
		}
		
		for(int i=0;i<=list.length-1;i++) {
			boolean swap = false; // 아예 정렬이 안되었으면 애초에 정렬이 필요없는 거니까 탈출
			for(int j=0;j<=list.length-2-i;j++) {
				if(list[j]<list[j+1]) {
					int temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
					swap = true;
				}
			}
			if(swap==false) break;
		}
		
		IntStream is = Arrays.stream(list);
		is.forEach(e -> System.out.print(e));
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		reverseBubbleSort(sc.nextLine());
		
	}

}
