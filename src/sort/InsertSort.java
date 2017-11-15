package sort;

public class InsertSort {

	void sort(int arr[]){
		
		for(int i = 1; i < arr.length; i++){
//			System.out.println("Round " +i+" starts:");
			int temp = arr[i];
			int j;
			 /* Move elements of arr[0..i-1], that are
	          greater than key, to one position ahead
	          of their current position */
			for(j = i-1;j >= 0; j--){
				if(arr[j] > temp){
					arr[j+1] = arr[j];
				}else{
					break;
				}			
			}
			arr[j+1] = temp;
			
//			for(int num: arr){
//				System.out.print(num+", ");
//			}
//			System.out.println();
			
		}	
	}
	
	public static void main(String[] args) {
		int arr1[] = {1,6,0,-2};
		
		InsertSort is= new InsertSort();
		is.sort(arr1);
		
		for(int num: arr1){
			System.out.print(num+", ");
		}

	}

}
