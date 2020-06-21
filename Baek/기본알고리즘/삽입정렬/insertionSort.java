package 삽입정렬;

public class insertionSort {

	public static int[] insertionSort(int[] list) {
		
		for(int i=1;i<=list.length-1;i++) {
			for(int j=i;j>=1;j--) {
				if(list[j]<list[j-1]) {
					int temp = list[j];
					list[j] = list[j-1];
					list[j-1] = temp;
				}else break;
			}
		}
		
		return list;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] list = {5,4,3,2,1};
		
		int[] ans = insertionSort(list);
		
		for(int i=0;i<=ans.length-1;i++) {
			System.out.println(ans[i]);
		}
	}

}
