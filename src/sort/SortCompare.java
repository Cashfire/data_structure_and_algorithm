package sort;

import java.util.Calendar;

public class SortCompare {
	//operation of array/object, will directly access and change them .
	//but for simple type(int,float,double), operation will not change them directly.
	public void test(int a){
		a++; 
	}
	
	public static void main(String[] args){
		int len = 80000;
		int arr80000[] = new int[len];
		for(int i = 0; i<len; i++){
			//Math.random() generates a pseudo-random float within [0,1)
			arr80000[i] = (int)(Math.random() * len);		
		}
		
		//use system time to check the time complexity
		Calendar cal = Calendar.getInstance();

		//Bubble sort
		System.out.println("BubbleSort starts at: "+cal.getTime());
		Bubble b = new Bubble();
		b.sort(arr80000);
		//Because of single status, need to renew a instance every time.
		cal = Calendar.getInstance();
		System.out.println("BubbleSort ends at: "+cal.getTime());
		//Select sort
		cal = Calendar.getInstance();
		System.out.println("SelectSort starts: "+cal.getTime());
		Select s = new Select();
		s.sort(arr80000);
		cal = Calendar.getInstance();
		System.out.println("SelectSort ends: "+cal.getTime());
		//sorting the array80000: SelectSort(1s) > BubbleSort(10s).
	}
}

class Bubble{
	void sort(int arr[]){
		for(int i = 0; i < arr.length; i++){
			for(int j = 0; j < arr.length-1-i; j++){
				if(arr[j] > arr[j+1]){
					int max = arr[j];
					arr[j]= arr[j+1];
					arr[j+1]= max;
				}
			}
		}
	}
}

class Select{
	void sort(int arr[]){
		int temp = 0;
		for(int i=0; i < arr.length-1; i++){
			int min = arr[i];
			int minIdx = i;
			for(int j = i+1; j < arr.length; j++){
				if(min > arr[j]){
					min = arr[j]; 
					minIdx = j;
				}
			}
			temp = arr[i];
			arr[i] = min;
			arr[minIdx] = temp;
		}
	
	}
}