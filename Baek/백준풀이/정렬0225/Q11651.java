package 정렬0225;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q11651 {

	static class Node {
		
		int x;
		int y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void sort(Node[] list) {
		
		for(int i=0;i<=list.length-1;i++) {
			for(int j=0;j<=list.length-2-i;j++) {
				if(list[j].y>list[j+1].y) {
					Node temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
				}else if(list[j].y==list[j].y) {
					if(list[j].x>list[j+1].x) {
						Node temp2 = list[j];
						list[j] = list[j+1];
						list[j+1] = temp2;
					}
				}
			}
		}
		
		// 출력
		for(int i=0;i<=list.length-1;i++) {
			System.out.println(list[i].x+" "+list[i].y);
		}	
	
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Node[] list = new Node[n];
		
		for(int i=0;i<=n-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			Node node = new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			list[i] = node;
		}
		
		sort(list);
	}

}
