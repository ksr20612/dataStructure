package 선택정렬;

public class selectionSort {

	public static int[] selectionSort(int[] list) {
		
		for(int i=0;i<=list.length-2;i++) {
			int min = i;
			
			for(int j=i+1;j<=list.length-1;j++) {
				if(list[j]<list[min]) {
					min = j;
				}
			}
			
			int temp = list[i];
			list[i] = list[min];
			list[min] = temp;
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] list = {5,3,7,2,4,9};
		
		int[] ans = selectionSort(list);
		
		for(int i=0;i<=ans.length-1;i++) {
			System.out.println(ans[i]);
		}
	}

}
