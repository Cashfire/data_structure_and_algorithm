package greedyAlgorithm;

import java.util.Arrays;

/**
 * Q: What should be put in your run-away backpack?
 * Assume the backpack's capacity is 150kg, and the treasure are:
 * weights are {35, 30, 60, 50, 40, 10, 25} in kg;
 * values are  {10, 40, 30, 50, 35, 40, 30} in thousand dollars;
 * 
 * @author Mao
 */
public class GreedyBackpack{

	void greedyBackpack(int[] weights, int[] values, int capacity){
		int n = weights.length;
		double rank[] = new double[n]; //highest unit value first, then 2nd
		int indx[] = new int[n]; //idx of highest unit value first, then 2nd
		
		//Firstly compute the unit value, then bubbleSort to get rank.
		for(int i = 0; i<n; i++){
			indx[i] = i; //set the indx to {0,1,2,3,4,5,6}
			rank[i] = (double)values[i]/weights[i];		
		}
		
		//bubbleSort(1st element keeps moving until meeting the smaller)
		double temp = 0;
		for(int i = 0; i < rank.length- 1; i++){
			for(int j = 0; j< rank.length- 1; j++){
				//decreasing order: the cheapest, the last. 
				if(rank[j] < rank[j+1]){
					//swap 
					temp = rank[j];
					rank[j] = rank[j+1];
					rank[j+1] = temp;
					//at the same time, record their old index.
					int tempId = indx[j];
					indx[j] = indx[j+1];
					indx[j+1] = tempId;
				}
			}
		}
		//new weights and values according the unit value.
		int[] w1 = new int[n];
		int[] v1 = new int[n];
		for(int i = 0; i < n-1; i++){
			int oldId = indx[i];
			w1[i] = weights[oldId];
			v1[i] = values[oldId];
		}
		
		//grab the most precious item which can be put into the backpack 
		int[] backpack = new int[n];
		int maxValue = 0;
		for(int i = 0; i<n; i++){
			if(w1[i] < capacity){
				backpack[i] = v1[i];
				maxValue += v1[i];
				capacity = capacity - w1[i];
			}
		}
		System.out.println("How many kg items?" + Arrays.toString(backpack));
		System.out.println("Now backpack weights "+ (150-capacity));
		System.out.println("and its value is " + maxValue);
		
	}

	
	public static void main(String[] args) {
		int[] weights={35, 30, 60, 50, 40, 10, 25};
		int[] values={10, 40, 30, 50, 35, 40, 30};
		GreedyBackpack  gb = new GreedyBackpack();
		gb.greedyBackpack(weights, values, 150);
	}

}
