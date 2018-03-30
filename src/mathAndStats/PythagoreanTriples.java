/* Given an integer array of positive integers, 
 * find all Pythagorean triples. (a^2 + b^2 = c^2).
 * Hint: sort
 * TC: O(n^2), ST:O(1).
 */
package mathAndStats;

import java.util.ArrayList;
import java.util.Arrays;

public class PythagoreanTriples {
	
	ArrayList<int[]> find_all_triples(int[] arr){
		Arrays.sort(arr);
		
		int n = arr.length;
		
		ArrayList<int[]> triples = new ArrayList<int[]>();
		
		// we can take advantage that: (c < a+ b), where c is the long line.
		for(int c = n-1; c >= 2; c--){
			System.out.println("c = "+ c);
			int squareC = arr[c] * arr[c];
			//initiate i and j, which are the other 2 short lines.
			int i = 0;
			int j = c - 1; // b is short line, so cannot longer than c.			
			while(i < j){
				int squareI = arr[i] * arr[i];
				int squareJ = arr[j] * arr[j];
				
				if(squareI + squareJ == squareC){
					System.out.println("When c= "+c+", triple is: "+arr[i]+", "+ arr[j]+", "+ arr[c]);
					triples.add(new int[]{arr[i], arr[j], arr[c]});
					break;
				}else if(squareI + squareJ < squareC){
					i++;
					//every short line should > long line - another short line.
					//if not, then end the while loop and start to check new c.
					if(arr[i] < arr[c] - arr[j]){ 
						break; } 
				}else if(squareI + squareJ > squareC){
					j--;
					if(arr[j] < arr[c] - arr[i]){
						break;
					}
				}
			}
		}
		
		return triples;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] lines = {17,3,4,5,16,9,10,12,13,14,15,6,8};
		PythagoreanTriples pt = new PythagoreanTriples();
		pt.find_all_triples(lines);
	}

}
