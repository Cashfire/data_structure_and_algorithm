package string;
/*
 * Given a dictionary of words and an input string, 
 * determine whether the string can be completely segmented into dictionary words.
 * For example, dict = {"hello","mango","man","go","hell"}; string = "hellomango"-->return true.
 * TC:O(n^2);SC:O(n^2).
 * 
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringSegmentation {
	boolean can_seg(String str, Set<String> dict){
		Set<String> excluded = new HashSet<String>();
		return rec_seg(str, dict, excluded);
	}
	
	boolean rec_seg(String str, Set<String> dict, Set<String> excluded){
		//divide the string to 2 parts, comb and left. comb is a word can be found in dict.
		//if comb doesn't exist, return false.
		//For example, the comb of "abce" is "a" and remain = "bce"
		for(int i = 1; i <= str.length(); i++){
			String comb = str.substring(0, i);
			
			if(dict.contains(comb)){
				String remain = str.substring(i);
				//if no more elements are there, print it.
				if(remain == null || remain.length() == 0 || dict.contains(remain)){
					return true;
				}
				//if the dict doesn't contain remain, then check if the excluded contain remain or not.
				//if the excluded contains remain, not need to recurse and return false.
				//if excluded doesn't contain remain, then recurse it and add it to excluded.
				if(!excluded.contains(remain)){
					if(rec_seg(remain, dict, excluded)){
						return true;
					}
					excluded.add(remain);
					for(String s: excluded){
						System.out.print(s+" ");
					}
					System.out.println("");
				} 
					
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mystr = new String("hellonow"); //"abce"
		String[] words = {"hello","now","hell","on"} ; // {"a","ab", "abc","b","c"}
		Set<String> dict = new HashSet<String>(Arrays.asList(words));
//		System.out.println("Hashset contains: "+ dict );
		StringSegmentation ss = new StringSegmentation();
		System.out.println(ss.can_seg(mystr, dict));
	}

}
