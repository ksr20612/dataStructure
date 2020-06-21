package B0113;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q2455 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*
		 * 1. dynamic programming 이용
		 * 2. list에 역에서의 인구 수 적어주고 가장 큰 값 뽑기
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] sumList = new int[5]; // sumList[n]은 n번 역을 지나면서 기차에 남은 사람의 수
		sumList[0] = 0; 
		for(int i=1;i<=4;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()); // 내린 사람
			int b = Integer.parseInt(st.nextToken()); // 탄 사람
			
			sumList[i] = sumList[i-1] + b-a;
		}
		
		Arrays.sort(sumList);
		bw.write(sumList[4]+"\n");
		bw.flush();
	}

}
