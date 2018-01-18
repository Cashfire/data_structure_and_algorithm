package arrayAndString;

import java.util.ArrayDeque;

public class FindMaxInEachWindow {
	//runtime complexity: O(n log w).
	public static void find_max_sliding_window(int[] array, int window_size){
		if(array.length < window_size){
			return;
		}
		
		ArrayDeque<Integer> window = new ArrayDeque<Integer>();
		//find out max for the 1st window
		for(int i = 0; i < window_size; i++){
			while(!window.isEmpty() && array[i] >= array[window.peekLast()]){
				window.removeLast();		
			}
			window.addLast(i);
		}
		System.out.println("The max of the window 1 is: "+ array[window.peekFirst()]);
		
		for(int i = window_size; i < array.length; i++){
			while(!window.isEmpty() && array[i] >= array[window.peekLast()]){
				window.removeLast();		
			}
			window.addLast(i);
			
			//remove the first number if it doesn't fall in the window anymore
			if(window.peekFirst() <= i-window_size){
				window.removeFirst();
			}
			System.out.println("The max of the window "+ (i-1)+ " is: "+ array[window.peekFirst()]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {-4, 2, -5, 3, 1, -1, 6};
		int w= 3;
		find_max_sliding_window(arr, w);
	}

}
