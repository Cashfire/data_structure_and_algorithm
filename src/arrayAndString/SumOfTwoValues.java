/*
 * Given a value and an array of integers, 
 * determine if there are any 2 integers in the array which sum equal to the given value.
 */
package arrayAndString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SumOfTwoValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				int[] arr1 = {5,7,1,2,5,8,4,3};
				int sum = 10;
				
				TwoSumSolution ts = new TwoSumSolution();
				System.out.println("BruteForce: "+ Arrays.toString(ts.bruteForce(arr1, sum)));
				System.out.println("HashApproach: "+ Arrays.toString(ts.hashApproach(arr1, sum)));
				System.out.println("orderedSum: "+ Arrays.toString(ts.orderedSum(arr1, sum)));

	}
}

class TwoSumSolution{
	/* 
	 * Time complexity: O(n^2); Space complexity: O(1).
	 */
	int[] bruteForce(int[] arr, int val){
		for(int i = 0; i< arr.length; i++){
			for(int j = i +1; j < arr.length; j++){
				if(arr[j] == val - arr[i]){
					return new int[]{arr[i], arr[j]};
				}
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	/*
	 * Runtime complexity: O(n), Memory complexity: O(n).
	 */
	int[] hashApproach(int[]arr, int val){
		//create a new ArrayList, check the complement before adding
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(Integer num: arr){
			int complement = val - num;
			if(al.contains(complement)){
				return new int[] {complement, num};
			}
			al.add(num);
		}
		throw new IllegalArgumentException("No two sum solution");
	}
	
	int[] orderedSum(int[] arr, int val){
		 for(int i = 0, j = arr.length-1; i<j;){
			 int sum = arr[i] + arr[j];
			 if(sum == val){
				 return new int[] {arr[i], arr[j]};
			 }
			 
			 /*
			  * if the pair's sum < val, 
			  * means pair can only exist to the left of right element.
			  */	 
			 if(sum < val){
				 i++;
			 }
			 
			 /*
			  * if the pair's sum > val, 
			  * means pair can only exist to the right of left element.
			  */
			 if(sum > val){
				 j--;
			 }
		 }
		
		throw new IllegalArgumentException("No two sum solution");
	}
		
	
}













