package B0113;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q1026 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * 1. S를 가장 작게 만드려면 가장 큰 b의 값에 가장 작은 a의 값을 곱해서 더해줘야함
		 * 2. listB는 정렬하지 않을 것.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			
			// listA 넣기
			int[] listA = new int[n];
			String number1 = br.readLine();
			StringTokenizer st1 = new StringTokenizer(number1, " ");
			for(int i=1;i<=n;i++) {
				listA[i-1] = Integer.parseInt(st1.nextToken());
			}
			
			// listB 넣기
			int[] listB = new int[n];
			String number2 = br.readLine();
			StringTokenizer st2 = new StringTokenizer(number2, " ");
			for(int i=1;i<=n;i++) {
				listB[i-1] = Integer.parseInt(st2.nextToken());
			}
			
			// listA 정렬하기
			Arrays.sort(listA);
			
			// listB는 정렬하는 대신, 각 값의 순위를 매겨준 arrayList(orderList)를 하나 더 만들어주기
			ArrayList<Integer> orderList = new ArrayList();
			for(int i=1;i<=n;i++) {
				int rank = 1;
				for(int j=1;j<=n;j++) {
					if(listB[i-1]>listB[j-1]) rank++;
				}
				
				// i의 랭크는 결국 올라간 rank의 값임 -> 그 값을 orderList에 순서대로 넣어줄 것.
				/* 예를 들어서 [1 3 2 4 5]일 경우,
				 * 1과 1 비교 -> rank 안 올라감 / 1과 3 비교 -> rank 안올라감 ====> rank 는 그대로 1
				 * 3과 1 비교 -> rank=2 / 3과 3 비교 -> rank 안올라감 / 3과 2 비교 -> rank=3
				 */
				orderList.add(rank);
			}
			
			// orderList의 값을 참고하여, a의 가장 작은 값과 b의 가장 큰 값을 순서대로 곱해줌
			int S = 0;
			int rankB = n; // 가장 큰 b의 값부터 시작,
			for(int i=1;i<=n;i++) {
				int a = listA[i-1]; // a의 값
				int b = listB[orderList.indexOf(rankB)]; // b의 값: orderlist에서 rankB(가장큰값)의 위치를 찾아준 뒤 그 위치로 listB의 원소를 가져옴
				rankB--;
				S+=a*b;
			}
			
			// 출력
			bw.write(S+"\n");
			bw.flush();
			
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
