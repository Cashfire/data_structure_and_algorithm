/*
 * Given 3 sorted integer arrays in ascending order, find LCN of those 3 arrays.
 * Hint: take advantage of the sorted arrays to reduce complexity.
 * Runtime complexity: Linear, O(n);
 * Memory complexity: constant, O(1).
 */
package arrays;

public class LeastCommonNumber {
	public static int find_least_common_number(int[] a1, int[] a2, int[]a3){
		int i = 0, j=0, k=0;
		while(i<a1.length && j<a2.length && k<a3.length){
			//if find the LCN
			if(a1[i] == a2[j] && a1[i] == a3[k] ){
				return a1[i];
			}
			//use 3 iterators simultaneously to traverse the arrays,
			//always move the smallest iterator.
			if(a1[i] <= a2[j] && a1[i] <= a3[k] ){
				i++; //if a1[i] is the smallest than a2[j] and a3[k], move to the next in a1. 
			}
			else if(a2[j] <= a1[i] && a2[j] <= a3[k]){
				j++;
			}
			else if(a3[k] <= a1[i] && a3[k] <= a2[j]){
				k++;
			}
		}
		return -1; //The LCN doesn't exist
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {6,7,10,25,30,63,64};
		int[] arr2 = {-1,4,5,6,7,8,50};
		int[] arr3 = {1,6,10,14};
		System.out.println("Least Common Number is: "+find_least_common_number(arr1, arr2, arr3));
	}

}
