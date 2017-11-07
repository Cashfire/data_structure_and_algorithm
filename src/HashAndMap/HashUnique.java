package HashAndMap;

import java.util.HashSet;

public class HashUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1= "abcdfea";
		System.out.println(hashTableUnique(s1));

	}
	static boolean hashTableUnique(String str){
		HashSet<Character> hs = new HashSet<Character>();
		for( int i =0; i <str.length(); i++){
			if(hs.contains(str.charAt(i))){
				return false;
			}else{
				
				hs.add(str.charAt(i));
			}
		}
		return true;
	}
}
