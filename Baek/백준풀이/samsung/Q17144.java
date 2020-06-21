package samsung;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * 주의할 것:
 *  - 대입하는 경우에 pointer 생각하기
 */

public class Q17144 {

	static int R;
	static int C;
	static int T;

	static int[][] map;

	// 확산된 먼지 값이 들어감
	static int[][] diffuseMap;

	// u,r,d,l ( 윗부분 )
	static int[] upX = { 1, 0, -1, 0 };
	static int[] upY = { 0, -1, 0, 1 };

	// d,r,u,l ( 아랫부분 )
	static int[] downX = { 1, 0, -1, 0 };
	static int[] downY = { 0, 1, 0, -1 };

	
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		/*
		 * 1. 미세먼지 확산
		 * 	- 새로운 map을 만들어서 확산시키고 그 맵을 기존의 맵에 넣는다
		 *  - 원래 map에다가 바로 하니까 다음 사이클에 먼지의 양이 추가되어서 결정됨
		 * 2. 공기청정기 가동
		 */

		Scanner sc = new Scanner(System.in);

		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();

		int aircon1 = 0;

		int aircon2 = 0;

		boolean isUp = true;

		map = new int[R][C];
		diffuseMap = new int[R][C];

		// 에어컨 위치 잡기
		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++) {

				map[i][j] = sc.nextInt();

				if (map[i][j] == -1) {

					if (isUp) {
						isUp = false;
						aircon1 = i;
					}

					else {
						aircon2 = i;
					}
				}
			}

		for (int time = 0; time < T; time++) {

			diffuseMap = new int[R][C];
			
			diffuse();

			map[aircon1][0] = -1;
			map[aircon2][0] = -1;

			clean(aircon1,true,aircon1);

			clean(aircon2,false,R-1-aircon2);

			// 계산할 때 방해되니까 -1을 0으로 고쳐주기
			map[aircon1][0] = 0;
			map[aircon2][0] = 0;
		}

		int ans = 0;

		for (int i = 0; i < R; i++)
			for (int j = 0; j < C; j++)
				ans += map[i][j];

		System.out.println(ans);
	}

	// 미세먼지 확산
	public static void diffuse() {

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {

				if (map[i][j] > 0) {
					
					int remain = map[i][j]; // 먼지양
					int x = 0;
					int y = 0;
					
					// 상하좌우 확인
					for (int m = 0; m < 4; m++) {

						x = i + upX[m];
						y = j + upY[m];
						
						try {
							
							// 청정기가 아니고 벗어나지 않으면
							if (map[x][y] != -1) {

								diffuseMap[x][y] += remain/5;
								remain -= map[i][j]/5;
							}
							
						} catch (Exception e) {
							continue;
						}

					}

					diffuseMap[i][j] += remain;

				}
			}
		}
		
		for(int i=0;i<R;i++)
			for(int j=0;j<C;j++)
				map[i][j]=diffuseMap[i][j];
	}

	// 공기 청정기 돌리기
	public static void clean(int airconLocation, boolean isUp,int len) {

		// isUp => 위 방향인가요? 하나로 돌려주기
		
		int[] dx;
		int[] dy;

		// 위 방향이면 이 순서
		if (isUp) {
			dx = upX;
			dy = upY;
		}else { // 아래면 이 순서
			dx = downX;
			dy = downY;
		}

		int x = airconLocation;
		int y = 0;

		// 다음위치
		int nx = 0;
		int ny = 0;

		int length=0;
		for (int m = 0; m < 4; m++) {
			
			/*
			// u,r,d,l ( 윗부분 )
			static int[] dxU = { 1, 0, -1, 0 };
			static int[] dyU = { 0, -1, 0, 1 };
		
			// d,r,u,l ( 아랫부분 )
			static int[] dxD = { 1, 0, -1, 0 };
			static int[] dyD = { 0, 1, 0, -1 };
			*/
			
			// 홀수면 세로, 짝수면 가로만큼
			if(m%2==1)
				length = C;
			else
				length = len;

			for(int i=0;i<length;i++) {
				nx = x + dx[m];
				ny = y + dy[m];

				try {
					// 에어컨이면 탈출
					if (map[nx][ny] == -1)
						break;

					map[x][y] = map[nx][ny];

					x = nx;
					y = ny;

				} catch (Exception e) {
					break;
				}
			}

		}

	}

}
