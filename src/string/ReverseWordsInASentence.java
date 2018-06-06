package string;
/*
 * Given a sentence, reverse the order of words.
 * For example, "I love you." -> "you. love I"
 * TC:Linear, O(n). Position of all the elements in the sentence is changed;
 * SC:Constant, O(1).The solution reverses every word in-place i.e. it does not require any extra space.
 */
public class ReverseWordsInASentence {
	String reverseWords(String s){
		if(s == null) return null;
		char[] a= s.toCharArray();
		int n = a.length;
		//step1, reverse the string, to "uoy_evol_I"
		reverse(a, 0, n-1);
		
		//step2, reverse each word, to 
		reverseAWord(a,n);
		
		//step3, return the reversed string.
		//s = a.toString();
		return new String(a);		
	}
	
	private void reverseAWord(char[] a, int n) {
		int start = 0;
		int end = start;
		while(end < n-1){
			end = start + 1;
			//find the first index of the word.
			while(a[start] == ' '){
				start++;
			}
			//find the end index of the word.
			while(end < n && a[end] != ' '){
				end++;
			}
			//reverse the word in place.
			reverse(a, start, end-1);
			//move to next word.
			start = end;
		}
	}
	
	private void reverse(char[] a, int start, int end) {
		while(start < end){
			char t = a[start];
			a[start] = a[end];
			a[end] = t;
			start++;
			end--;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "I love you.";
		ReverseWordsInASentence rwis = new ReverseWordsInASentence();
		s = rwis.reverseWords(s);	
		System.out.println(s);
		
		}

}
