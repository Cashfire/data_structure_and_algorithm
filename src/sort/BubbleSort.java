package sort;
/**
 * Bubble Sort: swapping the adjacent elements if wrong order.
 * complexity is O(N^2), use worst case like {(9,8,7,6)}.
 * 1st pass: {(9 8) 7 6}-{8 (9 7) 6}-{8 7 (6 9)}-{8 7 6 <9>} compare n-1 times;
 * 2nd pass: {(8 7) 6 <9>} -{7 (8 6) <9>}- {7 6 <8 9>} compare n-2 times;
 * 3rd pass: {(7 6) <8 9>}- {6 7 8 9} compare 1 time.
 * @author Mao
 *
 */
public class BubbleSort {
	
	void bubbleSort(int arr[]){
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length-1-i; j++){
				if(arr[j] > arr[j+1]){
					int max = arr[j];
					arr[j]= arr[j+1];
					arr[j+1]= max;
				}
			}
		}
	}
	
	public static void main(String[] args){
		int arr1[] = {9,8,7,6};
		BubbleSort bs = new BubbleSort();
		bs.bubbleSort(arr1);
		for(int num : arr1){
			System.out.println(num);
		}
	}
}
