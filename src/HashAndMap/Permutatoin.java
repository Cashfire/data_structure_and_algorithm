package HashAndMap;

import java.util.HashMap;
import java.util.Map;

public class Permutatoin {
	public static void main(String[] args) {
		System.out.println(permutation("aabbc", "bbcaae"));
	}
	
	public static boolean permutation(String a, String b) {
		HashMap<Character, Integer> counter = new HashMap<Character, Integer>();
		for(int i = 0; i < a.length(); i++) {
			if(counter.containsKey(a.charAt(i))) {
				int c = counter.get(a.charAt(i));
				counter.put(a.charAt(i), c + 1);				
			} else {
				counter.put(a.charAt(i), 1);
			}
		}
		for(int i = 0; i < b.length(); i++) {
			if(counter.containsKey(b.charAt(i))) {
				int c = counter.get(b.charAt(i));
				counter.put(b.charAt(i), c - 1);				
			} else {
				counter.put(b.charAt(i), -1);
			}
		}
		for (Map.Entry<Character, Integer> entry : counter.entrySet()) {
			if(entry.getValue() != 0) {
				return false;
			}
		}
		return true;
	}
}
