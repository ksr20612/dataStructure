package naver;

public class q4 {
	
	public static int solution(int[] A) {
		
		int cnt101 = 0;
		int cnt010 = 0;
		
		int[] ideal101 = new int[101];
		int[] ideal010 = new int[101];
		
		for(int i=1;i<=A.length;i++) {
			if((i-1)%2==0) {
				ideal101[i-1] = 1;
				ideal010[i-1] = 0;
			}else {
				ideal101[i-1] = 0;
				ideal010[i-1] = 1;
			}
		}
		
		for(int i=1;i<=A.length;i++) {
			if(ideal101[i-1] != A[i-1]) { 
				cnt101++;
			}
			if(ideal010[i-1] != A[i-1]) {
				cnt010++;
			}
		}
		
		if(cnt101>cnt010) {
			return cnt010;
		}else {
			return cnt101;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] list = {0,1,1,0};
		System.out.println(solution(list));
	}

}
