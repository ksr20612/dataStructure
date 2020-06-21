package DFS;
import java.io.*;
import java.util.*;

public class Q6603 {

	// 조합 구현하기!!!! => 재귀 이용하기, cnt와 시작 index 변수 이용
	
    static int N;
    static int[] list;
    static boolean[] check;
    static int[] ans;

    public static void dfs(int index, int cnt){
        if(cnt == 6 ){
            for(int i=0; i<6; i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println();
            return; //---> 얘를 붙여야지 모든 경우의 수가 도출될 수 있다... 얘 없으면 그냥 한 번 하고 끝(123456만 하고 끝)
        }

        for(int i =index; i<N; i++){
               ans[cnt] = list[i];
               dfs(i+1,cnt+1);
            }
        }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while(true){
            N = scan.nextInt();
            ans = new int[N];
            list = new int[N];
            check = new boolean[N];
            if(N == 0) break;
            for(int i=0; i<N; i++){
                list[i] = scan.nextInt();
            }
            dfs(0, 0);
            System.out.println();
        }
    }

}
