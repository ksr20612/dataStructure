package naver;

public class newQ3 {

	public static int solution(int[] A) {
		
		/*
		 * 1. 두가지 결과값을 배열의 형태로 만들어준다(101,010)
		 * 2. 두 결과값에 도달하는데 변화시켜야할 개수를 각각 세어준다
		 * 3. 두 값 중 작은 값을 찾아 인출한다
		 */
		
		// 1
		int[] ideal101 = new int[101];
		int[] ideal010 = new int[101];
		
		for(int i=1;i<=A.length;i++) {
			if(i%2==1) { // 홀수면
				ideal101[i]=1;
				ideal010[i]=0;
			}else { // 짝수면
				ideal101[i]=0;
				ideal010[i]=1;
			}
		}
		
		// 2
		int cnt101=0;
		int cnt010=0;
		
		for(int i=1;i<=A.length;i++) {
			if(ideal101[i]!=A[i-1]) cnt101++;
			if(ideal010[i]!=A[i-1]) cnt010++;
		}
		
		// 3
		if(cnt101>=cnt010) return cnt010;
		else return cnt101;
	}
	
	// 축약
	public static int revised_solution(int[] A) {
		
		int cnt101=0;
		int cnt010=0;
		
		for(int i=1;i<=A.length;i++) {
			if(i%2==1) { // 홀수면
				if(1!=A[i-1]) cnt101++;
				if(0!=A[i-1]) cnt010++;
			}else { // 짝수면
				if(0!=A[i-1]) cnt101++;
				if(1!=A[i-1]) cnt010++;
			}
		}
		
		return Math.min(cnt101, cnt010);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] list = {0,1,1,0};
		
		System.out.println(revised_solution(list));
	}

}
