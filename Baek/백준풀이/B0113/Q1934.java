package B0113;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1934 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] maxList = new int[n]; // 한 줄에 해당하는 최소공배수 저장
		for(int i=1;i<=n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// a의 약수 구하기
			ArrayList<Integer> aElement = new ArrayList();
			for(int j=1;j<=a;j++) {
				if(a%j==0) aElement.add(j);
			}
			
			// 최대공약수 구하기
			int max=1;
			for(int j=1;j<=aElement.size();j++) {
				if(b%aElement.get(j-1)==0) max=aElement.get(j-1);
			}
			maxList[i-1]=a*b/max;
			
		}
		
		for(int i=1;i<=n;i++) {
			bw.write(maxList[i-1]+"\n");
		}
		bw.flush();
		
	}

}
