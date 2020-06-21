package 이진탐색;

public class BinarySearch {

	// 타겟의 인덱스를 인출하라. 없으면 -1을 인출하라
	
	public static int binarySearch(int[] list, int target) {
		return binarySearch(list, target, 0, list.length);
	}
	
	public static int binarySearch(int[] list, int target, int low, int high) {
	    if (low > high)
	        return -1; // 탈출하는 순간;
	    int mid = (low + high) / 2;
	    if (list[mid] == target)
	        return mid;
	    else if (list[mid] > target)
	        return binarySearch(list, target, low, mid-1);
	    else
	        return binarySearch(list, target, mid+1, high);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] list = {0,1,2,3,4,5,6,7};
		
		System.out.println(binarySearch(list,6));
		
	}

}
