package arrayAndString;

import java.util.Arrays;

public class Permutation {
	static String s1 = "good", s2 = "doog";	
	public static void main(String[] args){
		//Good(71,111,111,100), and doog(100,111,111,103).
		/*
		int[] i1 = new int[3];
		int [] i2 = {0,0,0};
		System.out.println(i1.equals(i2));//False
		System.out.println("i1=i2?"+Arrays.equals(i1, i2));//true
		*/

		System.out.println(permutation(s1, s2));
		}
		
	
	static String sort(String str){
		//If we should ignore the uppercase 
		str = str.toLowerCase();
		//1, change the string to a char array,
		char[] arr = str.toCharArray();
		//2, use the Array.sort(), Complexity at least nlgn
		Arrays.sort(arr);
		str = new String(arr);
		System.out.println(str);
		return str;
	}
	static //without the Array.sort() method
	boolean permutation(String s, String t){
		if(s.length() != t.length()){
			return false;
		}
		
		int[] intArray= new int[128];
		char[] charArray1 = s.toCharArray();
		for(char c : charArray1){
			System.out.println(c);
			intArray[c]++;
		}
		for(int i = 0; i< t.length(); i++){
			int b = (int)t.charAt(i);
			intArray[b]--;
			if(intArray[b] < 0){
				return false;
			}
		}
		return true;
		
	}
}

