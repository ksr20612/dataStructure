package 정렬0225;

import java.io.*;
import java.util.*;

public class Q2108 {

	public static void solution(int[] list) {
		
	// 산술 평균
		double sum = 0;
		for(int i=0;i<=list.length-1;i++) {
			sum+=(double)list[i];
		}
		double ans = (double)sum/list.length;
		if(ans<0) System.out.println(Math.floor(ans));
		else System.out.println(Math.ceil(ans));
		
	// 중앙값
		Arrays.sort(list);
		System.out.println(list[list.length/2]);
		
	// 최빈값
		ArrayList<int[]> map = new ArrayList();
		
		 // 각 원소의 개수 파악하기 ---> {원소,빈도} 꼴로 arrayList에 넣어주었음
		for(int i=0;i<=list.length-1;i++) {
			if(i!=list.length-1) {
				if(list[i]==list[i+1]) continue; //중복방지
			}
			int cnt = 0;
			int n = list[i];
			for(int j=0;j<=list.length-1;j++) {
				if(list[j]==n) {
					cnt++;
				}
			}
			int[] nfreq = {n,cnt};
			map.add(nfreq);
		}
		
		 // 최빈값 뽑아내기     ***최빈값이 여러개일 경우 고려
		int maxIdx = 0;
		boolean 최빈값이겹치냐 = false;
		for(int i=1;i<=map.size()-1;i++) {
			if(map.get(i)[1]==map.get(maxIdx)[1]) 최빈값이겹치냐 = true;
			if(map.get(i)[1]>map.get(maxIdx)[1]) {
				maxIdx = i;
				최빈값이겹치냐 = false; // 최빈값이 바뀌었으므로 초기화함
			}
		}
		
		if(최빈값이겹치냐 == false) {
			System.out.println(map.get(maxIdx)[0]);
		}else { // 겹치는 경우 ---> 두번째로 작은 값 뽑아내기
			// 1. 해당 최빈값을 가지고 있는 값들을 모두 가져오기
			ArrayList<Integer> maxFreqList = new ArrayList();
			for(int i=0;i<=map.size()-1;i++) {
				if(map.get(i)[1]==map.get(maxIdx)[1]) {
					maxFreqList.add(map.get(i)[0]);
				}
			}
			// 2. 정렬 후 두번째로 작은 값 뽑아내기
			Collections.sort(maxFreqList);
			System.out.println(maxFreqList.get(1));
		}
		
		
	// 범위 ---> 음수 고려할 것
		System.out.println(list[list.length-1]-list[0]);
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * 산술평균, 중앙값, 최빈값, 범위
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] list = new int[n];
		
		for(int i=0;i<=list.length-1;i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		solution(list);
		
	}

}
