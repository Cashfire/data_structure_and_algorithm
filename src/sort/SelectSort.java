package sort;
/**
 * selectSort: swap the min and the 1st element, then 2nd-min and 2nd element.
 * complexity is O(N^2).
 * {[1, 6, -2, 5]}; n ->find{[1,6,'-2',5]} ->swap{'-2', 6, '1', 5};
 * {-2, [6, 1, 5]};  n-1 ->find{-2,[6,'1',5]} ->swap{-2, '1', '6', 5} ;
 * {-2, 1, [6, 5]}; ... ->find{-2, 1, [ 6,'5']} ->swap{-2, 1, '5', '6'}
 * {-2, 1, 5, 6};   1
 * @author Mao
 *
 */
public class SelectSort {
	
	 void selectSort(int arr[]){
		for(int i=0; i < arr.length-1; i++){
			int min = arr[i];
			int minIdx = i;
			//get the min of the partial array from i+1 to n.
			for(int j = i+1; j < arr.length; j++){
				if(min > arr[j]){
					min = arr[j]; 
					minIdx = j;
				}
			}
			//when i = 0, we renew the array to {-2, 6, 1, 5};
			//when i=1, we renew the array to   {-2, 1, 6, 5}...
			arr[minIdx] = arr[i];
			arr[i] = min;
		}
	}
	 
		public static void main(String[] args) {
			int arr1[] = {1, 6, -2, 5};
			SelectSort ss = new SelectSort();
			ss.selectSort(arr1);
			for(int num : arr1){
				System.out.println(num);
			}	
		}
}
