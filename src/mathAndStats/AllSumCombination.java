/* 
 * For example, given a target 5 and start 2, one combination (2,3) should be printed，
 * Given target = 6 and start = 2, combinations {(2,2,2),(2,4),(3,3)} should be printed.
 * TC: O(n^n) Exponential; SC: O(n).
 */

package mathAndStats;

import java.util.ArrayList;

public class AllSumCombination {
	
	ArrayList<Integer> aComb = new ArrayList<Integer>();
	
	private void fina_all_sum(int target, int start){
		if(start <= 0){
			System.out.println("Start should be positive integer!");
			return;
		}
		find_all_sum_rec(target, start, 0);
	}
	
	private void find_all_sum_rec(int target,int start,int current_sum){
		if(current_sum == target){
			printArrayList(aComb);
		}
		
		for(int i = start; i < target; i++){
			int temp_sum = current_sum + i;
			if(temp_sum <= target){
				this.aComb.add(i);
				find_all_sum_rec(target, i, temp_sum);
				this.aComb.remove(aComb.size()-1);		
			}else{
				return;
			}
		}
	}
	
	void printArrayList(ArrayList<Integer> v){
		for(int i:v){
			System.out.print(i +" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		AllSumCombination asc = new AllSumCombination();
		asc.fina_all_sum(4, 1);
		
	}

	

}
