package string;

import java.util.Arrays;

/*Given a string, remove any white spaces (tabs or spaces).
 * Note: Null terminated strings are not used in Java like C or C++.
 * TC: linear, O(n).
 * SC: constant, O(1).
 */
public class RemoveWhiteSpace {
	//why this function cannot directly be set as void and directly change the s?????
	void remove(String s){
		char[] arr = s.toCharArray(); 
		int n = arr.length;
		int read_ptr = 0;
		int write_ptr = 0;
		while(read_ptr < n){
			//determine whether the character is a space of not.
			if(!is_white_space(arr[read_ptr])){
				arr[write_ptr] = arr[read_ptr];
				write_ptr ++;
			}
			read_ptr ++;	
		}
		//subset those non-white-space characters
		char[] sub = Arrays.copyOfRange(arr, 0, write_ptr);
		s = new String(sub);
		System.out.println(s);
		System.out.println("Its length = " + s.length());
	}
	
	boolean is_white_space(char c){
		//there are a lot kinds of white space characters,
		//but for simplicity, let's assume that we have 2 kind.
		if(c == ' ' || c == '\t' || c == '\n'){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String mystr = " I "+ '\t' + "Love Coding"+'\n';
		System.out.println("Original length = "+ mystr.length());
		RemoveWhiteSpace rws  = new RemoveWhiteSpace();
		rws.remove(mystr);
		
	}

}
