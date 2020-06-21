package 정렬0225;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Q10989 {

	// 카운팅 정렬
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] list = new int[n];
		
		int max=0; // 인덱스 배열 크기 알아내기 위함
		for(int i=0;i<=n-1;i++) {
			list[i] = Integer.parseInt(br.readLine());
			if(max<list[i]) max = list[i];
		}
		
		int[] idx = new int[max+1];
		
		// 개수 파악해주기
		for(int i=0;i<=list.length-1;i++) {
			idx[list[i]]++;
		}
		
		// 앞의 원소 더해주기
		for(int i=1;i<=idx.length-1;i++) {
			idx[i] += idx[i-1];
		}
		
		// 새로운 배열에 인덱스 배열 참고해서 넣어주기
		int[] ans = new int[n];
		for(int i=list.length-1;i>=0;i--) {
			idx[list[i]]--;
			ans[idx[list[i]]] = list[i];
		}
		
		// 출력
		IntStream is = Arrays.stream(ans);
		is.forEach(e -> System.out.println(e));
	}

}
