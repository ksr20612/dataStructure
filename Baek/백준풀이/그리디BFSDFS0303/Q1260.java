package 그리디BFSDFS0303;
import java.util.*;
import java.io.*;

public class Q1260 {

	/*
	 * DFS 와 BFS
	 * DFS : need_visit(stack) & visited(que) // 재귀
	 * BFS : need_visit(que) & visited(que)
	 */
	
	   static int nodeNum;
	   static int edgeNum;
	   static int[][] arr;
	   static boolean[] visited;

	   public static void dfs(int index){
	       System.out.print(index+" ");
	       for(int i=1; i<=nodeNum; i++){
	            if(arr[index][i]==1 && visited[i]==false){
	                visited[i]=true;
	                dfs(i);
	            }
	       }
	   }

	   public static void bfs(int index){
	       Queue<Integer> needVisit = new LinkedList<Integer>();
	       needVisit.add(index);
	       visited[index]=false;
	       while(!needVisit.isEmpty()){
	           int target=needVisit.poll();
	           System.out.print(target+" ");
	           for(int i=1; i<=nodeNum; i++){
	               if(arr[target][i]==1 && visited[i]){
	                   visited[i] = false;
	                   needVisit.add(i);
	               }
	           }
	       }
	   }


	    public static void main(String[] args) {
	    	
	        Scanner sc = new Scanner(System.in);
	        nodeNum = sc.nextInt();
	        edgeNum = sc.nextInt();
	        arr = new int[nodeNum+1][nodeNum+1]; // 연결되면 1 넣는 배열
	        visited = new boolean[nodeNum+1]; // 확인했냐?
	        int start = sc.nextInt();

	        for(int i=0; i<edgeNum; i++){
	            int a = sc.nextInt();
	            int b = sc.nextInt();
	          //양방향 그래프이므로 둘다 값을 받음
	            arr[a][b] = 1;
	            arr[b][a] = 1;
	        }
	        
	        visited[start]=true;
	        dfs(start);
	        System.out.println();
	        bfs(start);
	    }
}
