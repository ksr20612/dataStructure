package samsung;

import java.util.ArrayList;
import java.util.Scanner;

public class Q15685 {
	
	static boolean map[][] = new boolean[101][101]; // 그릴 공간
	
	static ArrayList<Integer> list = new ArrayList<>(); // 방향을 저장할 리스트
	
	// 이동방향 제시( 문제에서의 0,1,2,3 )
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, -1, 0, 1 };	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 1. 이동하는 방향을 모두 저장
		 *  --- 1세대 안에서의 방향, 2세대 안에서의 방향, 3세대... 이런 식으로 몽땅
		 * 2. 방향대로 이동하며 해당 좌표를 1로 바꿈
		 */
			Scanner sc = new Scanner(System.in);

			int n = sc.nextInt();

			// 값 받아오기
			for (int t=1;t<=n;t++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int dir = sc.nextInt();
				int gen = sc.nextInt();

				// 최초 입력값의 방향 --> 후에 규칙성 있게 움직임
				list.add(dir);

				// 각 세대 별로 몽땅 넣기
				for (int i=1;i<=gen;i++) {
					int size = list.size();
					
					// 이전 방향들을 모두 시계 방향으로 회전하여 다시 list에 저장
					for (int s=size-1;s>=0;s--) { //
						int newDir = (list.get(s) + 1)%4;
						list.add(newDir);
					}
				}
				
				//map[y][x] = true; // 만들어준 지도
				
				// 기존에 저장한 방향에 따라 초기좌표에서 계속 움직이며 마킹
				for (int direction : list) {
					x += dx[direction];
					y += dy[direction];
					map[y][x] = true;
				}
				
				list.clear(); // 다음 입력값을 위해 clear
			}
			
			System.out.println(findSquare());
		}

		// 정사각형 찾기
		private static int findSquare() {
			int count = 0;
			for(int i=0;i<100;i++) {
				for(int j=0;j<100;j++) {
					if(map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
						count++;
					}
				}
			}
			return count;
		}

	}
