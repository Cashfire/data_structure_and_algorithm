package dynamicProgramming;

/**
 * A child's running up a staircase with n steps and can hop 1, 2 or 3 steps at a time.
 * How many possible ways the child can run up the stairs.
 * @author Mao
 * 1, describe the world: 
 * p(i) = at step i, how many possible ways the child has .
 *2, formula: p(i) = p(i+1)+p(i+2)+p(1+3).
 *3, initiation: p(n) = 0, p(n-1) = 1,  
 */
public class TripleStep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int p[] = new int[n];
		//initiation
		p[n-1] = 1; //only 1 possible way is running up 1 steps.
		p[n-2] =  p[n-1] +1; //
		p[n-3] = p[n-2] + p[n-1] + 1;

		
		//dynamic backtracking
		for(int i= n-4; i>=0; i--){
			p[i]= p[i+1]+ p[i+2]+ p[i+3];
		}
		
		for(int num: p){
			System.out.print(num+ " ");
		}
	}

}
