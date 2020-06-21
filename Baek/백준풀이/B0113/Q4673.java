package B0113;

public class Q4673 {
	
	// 셀프 넘버 계산하는 메서드
	public static int d(int i) {
		int new_i = i;
		while(true) {
			new_i+=i%10;
			i/=10;
			if(i<10) {
				new_i+=i;
				break;
			}
		}
		return new_i;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 1~10000 까지의 list를 만들고, 값이 있으면 list의 해당 숫자에 1을 넣어주기. 셀프 넘버는 결국 아무 값도 없는 배열의 위치임.
		
		int[] list = new int[10000];
		
		for(int i=1;i<10000;i++) {
			int new_i = d(i);
			if(new_i<10000) {
				list[new_i] = 1;
			}else { 
				continue; } // 만들어진 new_i가 10000보다 크다면 그 다음 for문을 도시오.
		}
		
		for(int i=1;i<10000;i++) {
			if(list[i]!=1) System.out.println(i); // 1이 아닌 값의 위치(null값)
		}
	}

}
