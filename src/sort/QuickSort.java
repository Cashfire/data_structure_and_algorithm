package sort;
/*
 * This function takes last element as pivot,
    places the pivot element at its correct
    position in sorted array, and places all
    smaller (smaller than pivot) to left of
    pivot and all greater elements to right
    of pivot
 */
public class QuickSort {
	int partition(int arr[], int left, int right)
	 {
	     int pivot = arr[right]; 
	     int i = (left-1); // index of smaller element
	     for (int j=left; j<right; j++)
	     {
	         //like(5,7,2,1,'3'),it will do noting until 2<3.
	    	 //when(2<3),i=0, j=2, ,swap a[0] and a[2], so (2,7,5,1,'3')
	    	 //when(1<3),i=1, j=3, ,swap a[1] and a[3], so (2,1,5,7,'3')
	         if (arr[j] <= pivot)
	         {
	             i++;
	             int temp = arr[i];
	             arr[i] = arr[j];
	             arr[j] = temp;
	         }
	     }
	     //arr[i] will be always smaller than pivote
	     // swap arr[i+1] and the pivot,so (2,1,'3',7,5)
	     int temp = arr[i+1];
	     arr[i+1] = arr[right];
	     arr[right] = temp;
	     //now a[i+1] is fixed in position i+1
	     return i+1;
	 }

	 void sort(int arr[], int low, int high)
	 {
	     if (low < high)
	     {
	         int pi = partition(arr, low, high);
	         //pi is partitioning index, arr[pi] is now at right place.
	         
	         // Recursively sort elements before and after arr[pi]
	         sort(arr, low, pi-1);
	         sort(arr, pi+1, high);
	     }
	 }
		
		   
	public static void main(String[] args) {
		int arr[] = {5, 7, 2, 1, 3};
        int n = arr.length;
 
        QuickSort ob = new QuickSort();
        ob.sort(arr, 0, n-1);
        for(int num:arr){
        	System.out.print(num+", ");
        }
	}
 
}
