package arrays;


public class Compress {
	
	public static void main(String[] args) {
		String str1 = "aabcccccaaa";
		compress(str1);

	}
	static String compress(String s){
		int count = 0;
		StringBuilder temp = new StringBuilder();
		for(int i = 0; i< s.length(); i++){
			count ++;
			if(i+1>=s.length() || s.charAt(i)!=s.charAt(i+1) ){
				temp.append(s.charAt(i));
				temp.append(count);
				count = 0;			
			}
		}
		System.out.println(temp.toString());
		return temp.toString();		
	}
}
