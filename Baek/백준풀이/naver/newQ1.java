package naver;

import java.util.ArrayList;

public class newQ1 {

	public static int solution(String[] A) {
	
		/*
		 * 1. 몽땅 붙인 길이
		 * 2. 지 혼자서 겹치면 아웃
		 * 3. 단어끼리 겹치면 긴거 빼고 아웃
		 */
		
		// 1
		String joinedWord = String.join("", A);
		int maxLen=joinedWord.length();
		
		// 2
		for(int i=0;i<=A.length-1;i++) {
			String word = A[i];
			boolean breaker = false;
			
			for(int j=0;j<=word.length()-1;j++) {
				char letter=word.charAt(j);
				for(int k=j+1;k<=word.length()-1;k++) {
					if(letter==word.charAt(k)) {
						maxLen-=word.length();
						joinedWord = joinedWord.replace(word, "");
						breaker = true;
						break;
					}
				}
				if(breaker) break;
			}
		}
		
		// 3
		for(int i=0;i<=joinedWord.length()-1;i++) {
			char letter=joinedWord.charAt(i);
			for(int j=i+1;j<=joinedWord.length()-1;j++) {
				if(letter==joinedWord.charAt(j)) { // 똑같은 애가 존재한다면,
					// 그 letter을 포함한 단어를 모두 찾아라
					ArrayList<String> candidate = new ArrayList();
					for(int k=0;k<=A.length-1;k++) {
						String word = A[k];
						for(int m=0;m<=word.length()-1;m++) {
							if(letter==word.charAt(m)) {
								candidate.add(word);
								break;
							}
						}
					}
					// 걔네들 중에서 가장 긴 단어빼고 다 지우자
					
				}
			}
		}
		
		
		return maxLen;
		
	}


	public static int revised_solution(String[] A) {
		
		/*
		 * 최대 단어가 8개밖에 안되니까 브루트포스 방식으로 다 해보자
		 * 1번 단어부터 시작해서 붙일 수 있냐 판단해서 붙이기	
		 * < 헷갈려서 글로 써본 것 >
		 * String chosen = "";
		 * ArrayList<String> chosenList = new ArrayList();
		 * for문(=단어 선택)
		 *  for문(=다른 단어 고르기)
		 *   합치기
		 *   for문(=철자비교1)
		 *    for문(=철자비교2)
		 *    if(철자가 동일하면) 안붙임
		 * <각 단어가 포함된 가장 큰 단어열을 찾아라>
		 * 1. abc ? 안 겹침. 결과는 abc
		 * 2. abc + yyy ? 겹치니까 안붙임. 결과는 abc
		 * 3. abc + def ? 안 겹침. 결과는 abcdef
		 * 4. abcdef + csv ? 겹치니까 안붙임. 결과는 abcdef
		 * --------------------------------------------
		 * 1. yyy ? 겹치니까 안붙임. 결과는 ""
		 * 2. yyy + def ? 겹치니까 안붙임. 결과는 ""
		 * 3 4 결과로 붙는 것 없음
		 * --------------------------------------------
		 * 1. def ? 안 겹침. 결과는 def
		 * 2. def + abc ? 안 겹침. 결과는 defabc
		 * 3. defabc + yyy ? 겹침
		 * 4. defabc + csv ? 겹치니까 결과는 defabc
		 */
		
		ArrayList<String> chosenList = new ArrayList();

		for(int m=0;m<=A.length-1;m++) {
			String chosen = A[m];
			for(int i=0;i<=A.length-1;i++) {
				if(m!=i) {
					boolean isOverlapped = false;
					chosen = chosen + A[i];
					for(int j=0;j<=chosen.length()-2;j++) {
						for(int k=j+1;k<=chosen.length()-1;k++) {
							if(chosen.charAt(j)==chosen.charAt(k)) {
								chosen = chosen.replace(A[i], ""); //동일하면 빼주자
								isOverlapped = true;
								break;
							}
						}
						if(isOverlapped) break;
					}
					if(isOverlapped==false) chosenList.add(chosen);
				}
			}
		}

		if(chosenList.size()==0) return -1;
		else {
			int maxLen=0;
			for(String word : chosenList) {
				maxLen = Math.max(maxLen, word.length());
			}
			return maxLen;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] a = {"eva","jqw","tyn","jan"};
		System.out.println(revised_solution(a));
	}

}
