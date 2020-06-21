package B0113;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Q1316 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * 1. 새로운 문자가 나올때마다 배열에다가 넣어준다.
		 * 2. 만약에 다음 문자가 현재 문자와 같다면...
		 * 3. 넣어줄 때 배열 한 바퀴를 돌아서 만약 그 문자가 이미 배열 안에 존재하는 문자라면 그룹문자가 아니다.
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());

		int count=n;
		for(int i=1;i<=n;i++) {
			String word = br.readLine();
			ArrayList<String> wordChar = new ArrayList();
			for(int j=1;j<=word.length();j++) {
				if(j==1) {
					wordChar.add(word.substring(0, 1)); 
					continue; // word의 첫 글자 넣어주기
				}
				if(word.substring(j-1,j).equals(word.substring(j-2,j-1))==false) { //다음 글자가 지금 글자와 다르다면
					if(wordChar.contains(word.substring(j-1,j))) { //근데 그 글자가 wordChar에 이미 존재하는 거라면
						count--; // 그룹단어가 아니니까 1을 빼준다
						break;
					}else { //다음 글자가 지금 글자와 다르지만 배열에 존재하지 않는 글자라면
						wordChar.add(word.substring(j-1,j)); // 그 글자를 넣어준다.
					}
					}
				}
			}	
		bw.write(count+"\n");
		bw.flush();
		}	
	}
