package 재귀;

public class 회문판단 {
	
	public static boolean palindrome(String a) {

		if(a.length()==1) return true;
		
		if(a.charAt(0)==a.charAt(a.length()-1)) {
			return palindrome(a.substring(1, a.length()-1));
		}else {
			return false;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String word = "noon";

		if(palindrome(word)) System.out.print("회문입니다");
	}

}
