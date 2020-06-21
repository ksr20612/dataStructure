package samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q14503 {

	static int N,M;
	static int[][] map;
	static int[] dx={-1,0,1,0}; 
	static int[] dy={0,1,0,-1}; // 상하좌우

	// 로봇이 청소한다.
	static void clean(int x,int y,int dir){
		
		//
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		/*
		 * 1. 그냥 시키는 대로 코딩하기...
		 */
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M]; // 지도
		
		st=new StringTokenizer(br.readLine());
		int robotX=Integer.parseInt(st.nextToken()); // 로봇의 최초 x좌표
		int robotY=Integer.parseInt(st.nextToken()); // y좌표
		int robotOri=Integer.parseInt(st.nextToken()); // 방향
		
		for(int i=0;i<N;i++){
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		clean(robotX,robotY,robotOri);
		
		// 청소된 자리 판단해주기
		int cleaned=0;
		for(int i=0;i<N;i++){
			for(int j=0;j<M;j++){
				if(map[i][j]==2){ // 청소(2)가 되었으면
					cleaned++;
				}
			}
		}
		System.out.println(cleaned);
	}
}
