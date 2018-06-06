package arrays;

public class Unique {
	public static void main(String[] args){
		String s1 = "AZazyYemao";
		//System.out.println(unique(s1));
		for(int i = 0; i<s1.length(); i++){
			int val = s1.charAt(i);
			System.out.println(val);
		}
		
		
	}
	static boolean unique(String str){
		boolean[] char_set = new boolean[128];		
		for(int i = 0; i< str.length(); i++){
			int val = str.charAt(i);
			if(char_set[val]){
				return false;
			}
			char_set[val] = true;
		}
				return true;
	}

	//static boolean isUnique
}

