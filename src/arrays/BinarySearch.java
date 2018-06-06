/*
 * Search a sorted array of integers, return the index of the given key. Return -1 if not found.
 */
package arrays;

public class BinarySearch {
	static int arr1[] = {1,10,20,47,59,63,75,88,99,107,120,133,155,162,176,188,199,200,210,222};
	int idx[]  =  {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};

/*binary_search_iterative
 * 	RC: Logarithmic, O(logn)
 *  MC: Logarithmic, O(logn)
 */ 
	static int binary_search_iterative(int key, int[] a, int low, int high){
		if(low > high){
			return -1;
		}else{
			int mid = (low + high)/2;
			System.out.println("mid is: "+mid);
			if(key == a[mid]){
				return mid;
			}else if(key < a[mid]){
				return binary_search_iterative(key, a, low, mid-1);
			}else{
				return binary_search_iterative(key, a, mid+1, high);
			}
		}
	}

 /*binary_search_recursive
  * RC: Logarithmic, O(logn)
  * MC: constant, O(1), which is better than recursive solution.
  */
	static int binary_search_recursive(int key, int[] a){
		int low = 0;
		int high = a.length -1;
		while(low <= high){
			int mid = (low+ high)/2;
			if(key == a[mid]){
				return mid;
			}
			if(key < a[mid]){
				high = mid -1;
			}else if(key > a[mid]){
				low = mid +1;
			}
		}
		return -1;		
	}
	
	public static void main(String[] args){
		System.out.println("The search result is: "+ binary_search_recursive(47, arr1));
		
	}
}
