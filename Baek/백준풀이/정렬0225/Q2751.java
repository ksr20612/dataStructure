package 정렬0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q2751 {

	public static int[] mergeSort(int[] arr) {
		if(arr.length <= 1) return arr;
		
		int m = arr.length/2;
		
		// 좌
		int[] left = new int[m];
		for (int i = 0; i < left.length; i++) {
			left[i] = arr[i];
		}
		
		// 우
		int[] right = new int[arr.length - m];
		for (int i = 0; i < right.length; i++) {
			right[i] = arr[i+m];
		}
		
		return merge(mergeSort(left), mergeSort(right));
		
	}

	public static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int l = 0;
		int r = 0;
		int cnt = 0;
		//작은 요소를 먼저 왼쪽에 넣기
		while(l<left.length && r<right.length) { // 끝까지 안갔으면
			if(left[l]<right[r]) {
				result[cnt++] = left[l++];
			}else {
				result[cnt++] = right[r++];
			}
		}
		while(l<left.length) {
			result[cnt++] = left[l++];
		}
		while(r<right.length) {
			result[cnt++] = right[r++];
		}
		
		return result;
	}	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] list = new int[n];
		
		for(int i=0;i<=n-1;i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		int[] arr = mergeSort(list);
		
		for(int i=0;i<=arr.length-1;i++) {
			System.out.println(arr[i]);
		}
	}

}
