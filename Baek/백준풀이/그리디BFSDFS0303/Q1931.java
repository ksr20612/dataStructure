package 그리디BFSDFS0303;
import java.util.*;

import java.io.*;

public class Q1931 {

	// 회의실 배정
	
	/*
	 * 끝나는 시간을 기준을 정렬한 후(단, 끝나는시간이 같으면 그 안에서 시작시간으로 정렬), 작은 것부터 순서대로 대입해보기
	 */
	
	static class Meeting {
		int start;
		int end;
		
		Meeting(int a, int b) {
			this.start = a;
			this.end = b;
		}
	}
	
	public static void count(Meeting[] list) {
		
		sort(list); // 정렬시행
		
		int count = 0;
		int remain = 0;
		
		for(int i=0;i<=list.length-1;i++) {
			if(remain<=list[i].start) {
				remain = list[i].end;
				count++;
			}
		}
		
		System.out.println(count);
	}
	
	public static void sort(Meeting[] list) {
		
		// 일단 끝나는 시간 기준으로 오름차순 정렬, 만약 끝시간이 같으면 시작 시간 기준으로 오름차순 정렬
		
		for(int i=0;i<=list.length-1;i++) {
			for(int j=0;j<=list.length-2-i;j++) {
				if(list[j].end>list[j+1].end) {
					Meeting temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}else if(list[j].end==list[j].end) {
					if(list[j].start>list[j+1].start) {
						Meeting temp2 = list[j];
						list[j] = list[j+1];
						list[j+1] = temp2;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Meeting[] list = new Meeting[n];
		for(int i=0;i<=n-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			Meeting a = new Meeting(start,end);
			
			list[i] = a;
		}
		
		count(list);
	}

}
