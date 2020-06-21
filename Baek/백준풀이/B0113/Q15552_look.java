package B0113;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Q15552_look {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 복잡한 입력의 경우에는 BufferedReader와 bufferedWriter 이용할 것
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int n = Integer.parseInt(br.readLine());
			for(int i=0;i<=n-1;i++) {
				String[] num = br.readLine().split(" ");
				bw.write(Integer.parseInt(num[0])+Integer.parseInt(num[1])+"\n");
			}
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
