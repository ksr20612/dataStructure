package naver;

public class newQ2 {

	public static String solution(String S) {
		
		/*
		 * 분기가 2개
		 * 1. 문자가 다를 경우 ---> (i) 둘 중에 하나가 ?인 경우 (ii) (a,b)(b,a)
		 * 2. 문자가 같을 경우 ---> (i) 둘다 ? 인 경우 (ii) ?는 아니지만 같은 경우
		 * 
		 * (나올 수 있는 결과들)
		 *  i  | len-i
		 *  a  |   a
		 *  a  |   ?
		 *  a  |   b
		 *  b  |   a
		 *  b  |   ?
		 *  b  |   b
		 *  ?  |   a
		 *  ?  |   ?
		 *  ?  |   b
		 */
		
		// 크기 조건이 있으니까 배열에다가 담아주기
		String[] charList = new String[1001];
		charList = S.split("");
		
		// 분기
		// 크기가 1인 경우 붙여주기
		for(int i=0;i<=charList.length/2-1;i++) {

			String left = charList[i];
			String right = charList[charList.length-1-i];
			
			if(!left.equals(right)) { // 1
				if(left.equals("?")) charList[i] = charList[charList.length-1-i];		// 좌측이 ?
				else if(right.equals("?")) charList[charList.length-1-i] = charList[i]; // 우측이 ?
				else return "NO";														// (a,b) 혹은 (b,a)
				
			}else { // 2
				if(left.equals("?")) {						// 둘다 ?
					charList[i] = "z";
					charList[charList.length-1-i] = "z";
				}else {}									// (a,a) 혹은 (b,b)이면 값 변경 필요없음
			}
			
		}
		
		// 다시 글자로 만들기
		return String.join("", charList);

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String a = "?a?";
		System.out.println(solution(a));
	}

}
