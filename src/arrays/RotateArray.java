/*
 * 
 */

package arrays;

import java.util.*;

public class RotateArray {
	static void reverse_array(List<Integer> arr, int start, int end){
		while( start < end){
			int temp = arr.get(start);
			arr.set(start, arr.get(end));
			arr.set(end, temp);
			start++;
			end--;
		}
	}
	static void rotate_array_in_place(List<Integer> arr, int n){
		int len = arr.size();
		//Normalization in case n>array or n is negative
		n = n % len;
		if( n < 0){
			n = n + len;
		}
		//Partition the array based on rotation n.
		// for example: 1,2,3,4,5 where n=2.
		// -> 5, 4, 3, 2, 1
		// -> 4, 5, 3, 2, 1
		// -> 4, 5, 1, 2, 3
		reverse_array(arr, 0, len-1);
		reverse_array(arr, 0, n-1);
		reverse_array(arr, n, len-1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		ArrayList<Integer> arrL = new ArrayList<Integer>();
		for(int i = 1; i < 6; i++){
			arrL.add(i);
		}
		rotate_array_in_place(arrL, 2);
		System.out.println("Roatated array is: " + arrL);
	}

}
