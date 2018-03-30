/*
 * 
 */
package mathAndStats;

public class PermuteString {
	void permute(String str){
		permute(str.toCharArray(), 0,str.length()-1);
	}
	void permute(char[] input, int start_idx, int end_idx){
		if(start_idx == end_idx){
			System.out.print(input);
			System.out.println();
			return;
		}
		
		for(int curr_idx = start_idx; curr_idx <= end_idx; curr_idx++){
			swap(input, start_idx, curr_idx);			
			permute(input, start_idx + 1, end_idx);
			swap(input, start_idx, curr_idx);
		}
	}
	private void swap(char[] input, int i, int j) {
		// TODO Auto-generated method stub		
		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abcd";
		PermuteString ps = new PermuteString();
		ps.permute(str);
	}

}
