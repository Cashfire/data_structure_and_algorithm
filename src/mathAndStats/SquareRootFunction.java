/* Given 
 * Square root sr of n is always between 0 and (n/2)+1, that is:  0 < sr < (n/2)+1.
 */
package mathAndStats;

public class SquareRootFunction {
	private static final double EPSILON = 0.00001;
	/*
	 * TC: Logarithmic, O(logn); SC: Constant, O(1).
	 */
	static double iterate_approach(double n){
		//mathematical fact: the sqr must be in the range: 0< sqr < (n/2)+1 ,for any n>1.
		double low = 0;
		double high = (n/2) + 1;
		//approximate the guess to sqr through by divide-and-conquer.
		while(low < high){
			double guess = (low + high)/ 2;
			double sqr = guess* guess;
			double diff = Math.abs(sqr - n);
			if(diff <= EPSILON){
				return guess;
			}else if(sqr < n){
				low = guess;
			}else if(sqr > n){
				high = guess;
			}
		}
		return -1;
	}
	
	/*
	 * TC: Logarithmic, O(logn); SC: O(logn).
	 */
	private static double recursive_approach(double n, double low, double high){		
		double guess = (low + high)/ 2;
		double sqr = guess * guess;
		double diff = Math.abs(sqr - n);
		if(diff <= EPSILON){
			return guess;
		}
		if(sqr < n){
			return recursive_approach(n, guess, high);
		}else{
			return recursive_approach(n,low, guess);
		}
	}
	private static double recursive_approach(double n) {
		return recursive_approach(n, 0, 1+(n/2));
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("The square root of 9 = "+ recursive_approach(16));
		System.out.println("The square root of 9 = "+ iterate_approach(16));
		
	}

}
