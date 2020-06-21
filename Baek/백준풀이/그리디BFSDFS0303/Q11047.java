package 그리디BFSDFS0303;

import java.util.*;
import java.io.*;

public class Q11047 {

	// 동전 0
	
	/*
	 * 가장 큰 단위부터 차례대로 넣기
	 */
	
	public static void count(int k, int[] list) {
	
		int start = list.length-1;
		int count = 0;
		
		while(true) {
			if(k-list[start]>0) { // 뺄 수 있으면, 걔 빼기
				k-=list[start];
				count++;
			}else if(k-list[start]<0) { // 뺄 수 없으면, 그 다음 작은 동전으로 시도해보기
				start--;
			}else if(k-list[start]==0) { // 딱 0이 되면, 종료하기
				count++;
				System.out.println(count);
				break;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] list = new int[n];
		for(int i=0;i<=n-1;i++) {
			list[i] = Integer.parseInt(br.readLine());
		}
		
		count(k,list);
	}

}
