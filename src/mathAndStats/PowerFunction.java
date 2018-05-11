/*
 * Given a double 'x' and an integer 'n'. Write a function to calculate 'x' raised to the power 'n'.
 * A simple algorithm of this problem is to multiply 'x' by 'n' times, whose TC would be O(n).
 * Divide and conquer approach. TC:O(log n), SC: O(log n)
 */
package mathAndStats;

public class PowerFunction {

	double power(double x, int n){
		boolean is_negative = false;
		if(n < 0){
			is_negative = true;
			n *= -1;
		}
		
		double result = power_rec(x, n);
		if(is_negative){
			return 1/result;
		}
		return result;
	}
	
	private double power_rec(double x, int n) {
		if(n == 0) return 1;
		if(n == 1) return x;
		
		double temp = power_rec(x, n/2);
		if(n % 2 == 0){
			return temp*temp;
		}else{
			return temp*temp*x;
		}
	}

	public static void main(String[] args) {
		PowerFunction pf = new PowerFunction();
		System.out.println("3^5 = " + pf.power(3, 5));
	}

}
