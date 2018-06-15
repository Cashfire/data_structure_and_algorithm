package string;
/*
 * Given a string find all substrings that are palindromes. For instance,
 * string "aabbbaa" has 7 palindromes: aa, bb, bbb, abbba, aabbbaa, bb, aa,.
 */
public class PalindromeSubstrings {
	/*
	 * TC: O(n^3); ST: O(1).
	 */
	int naive_find(String str){
		int count = 0;
		for(int i = 0; i < str.length()-1; i++){
			for(int j = i+1; j < str.length(); j++){
				if(is_palindrome(str, i, j)){
					System.out.print(str.substring(i, j+1)+ ", ");
					count ++;
				}
			}
		}
		return count;
	}
	
	private boolean is_palindrome(String str, int i, int j) {
		// TODO Auto-generated method stub
		while(j > i){
			if(str.charAt(i) != str.charAt(j)){ return false;}
			i++;
			j--;
		}
		return true;
	}
	
	/*
	 * TC: O(n^2); ST: O(1).
	 */
	int even_odd_method(String str){
		int count = 0;
		
		for(int i = 0; i < str.length(); i++){
			//find all ODD length substring is palindrome centered with i.
			count += is_substring_palindrome(str, i-1, i+1);
			//find all EVEN length substring is palindrome centered with i.
			count += is_substring_palindrome(str, i, i+1);
		}
		return count;
	}
	
	
	private int is_substring_palindrome(String str, int j, int k) {
		// TODO Auto-generated method stub
		int count = 0;
		for(; j >= 0 && k < str.length(); j--, k++){
			if(str.charAt(j) != str.charAt(k)){
				break;
			}
			//if there is palindrome
			System.out.print(str.substring(j, k+1)+ ", ");
			count ++;
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mystr = "aabbbaa";
		PalindromeSubstrings ps = new PalindromeSubstrings();
//		int m1 = ps.naive_find(mystr);
//		System.out.println();
//		System.out.println("Naive method Found: " + m1);
		
//		int m2 = 
		ps.even_odd_method(mystr);
//		System.out.println();
//		System.out.println("Even_odd Method Found: "+ m2);
		
	}
	
	
	
	
	
	
	
	
	

}
