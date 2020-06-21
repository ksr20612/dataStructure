package 정렬0225;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Q2750 {

	public static void bubbleSort(int[] list) {
		
		for(int i=0;i<=list.length-1;i++) {
			boolean isSwapped = false;
			for(int j=0;j<=list.length-2-i;j++) {
				if(list[j]>list[j+1]) {
					int temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
					isSwapped = true;
				}
			}
			if(isSwapped==false) break;
		}
		
		// 출력
		for(int i=0;i<=list.length-1;i++) {
			System.out.println(list[i]);
		}
	}
	
	public static void selectionSort(int[] list) {
		
		for(int i=0;i<=list.length-2;i++) {
			int minIndex = i;
			for(int j=i+1;j<=list.length-1;j++) {
				if(list[j]<list[minIndex]) {
					minIndex = j;
				}
			}
			int temp = list[i];
			list[i] = list[minIndex];
			list[minIndex] = temp;
		}
		
		// 출력
		IntStream st = Arrays.stream(list);
		st.forEach(n -> System.out.println(n));
	}
	
	public static void insertSort(int[] list) {
		
		for(int i=1;i<=list.length-1;i++) {
			for(int j=i;j>=1;j--) {
				if(list[j]<list[j-1]) {
					int temp = list[j];
					list[j] = list[j-1];
					list[j-1] = temp;
				}else break;
			}
		}
		
		// 출력
		IntStream st = Arrays.stream(list);
		st.forEach(n -> System.out.println(n));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] list = new int[n];
		for(int i=0;i<=n-1;i++) {
			list[i] = sc.nextInt();
		}
		
		//bubbleSort(list);
		//selectionSort(list);
		//insertSort(list);
		
	}

}
