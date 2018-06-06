/*
 * find the index of a key in a rotated array, assuming all the keys of the array are unique.
 * Hint: there must be one side of the array is not strictly ascending.Like we want find the id of 2
 * {5,1,2,3,4}, the first part is not ascending (5>2), the second part is strictly ascending;
 * {4,5,1,2,3}, the first part is not ascending (4>1), the second part is strictly ascending;
 * {3,4,5,1,2}, the 2nd part is not ascending (5<2), the 1st part is strictly ascending;
 */
package arrays;

public class SearchRotatedArray {

	public static int binary_search(int[] arr, int st, int end, int key){
		//
		if(st > end){
			return -1;
		}
		
		int mid = st + (end- st)/2;
//		System.out.println("mid is: " + mid);
		
		//situation: find the key which is the mid, return the index.
		if(arr[mid] == key){
			return mid;
		}
		
		//situation 1: the first half is ascending and the key is in this part.
		if(arr[st] < arr[mid] && key< arr[mid] && key >= arr[st]){
			return binary_search(arr, st, mid-1, key);
		}
		//situation 2: the second half is ascending and the key is in this part.
		else if(arr[end] > arr[mid] && key< arr[end] && key >= arr[mid]){
			return binary_search(arr, mid+1, end, key);
		}
		/*
		 * If the above situation is not true, than the case is: 
		 * either the key in the unsorted 2nd half, or in the unsorted 1st half
		 */
		else if(arr[st] > arr[mid]){
			return binary_search(arr, st, mid-1, key);
		}
		else if(arr[mid] > arr[end]){
			return binary_search(arr, mid+1, end, key);
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] myArr = {5,1,2,3,4};
		int k = 1;
		// TODO Auto-generated method stub
		System.out.println("the index is: " + binary_search(myArr,0, myArr.length-1, k));
	}

}
