package samsung;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q14502 {
	
	// 좌표를 하나의 클래스로 만들어 놓기
    static class Pair {
        int r, c;
        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static int N, M;
    static int[][] map, temp;
    static int max = 0;
    
    // 안전영역 구하기
    static void findSafeZone() {
        int safezone = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(temp[i][j] == 0)
                    safezone++;
            }
        }
        
        max = Math.max(max, safezone);        
    }
    
    // 바이러스 퍼뜨리기
    static void spreadVirus() {
        Queue<Pair> q = new LinkedList<Pair>();
        int[] dr = {-1, 0, 1, 0}; // 바이러스 위치의 상하좌우롤 표현함
        int[] dc = {0, -1, 0, 1};
        
        // temp에 map을 옮기고, 바이러스가 있는 위치를 큐에 저장
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                temp[i][j] = map[i][j]; 
                
                if(temp[i][j] == 2)
                    q.add(new Pair(i, j)); // 바이러스 위치
            }
        }
        
        // 바이러스 확산 위치 결정하고 
        while(!q.isEmpty()) { // 큐가 비어있지 않으면 계속 돌아간다
            Pair p = q.remove(); // 큐에서 하나를 가져온다
            int r = p.r;
            int c = p.c;
            
            for(int i = 0; i < 4; i++) {
                int R = r + dr[i]; // 바이러스가 퍼질 위치 좌표(상하좌우니까 총 4개)
                int C = c + dc[i];
                
                if(R < 0 || N <= R || C < 0 || M <= C) continue; // 지도를 벗어나면 바이러스 확산 처리 안해줌
                
                if(temp[R][C] == 0) { // 그 좌표가 안전지대면
                    temp[R][C] = 2; // 바이러스로 만들어준다.
                    q.add(new Pair(R, C)); // 그리고 걔를 다시 큐에 넣어준다. ---> 그럼 반복 횟수가 또 늘어나겠지.
                }
            }
        }
        
        findSafeZone();
    }
	
	// 벽 세우기
    static void walls(int cnt) {
        if(cnt == 3) {    
            spreadVirus(); // 3개 다 세우면 바이러스 퍼뜨리기
            return;
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) { // 벽을 세울 수 있는 자리일 때
                    map[i][j] = 1; // 벽을 세운다
                    walls(cnt+1); // 다시 함수 호출하여 벽을 세운다 --> 벽은 총 세 개 세워짐
                    map[i][j] = 0; // 벽을 다 세우고 바이러스까지 퍼뜨렸으면(종료시점) map자체를 다시 초기화시켜야함
                }
            }
        }
    }
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*
		 * 1. 전체 숫자 중에서 0이 안전영역이다. 1은 벽, 2는 바이러스
		 * 2. 0이 쓰여져 있는 자리 중 3개를 골라서 벽을 세운다(골라서->그냥 벽 세개가 중복되어 선택되는 되는 것은 어짜피 최대값을 결정하는 것이기 때문임...)
		 * 3. 바이러스를 퍼뜨린다(while문을 돌려 2의 상하좌우에 0이 없을 때 탈출시킨다)
		 * 4. 최댓값 변수를 만들어 놓고 돌렸을 때 나온 값이 현재 변수보다 크면 최댓값으로 지정해준다.
		 */
		
		// DFS == 얼마나 깊게? BASELINE잡기, BFS == 
		
		// 값 받아오기
        Scanner s = new Scanner(System.in);
        
        N = s.nextInt();
        M = s.nextInt();
        map = new int[N][M]; // 원래 지도
        temp = new int[N][M]; // 바이러스 퍼뜨리는 지도(원래 지도가 바뀌면 안됨->여러 개의 지도를 탐색하기 때문에)
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = s.nextInt();
            }
        }
        
        walls(0); // 벽 세우기
        
        System.out.println(max); // 최댓값 구하기
    }
}
