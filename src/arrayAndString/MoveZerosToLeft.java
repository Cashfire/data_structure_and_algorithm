/*Given an integer array, move all '0' to the left while maintaining elements' order in the array.
 * For example change the array {1, 0, 0, 3, 0 ,5} to {0,0,0,1,3,5}.
 * runtime complexity: o(n).
 * memory complexity: o(1).
 */
package arrayAndString;

import java.util.Arrays;

public class MoveZerosToLeft {
	static void move_zeros_to_left_in_array(int[] arr){
		if(arr == null){
			return;
		}
		
		int write_index = arr.length -1;
		int read_index = arr.length -1;
		
		while(read_index >= 0){
			if(arr[read_index] != 0){
				arr[write_index] = arr[read_index];
				write_index--;
			}
			read_index--;
		}
		//when read_index is 0, change the remaining parts to zeros
		while(write_index >=0){
			arr[write_index] = 0;
			write_index--;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1, 0, 0, 3, 0 ,5};
		move_zeros_to_left_in_array(A);
		System.out.println(Arrays.toString(A));
	}

}
