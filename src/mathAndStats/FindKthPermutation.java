/*
 * Given a sorted set of n elements find the lexicographically kth permutation.
 * TC: O(n), 
 * SC: O(n).
 */
package mathAndStats;

import java.util.ArrayList;
import java.util.List;

public class FindKthPermutation {
	static List<Character> result = new ArrayList<Character>(); 
	
	int get_factorial(int k){
		if(k == 0|| k==1) return 1;
		return k*get_factorial(k-1);
	}
	
	void get_permutation(int k, List<Character> v){
		if(v.isEmpty()) return;
			
		int n = v.size();
		//block_size is the permutation amount when 1 char is fixed.
		int block_size = get_factorial(n-1);
		int select_id = (k-1)/ block_size;
		Character selected = v.get(select_id);
		result.add(selected);
		//update v, n and k.
		v.remove(select_id);
		k = k - (block_size * select_id);
		get_permutation(k, v);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Character> mylist = new ArrayList<Character>(); 
		mylist.add('1');
		mylist.add('2');
		mylist.add('3');
		mylist.add('4');
		FindKthPermutation fkp = new FindKthPermutation();
		int u = 8;
		fkp.get_permutation(u, mylist);
		String s = fkp.result.toString();
		System.out.println(s);
		
    }


	
	
}

