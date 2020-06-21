package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q17779 {

    static int n;
    static int[][] people, election;
    static int ansMin=0;
    
    public static void main(String[] args)throws IOException{
    	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        people = new int[n+1][n+1];
        election = new int[n+1][n+1];
        
        StringTokenizer st;
        for(int i = 1 ; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= n ; j++) {
                people[i][j] = Integer.parseInt(st.nextToken());
                election[i][j] = 0; // 초기값
            }
        }
        
        for(int x = 1 ; x <= n; x++) { // 생각해보면 이거 다 볼 필요가 없습니다.
            for(int y = 1 ; y <= n ; y++) {
                for(int d1 = 1 ; d1 < n*2 ; d1++) {
                    for(int d2 = 1 ; d2 < n * 2 ; d2++) {
                        
                        if(x + d1 + d2 <= n && 1 <= y-d1 && y+d2 <= n) {
                        
                            makeLine5(x, y, d1, d2); // 경계만들기
                            make1(x, y, d1, d2);
                            make2(x, y, d1, d2);
                            make3(x, y, d1, d2);
                            make4(x, y, d1, d2);
                            makeInner5(x,y,d1,d2); // 빈칸 채우기
                            
                            // 구역 최대, 최소 개수 세기 
                            count();
                        }
                    }
                }
            }
        }
        
        System.out.println(ansMin);
        
    }
    private static void makeInner5(int x, int y, int d1, int d2) {
    	for(int r = 1; r < n; r++) {
    		for(int c = 1; c < n; c++) {
    			if(election[r][c]==0) {
    				election[r][c] = 5;
    			}
    		}
    	}
		
		
	}
	static void make1(int x, int y, int d1, int d2) {
        for(int r = 1; r < x + d1; r++) {
            for(int c = 1 ; c <= y; c++) {
            	if(election[r][c]==5) break;
                election[r][c] = 1;
            }
        }
    }
    static void make2(int x, int y, int d1, int d2) {
        for(int r = 1; r <= x + d2 ; r++) {
            for(int c = y+1 ; c <= n ; c++) {
            	if(election[r][c]==5) break;
                election[r][c] = 2;
            }
        }
    }
    static void make3(int x, int y, int d1, int d2) {
        for(int r = x+d1; r <= n; r++) {
            for(int c = 1 ; c < y-d1+d2 ; c++) {
            	if(election[r][c]==5) break;
                election[r][c] = 3;
            }
        }
    }
    static void make4(int x, int y, int d1, int d2) { 
        for(int r = x+d2+1; r <= n ; r++) {
            for(int c = y-d1+d2 ; c <= n; c++) {
            	if(election[r][c]==5) break;
                election[r][c] = 4;
            }
        }
    }
    
    static void makeLine5(int x, int y, int d1, int d2) {
        
        for(int i = 0 ; i <= d1; i++) {
            election[x+i][y-i] = 5;
        }
        for(int i = 0 ; i <= d2; i++) {
            election[x+i][y+i] = 5;
        }
        for(int i = 0 ; i <= d2; i++) {
            election[x+d1+i][y-d1+i] = 5;
        }
        for(int i = 0 ; i <= d1; i++) {
            election[x+d2+i][y+d2-i] = 5;
        }
        
    }

    static void count() {
        
        // counts[i]: i번 구역의 인구 수 
        int[] amountList = new int[6];
        for(int r = 1 ; r <= n; r++) {
            for(int c= 1 ; c<= n; c++) {
                amountList[election[r][c]] += people[r][c];
            }
        }
        Arrays.sort(amountList);
        int diff = amountList[5]-amountList[1];
        
        // 1. 최초일 때 혹은 2. 새로운 값이 기존 값보다 작을 때 교체
        if(ansMin==0 || diff<ansMin) {
        	ansMin = diff;
        }
        
    }

}
