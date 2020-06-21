package 재귀;

public class 합인출하기 {

	static int[] list = {5,3,2,4,1};
	
	public static int solution(int start) {
		if(start==0) return list[start];
		return list[start] + solution(start-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(solution(list.length-1));
	}

}
