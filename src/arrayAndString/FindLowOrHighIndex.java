/*
 * Given a sorted array of integers, return the low/high index of the given key. 
 * Return -1 if not found. The array length can be in millions with lots of duplicates.
 * For example: {1,2,5,5,5,5,5,5,5,5,20}
 * If key = 1, then low = 0 and high = 0.
 * If key = 2, then low = 1 and high = 1.
 * If key = 5, then low = 2 and high = 9.
 * Runtime Complexity: O(log n).
 * Memory complexity: O(1).
 */

package arrayAndString;

public class FindLowOrHighIndex {
	static int find_low_index(int[] arr, int key){
		int low = 0; 
		int high = arr.length -1;
		int mid = high/2;
		
		while(low <= high){
			int mid_elem = arr[mid];
			if(mid_elem >= key){
				high = mid -1;
			}
			else{
				low = mid + 1;
			}
			mid = (low + high)/2;
		}
		
		if(arr[low] == key){
			return low;
		}
		
		return -1;	
	}
	
	static int find_high_index(int[] arr, int key){
		int low = 0; 
		int high = arr.length -1;
		int mid = high/2;
		
		while(low <= high){
			int mid_elem = arr[mid];
			if(mid_elem <= key){
				low = mid + 1;
			}
			else{
				high = mid - 1;
			}
			mid = (low + high)/2;
		}
		
		if(arr[high] == key){
			return high;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {1, 2, 2, 3, 3};
		int k = 3;
		System.out.println("Low index of " + k+ " is: "+ find_low_index(arr1, k));
		System.out.println("Hight index of " + k+ " is: "+ find_high_index(arr1, k));
	}

}
