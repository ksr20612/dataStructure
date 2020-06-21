package 버블정렬;

public class bubble {
	
	public static int[] bubbleSort(int[] list) {
		
		for(int i=0;i<=list.length-1;i++) {
			boolean swap = false; // 아예 정렬이 안되었으면 애초에 정렬이 필요없는 거니까 탈출
			for(int j=0;j<=list.length-2-i;j++) {
				if(list[j]>list[j+1]) {
					int temp = list[j];
					list[j] = list[j+1];
					list[j+1] = temp;
					swap = true;
				}
			}
			if(swap==false) break;
		}
		
		return list;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] list = {5,3,6,2,4,7,8};
		
		int[] ans = bubbleSort(list);
		
		for(int i=0;i<=ans.length-1;i++) {
			System.out.println(list[i]);
		}
		
	}

}
