package sort;

public class MergeSort {
	
    void mergeSort(int arr[], int l, int r){
        if (l < r){
            int m = (l+r)/2;

            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);
            merge(arr, l, m, r);
        }
    }
    
	void merge(int arr[], int l, int m, int r){
        // Find sizes of 2 subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temporary arrays */
        int ltArr[] = new int [n1];
        int rtArr[] = new int [n2];
 
        /*Copy data to temp arrays*/
        for(int i=0; i< n1; ++i)
            ltArr[i] = arr[l + i];
        for (int j=0; j< n2; ++j)
            rtArr[j] = arr[m + 1+ j];
 
        /* Merge the 2 temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        int k = l;// Initial index of merged array
        while (i < n1 && j < n2){
            if (ltArr[i] <= rtArr[j]){
                arr[k] = ltArr[i];
                i++;
            }
            else{
                arr[k] = rtArr[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of ltArr[] if any */
        while (i < n1){
            arr[k] = ltArr[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2){
            arr[k] = rtArr[j];
            j++;
            k++;
        }
    }
 
 
	public static void main(String[] args) {
		int arr1[] = {38, 27, 43, 3, 9, 82, 10};
		MergeSort ms = new MergeSort();
		ms.mergeSort(arr1, 0, arr1.length-1);
		for(int num : arr1){
			System.out.print(num+", ");
		}

	}

}
