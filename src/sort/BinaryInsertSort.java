package sort;

public class BinaryInsertSort {
	
	void binaryInsertSort(int arr[]){
		for(int i = 1; i < arr.length; i++){
			int temp = arr[i];
			int leftIndx = 0;
			int rightIndx = i-1;
			int midIndx = 0;
			while(leftIndx <= rightIndx){
				midIndx = (leftIndx + rightIndx)/2;
				if(temp > arr[midIndx]){
					leftIndx = midIndx + 1;
				}else{
					rightIndx = midIndx -1;
				}
			}
			
			for(int j = i-1; j>= leftIndx; j--){
				arr[j+1] = arr[j];			
			}
			arr[leftIndx] = temp;
		}
	}

	public static void main(String[] args) {
		int arr1[] = {3,2,6,9,10,2}; 
		BinaryInsertSort bis = new BinaryInsertSort();
		bis.binaryInsertSort(arr1);
		for(int num: arr1){
			System.out.print(num+",");
		}
	}

}
