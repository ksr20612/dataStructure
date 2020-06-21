package B0113;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q2490 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		// 합이 4=모, 3=걸, 2=개, 1=도, 0=윷
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] sumList = new int[3];
		for(int i=1;i<=3;i++) {
			int sum=0;
			String n = br.readLine();
			StringTokenizer st = new StringTokenizer(n, " ");
			for(int j=1;j<=4;j++) {
				sum+=Integer.parseInt(st.nextToken());
			}
			sumList[i-1]=sum;
		}
		
		for(int j=1;j<=3;j++) {
			if(sumList[j-1]==0) bw.write("D"+"\n");
			else if(sumList[j-1]==1) bw.write("A"+"\n");
			else if(sumList[j-1]==2) bw.write("B"+"\n");
			else if(sumList[j-1]==3) bw.write("C"+"\n");
			else bw.write("E"+"\n");
		}
		bw.flush();
	}

}
