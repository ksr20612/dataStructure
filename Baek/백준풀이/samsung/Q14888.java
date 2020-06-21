package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14888 {

    static int[] list,calCount;
    static int n;

    static int max;
    static int min;
    
    private static void OrderList(int plus,int minus,int mul,int div,int result,int idx) {
    	
        if(idx==n) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        
        // 더하기부터 시작 -> 더하기 하나 사용하기
        if(plus>0) {
            OrderList(plus-1,minus,mul,div,result+list[idx],idx+1);
        }
        // 빼기부터 시작 -> 빼기 하나 사용하기
        if(minus>0) {
            OrderList(plus,minus-1,mul,div,result-list[idx],idx+1);
        }
        // 곱하기부터 시작 -> 곱하기 하나 사용하기
        if(mul>0) {
            OrderList(plus,minus,mul-1,div,result*list[idx],idx+1);
        }
        // 나누기부터 시작 -> 나누기 하나 사용하기
        if(div>0) {
            OrderList(plus,minus,mul,div-1,result/list[idx],idx+1);
        }
    }
    
    public static void main(String[] args) throws IOException {
    	
    	/*
    	 * 1. 재귀함수를 이용하여 나올 수 있는 모든 순서를 만든다.
    	 * 2. 순서 별로 그 합을 계산한다.
    	 *  ---> 그냥 얘네를 합쳐서 표현하자.
    	 */
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 숫자를 담는다
        for(int i=0;i<n;i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine());
        calCount = new int[4];
        
        // 더하기(0) 빼기(1) 곱하기(2) 나누기(3) 개수를 담는다
        for(int i=0;i<4;i++) {
            calCount[i] = Integer.parseInt(st.nextToken());
        }
        
        max = Integer.MIN_VALUE; // 작은 수부터
        min = Integer.MAX_VALUE; // 큰 수부터
        
        // 더하기-빼기-곱하기-나누기 개수와 최초값(0), 총 연산자의 개수.
        OrderList(calCount[0],calCount[1],calCount[2],calCount[3],list[0],1);
        
        System.out.println(max);
        System.out.println(min);
    }

}
