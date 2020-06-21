package samsung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q14499 {

	// 주사위 생성 - 모든 면이 0인 주사위임
	static int diceTop = 0;
	static int diceBottom = 0;
	static int diceFront = 0;
	static int diceBack = 0;
	static int diceLeft = 0;
	static int diceRight = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*
		 * 1. 주사위 생성(모든 면이 0)
		 * 2. 지도 생성(int[][] 형태)
		 * 3. 주사위가 어느 방향으로 굴러가는가에 따라 모든 면의 숫자를 바꿔줄 것(동시에 윗 면에 적힌 숫자를 출력함)
		 * 4. 필요할 경우 지도의 숫자를 바꿔줄 것
		 * --- 주사위를 객체화시키면 최고의 방식일텐데...
		 * 
		 * --- 주사위 3면을 알면 나머지 면을 다 알 수 있어요...
		 */
	
		// 값 받아오기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken()); // 지도 가로
		int m = Integer.parseInt(st.nextToken()); // 지도 세로
		int x = Integer.parseInt(st.nextToken()); // 주사위 위치 좌표
		int y = Integer.parseInt(st.nextToken()); // 주사위 위치 좌표
		int k = Integer.parseInt(st.nextToken()); // 명령 수
		
		// 지도 생성
		int[][] map = new int[n][m];
		for(int i=1;i<=n;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
			for(int j=1;j<=m;j++) {
				map[i-1][j-1]= Integer.parseInt(st2.nextToken());
			}
		}
		
		// 주사위 굴리기
		int[] moveX = {0, 1, -1, 0, 0};
		int[] moveY = {0, 0, 0, -1, 1};
		
		for(int i=1;i<=k;k++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine(), " ");
			int toWhere = Integer.parseInt(st3.nextToken());
			
			// 주사위의 위치 판단해주기( 만들어놓은 배열 이용 )
			int diceX = x + moveX[toWhere];
			int diceY = y + moveY[toWhere];
			if(diceX>=0 && diceX<m && diceY>=0 && diceY<n) { // 지도 안에 있을때만
				roll(toWhere); // 주사위 굴리기
				
				if(map[diceY][diceX]==0) { // 지도의 그 위치 숫자가 0이면
					map[diceY][diceX] = diceBottom;
				}else { // 아니면
					diceBottom = map[diceY][diceX];
					map[diceY][diceX] = 0;
				}
				x = diceX; // 그 위치로 저장
				y = diceY;
				System.out.println(diceFront);
			}
		}

		
	}
	
	public static void roll(int i) {
		if(i==1) { // 동쪽으로 굴리기
			int temp = diceTop;
			diceTop = diceLeft;
			diceLeft = diceBottom;
			diceBottom = diceRight;
			diceRight = temp;
		}else if(i==2) { // 서쪽
			int temp = diceTop;
			diceTop = diceRight;
			diceRight = diceBottom;
			diceBottom = diceLeft;
			diceLeft = diceTop;
		}else if(i==3) { // 남쪽
			int temp = diceTop;
			diceTop = diceBack;
			diceBack = diceBottom;
			diceBottom = diceFront;
			diceFront = temp;
		}else if(i==4) { // 북쪽
			int temp = diceTop;
			diceTop = diceFront;
			diceFront = diceBottom;
			diceBottom = diceBack;
			diceBack = temp;
		}
	}
}
