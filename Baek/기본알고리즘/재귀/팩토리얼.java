package 재귀;

public class 팩토리얼 {

	public static int factorial(int n) {
		if(n==1) return 1;
		return n * factorial(n-1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int n = 5;
		
		System.out.println(factorial(n));
	}

}
