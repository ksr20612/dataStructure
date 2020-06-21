package 퀵정렬;

import java.util.Arrays;
import java.util.stream.IntStream;

public class quickSort {

	// 오버로딩 이용! ---> 동일한 메소드의 사용성을 확장(매개변수의 개수와 타입이 달라도 사용할 수 있게끔)
	// 참고 : 오버라이딩 = 상속받은 메소드를 재정의해서 사용하는 것(메소드 명만 같을 뿐 중간 과정 및 출력값은 다름) ex.강아지.sound() ===> 치와와.sound, 시바.sound
	
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}
	
	// 얘를 재귀로 계속 돌림
	public static void quickSort(int[] arr, int start, int end) {
		int part2 = partition(arr, start, end);
		if(start < part2 - 1) {
			quickSort(arr, start, part2-1);
		}
		if(part2 < end) {
			quickSort(arr, part2, end);
		}
	}
	
	// 정렬구간 : 왼쪽과 오른쪽을 배교해서 swap해주는 방식
	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[(start+end)/2];
		while(start<=end) {
			while(arr[start]<pivot) start++; // while속의 while문은 if처럼 행동하네
			while(arr[end]>pivot) end--;
			if(start<=end) {
				swap(arr, start, end);
				start++;
				end--;
			}
		}
		return start;
	}
	
	public static void swap(int[] arr, int start, int end) {
		int tmp = arr[start];
		arr[start] = arr[end];
		arr[end] = tmp;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {3,9,4,7,5,0,1,6,8,2};
		quickSort(arr);
		
		// 출력 ------- for Loop 대신 stream 이용해서 배열 종류 애들 쉽게 출력하기
		IntStream stream = Arrays.stream(arr);
		stream.forEach(e -> System.out.print(e + " "));
	}
}
