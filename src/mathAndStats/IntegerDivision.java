/*
 * Divide two integers without using '/' (division) or '*' (multiplication) operators.
 * For example: 7 ÷ 2 = 3, 5 ÷ 4 = 1, 1 ÷ 3 = 0.
 * TC: O(logn); SC: O(logn).
 */
package mathAndStats;

public class IntegerDivision {

	private int divide(int x, int y){	
		System.out.println("new division");//Why we will run this function twice??
		//x is dividend, y is divisor.
		//if divisor y = 0, it's undefined and return -1.
		if(y == 0){
			return -1;
		}else if(x== 0 || x < y){
			return 0;
		}else if(x == y){
			return 1;
		}else if( y == 1){
			return x;
		}
		//set quotient q and temp.
		int q = 1;
		int temp = y;
		
		while(temp < x){
			temp <<= 1; //the same as: temp = temp + temp.
			q <<= 1; // the same as: q = q+q;
		}
		
		if(temp > x){
			temp >>= 1; //same as: temp = temp/2;
			q >>= 1; //same as: q = q/2;
			return q + divide(x- temp, y);
		}
		
		return q;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerDivision iD = new IntegerDivision();
		int result = iD.divide(7, 3);
		System.out.println(result);
	}

}
