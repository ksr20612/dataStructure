package B0113;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11399 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		/*
		 * 그냥 단순히 시간이 적게 걸리는 사람이 앞에 가게 만들면 됨 -> 오름차순 정렬 필요
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		int[] list = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0;i<=n-1;i++) {
			list[i]=Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(list);
		
		// dynamic planning으로 더해주고 그 총 값을 sum으로 더해주기
		int sum=0;
		for(int i=1;i<=n-1;i++) {
			list[i]=list[i]+list[i-1];
		}
		for(int i=0;i<=n-1;i++) {
			sum+=list[i];
		}
		
		bw.write(sum+"\n");
		bw.flush();
	}

}
