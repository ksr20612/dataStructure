package 병합정렬;

import java.util.*;
import java.util.stream.IntStream;

public class MergeSort {

		public static void main(String[] args) {
			int[] arr = {8, 3, 6, 1, 2, 7, 4, 9, 5};
			
			System.out.println("정렬 전 배열 : "+Arrays.toString(arr));
			System.out.println("정렬 후 배열 : "+Arrays.toString(mergesort(arr)));	
		}
		
		/*
		 * 병합정렬 (분할정복)
		 * size가 1일때까지 나누고 그 이상일때는 부분 리스트에 대한 
		 * merge로 보내 정렬을 진행한 후 병합한다.
		 */
		
		public static int[] mergesort(int[] arr) {
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
			
			return merge(mergesort(left), mergesort(right));
		}
		
		//정렬법 => 분열되어 오름차순으로 정렬된 배열들을 아래 요소들부터 확인하며 
	        //          다시 큰 하나의 배열로 오름차순으로 병합
		
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
	}

