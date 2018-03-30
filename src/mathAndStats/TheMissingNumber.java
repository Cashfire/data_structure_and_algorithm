/*
 * Given an array with element from 1 to n, but one number is missing, find the missing number.
 * For example, {3,7,1,2,8,4,5}, find 6.
 * TC: O(n); SC: O(1).
 */
package mathAndStats;

public class TheMissingNumber {

	int find(int[] arr){
		int curr_sum = 0;
		for(int i : arr){
			curr_sum += i;
		}
		
		//n != arr.length, because one number is missing.
		int n = arr.length + 1;
		int expect_sum = n*(n+1)/2;
		
		return (expect_sum - curr_sum);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myArr = {3,7,1,2,8,4,5};
		TheMissingNumber tmn = new TheMissingNumber();
		System.out.println(tmn.find(myArr));
	}

}
