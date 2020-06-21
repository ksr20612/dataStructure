package 그리디BFSDFS0303;
import java.util.*;
import java.io.*;

public class Q2206_1 {

	static class Node {
	    int x, y, route;
	    int wall; // 0=아직 부수지 않음

	    Node(int x, int y, int route, int wall) {
	        this.x = x;
	        this.y = y;
	        this.route = route;
	        this.wall = wall;
	    }
	}

    static int n, m;
    static int min = 1000000;
    static int[][] arr;
    static boolean[][][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
	
    public static void bfs(int x, int y){
    	
        Queue<Node> needVisit = new LinkedList<Node>();
        Node node = new Node(x, y, 1, 0);
        needVisit.add(node);
        visited[x][y][0] = true;

        while(!needVisit.isEmpty()) {
        	
            Node target = needVisit.poll();

            for(int j = 0; j < 4; j++) {
                int nx = target.x + dx[j];
                int ny = target.y + dy[j];

                if (nx < 0 || nx > m - 1 || ny < 0 || ny > n - 1) continue;
                
                // 최소값 갱신하기
                if (nx == m - 1 && ny == n - 1) {
                    if (min > target.route) min = target.route + 1;
                    continue;
                }

                if (visited[nx][ny][target.wall] == false) {
                    if (target.wall == 0) { // 아직 벽 뚫을 기회가 있는 경우
                        visited[nx][ny][target.wall] = true;
                        if (arr[nx][ny] == 1) { // 벽이 있을 경우
                            needVisit.add(new Node(nx, ny, target.route + 1, 1));
                        } else {
                            needVisit.add(new Node(nx, ny, target.route + 1, 0));
                        }
                    }
                    // 벽 뚫는 기회를 이미 써버렸을땐, 0일경우 밖에 못간다.
                    else {
                        if (arr[nx][ny] == 0) {
                            visited[nx][ny][target.wall] = true;
                            needVisit.add(new Node(nx, ny, target.route + 1, 1));
                        }
                    }
                }
            }
        }
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Scanner input = new Scanner(System.in);
        m = input.nextInt();
        n = input.nextInt();

        visited = new boolean[m][n][2];
        arr = new int[m][n];

        for(int i = 0; i < m; i++){
            String line = input.next();
            for(int j = 0; j < n; j++){
                arr[i][j] = line.charAt(j)-'0';
            }
        }

        bfs(0, 0);
        if(min==1000000)System.out.println(-1);
        else System.out.println(min);
    }

}
