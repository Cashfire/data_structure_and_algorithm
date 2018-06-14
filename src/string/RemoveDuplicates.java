package string;
/*
 * Remove duplicate characters from a string.
 */
import java.util.Arrays;
import java.util.HashSet;

public class RemoveDuplicates {
	/*
	 * TC:Quadratic, O(n^2)
	 * SC:O(1).
	 */
	String brute_force(String str){
		if(str == null ||str.length() == 1) return str;
		char[] arr = str.toCharArray();
		//start from the second char to check the duplicate
		int write_idx = 1;
		for(int i = 1; i < arr.length; i++){
			boolean found = false;
			
			for(int j= 0; j < write_idx; j++){
				if(arr[i] == arr[j]){
					found = true;
					break;
				}
			}
			
			if(!found){
				arr[write_idx] = arr[i];
				write_idx++;
			}
		}
		arr = Arrays.copyOfRange(arr, 0, write_idx);
		return new String(arr);
	}
	
	String hashSet_method(String str){
		if(str == null ||str.length() == 1) return str;
		char[] arr = str.toCharArray();
		HashSet<Character> hs = new HashSet<Character>();
		int write_idx = 0;//always point to what we will rewrite
		int read_idx = 0;

		while(read_idx < arr.length){
			if(! hs.contains(arr[read_idx])){
				hs.add(arr[read_idx]);
				arr[write_idx] = arr[read_idx];	//rewrite 
				write_idx++;  //move to the next that will be processed.
			}
			read_idx++;
		}	
		
		arr = Arrays.copyOfRange(arr, 0, write_idx);
		return new String(arr);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mystr = "dabbac";

		RemoveDuplicates rd = new RemoveDuplicates();
		mystr = rd.brute_force(mystr);
//		mystr = rd.hashSet_method(mystr);
		System.out.println(mystr);
	}

}
