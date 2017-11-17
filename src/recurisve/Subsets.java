package recurisve;

import java.util.ArrayList;

/**
 * return all the subsets of a set.
 * @author Mao
 *
 */
public class Subsets {

	public static void main(String[] args) {
		ArrayList<String> set = new ArrayList<String>();
		set.add("a1");
		set.add("a2");
		set.add("a3");
		ArrayList<ArrayList<String>> sb = getSubsets(set, 0);
		System.out.print(sb);
		
		

	}
//	ArrayList<ArrayList<String>>
	static ArrayList<ArrayList<String>> getSubsets(ArrayList<String> al, int n){
		ArrayList<ArrayList<String>> allSub; 
		//end of recursion is 
		if(al.size()==n){
			allSub = new ArrayList<ArrayList<String>>();
			allSub.add(new ArrayList<String>()); //add a empty arraylist
		}else{
			allSub = getSubsets(al, n+1);
			String current= al.get(n);
			ArrayList<ArrayList<String>> delta = new ArrayList<ArrayList<String>>();
			for(ArrayList<String> a: allSub){
				ArrayList<String> newSubset = new ArrayList<String>();
				newSubset.addAll(a);
				newSubset.add(current);
				delta.add(newSubset);
			}
			allSub.addAll(delta);
		}
		return allSub;
	}
}
