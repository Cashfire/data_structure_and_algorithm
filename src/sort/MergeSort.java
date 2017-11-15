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
		int length = r-l+1;
		int temp[] = new int[length];
		int i = l;
		int j = m+1;
		int k = 0; //index of the temp array.
		while(i <= m && j <=r){
			if(arr[i]<arr[j]){
				temp[k] = arr[i];
				i++;
				k++;			
			}else{
				temp[k] = arr[j];
				j++;
				k++;
			}
		}
		//if the left part of arr still remains
		while(i<=m){
			temp[k] = arr[i];
			i++;
			k++;
		}
		while(j<=r){
			temp[k] = arr[j];
			j++;
			k++;
		}
		
		k = 0;
		for(int x= l; x<=r; x++, k++){
			arr[x]= temp[k];
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
