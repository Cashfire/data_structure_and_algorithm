/*
 * given a collection of intervals, merge all overlapping intervals.
 * For example, 
 * Given (1,5), (6,10), (4,7), (15,17), (16,20),
 * return (1,10), (15,20).
 */
package arrayAndString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Tuple{
	int x, y;
	Tuple() { x = 0; y = 0;}
	Tuple(int X, int Y) { x = X; y = Y;}
	// cannot printing without the toString() method
	public String toString(){ return "("+ x + ","+y+ ")";}
}

class SortbyStartPoint implements Comparator<Tuple>{
	public int compare(Tuple t1, Tuple t2){
		return t1.x - t2.x;
	};
}

public class OverlappingIntervals {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Tuple> al = new ArrayList<Tuple>();
		al.add(new Tuple(1,5));
		al.add(new Tuple(6,10));
		al.add(new Tuple(4,7));		
		al.add(new Tuple(15,17));
		al.add(new Tuple(16,20));
		System.out.println("The ArrayList of Tuple is: "+al);
		
		Collections.sort(al, new SortbyStartPoint());
		System.out.println("The sorted ArrayList is: " + al);

		
		OverlappingIntervals oli = new OverlappingIntervals();
		ArrayList<Tuple> result = oli.merge_intervals(al);

		
        for (int i=0; i< result.size(); i++)
            System.out.println(result.get(i).toString());

	}
	
	ArrayList<Tuple> merge_intervals(ArrayList<Tuple> tuples) {
		if(tuples == null || tuples.isEmpty()) {
		    return tuples;
		  }
		
		ArrayList<Tuple> v2 = new ArrayList<Tuple>();
		
		v2.add(new Tuple(tuples.get(0).x, tuples.get(0).y));
		
		for(int i = 1 ; i < tuples.size(); i++) {
		    int x1 = tuples.get(i).x;
		    int y1 = tuples.get(i).y;
		    int start = v2.get(v2.size() - 1).x;
		    int end = v2.get(v2.size() - 1).y;

		    if(x1 <= end) {
		      v2.get(v2.size()-1).y = Math.max(y1, end);
		    } else {
		      v2.add(new Tuple(x1, y1));
		    }
		  }
		
		  return v2;
		}

		  
}

