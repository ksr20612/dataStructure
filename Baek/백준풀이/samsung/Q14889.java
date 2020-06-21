package samsung;

import java.util.ArrayList;
import java.util.Scanner;

public class Q14889 {

	static int[][] map;
	static ArrayList<Integer> members;
	static ArrayList<Integer> teamStart;
	static ArrayList<Integer> teamLink;
	static int n, min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		
		/*
		 * 1. 팀 구성하기
		 * 2. 가능한 조합을 모두 구하기
		 * 3. 조합 별 능력치 더하기
		 * 4. 차이 구하기(여러번 해야되니까 반복)
		 * 5. 차이의 최소값 출력하기
		 */
		
		Scanner input = new Scanner(System.in);
		n = input.nextInt();

		map = new int[n+1][n+1]; // 능력표
		members = new ArrayList(); // 그냥 멤버 숫자가 담긴 리스트
		teamStart =  new ArrayList(); // 크로스팀
		teamLink =  new ArrayList(); // 링크팀

		// 값 받아오기
		for (int i = 1; i <= n; i++) {
			members.add(i);
			for (int j = 1; j <= n; j++) {
				map[i][j] = input.nextInt();
			}
		}
		
		// 팀 짜기
		makeTeamStart(1);
		
	}

	// 팀짜기 => 안겹치게, 조합
	static void makeTeamStart(int i) {
		// TODO Auto-generated method stub
		if(i==n+1) {
			sumStat();
			return;
		}
		
		// 조합이니까 겹쳐서 고르도록 고른 거 안 고르도록 조건 걸기
		for(int k=1;k<=n;k++) {
			if(!teamStart.contains(k)) {
				i++;
				teamStart.add(k);
				makeTeamStart(i);
			}else {
				continue;
			}
		}
		
	}

	// 스탯 더하기
	static void sumStat() {
		// TODO Auto-generated method stub
		
	}
}
