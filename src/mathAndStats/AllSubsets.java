/*
 * Find all subsets of a given set of integers. For example, all subsets of {2,5,7} should be:
 * {[], [2], [5], [2, 5], [7], [2, 7], [5, 7] ,[2, 5, 7]}
 * TC: o(2^n);
 * SC: o(2^n).
 */
package mathAndStats;

import java.util.ArrayList;

public class AllSubsets {
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] myArr = {2,5,7};
		
		pick_not_combine pnc = new pick_not_combine();
		ArrayList<ArrayList<Integer>> result = pnc.get_subsets(myArr);
		
//		bit_approach ba = new bit_approach();
//		ArrayList<ArrayList<Integer>> result = ba.get_all_subsets(myArr);
		
		for(int i = 0; i < result.size(); i++){
			System.out.println(result.get(i));
		}
		}
}


class pick_not_combine{
	public ArrayList<ArrayList<Integer>> get_subsets(int[] arr){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		for(int n : arr){
			int current_size = result.size();
			//it will print current_size = 1, 2, and 4.
//			System.out.println("current_size = "+current_size);
			for(int i = 0; i< current_size; i++){
				ArrayList<Integer> subset = new ArrayList<>(result.get(i));
				subset.add(n);
				result.add(subset);
			}
		}
		return result;
	}
}

class bit_approach{
	/* To determine whether we need include the integer on the position bit to our subset of numb.
	 * For example, when numb = 3 which is (0,1,1), get_bit(3,0) = 1, get_bit(3,1) = 1, and get_bit(3,2) = 0.
	 */
	
	int get_bit(int numb, int bit){
//		System.out.print("Runing get_bit(" + numb + ","+ bit+")");
		int temp = (1 << bit);
		temp = temp & numb;
		if(temp == 0){
			return 0;		
		}
		return 1;
	}
	
	ArrayList<ArrayList<Integer>> get_all_subsets(int[] v){	
		//for example, size of the set {2,5,7} = 3.
		int n = v.length;
		// the amount of subsets = 2^n = 2^3 = 8.
		int subsets_amount = (int) Math.pow((double)2, (double) n);
		ArrayList<ArrayList<Integer>> result = new ArrayList<>(subsets_amount);
		//for example, if i = 3, as (0,1,1), we should get the subset {5,7}.
		//if i=3 and j=0 , get_bit(3,0) should return 1 and the subset should contain "7";
		//if i=3 and j=1, get_bit(3,1) will return 1 and the subset should contain "5";
		// if i=3, when j=2, get_bit(3,2) will return 0 and the subset should NOT contain "2".
		for(int i = 0; i < subsets_amount; i++){
			ArrayList<Integer> subset = new ArrayList<>();
			for(int j = 0; j < n; j++){
				if(get_bit(i, j) == 1){
					subset.add(v[j]);
				}
			}
			result.add(subset);
		}	
		return result;
	}
	
}
