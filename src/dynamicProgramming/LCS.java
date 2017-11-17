package dynamicProgramming;
/**
 * 
 * @author Mao
 *
 */
public class LCS {

	public static void main(String[] args){
		String s1 = "random";
		String s2 = "androy";
		char[] a1= s1.toCharArray();
		char[] a2= s2.toCharArray();
		int n = s1.length();//a1(i->n)
		int m = s2.length();//a2(j->m)
		int[][] dp= new int[m][n];//m rows and n columns
		
		// set the 1st row of the dp table 
		for(int c = 0; c < n; c++){
			if(a1[c]==a2[0]){
				dp[0][c] = 1;
				for(int i =0; i< n; i++){
					dp[0][i] = 1;
				}
				break;
			}
		}
		
		//set the 1st column of the dp table
		for(int r = 0; r < m; r++){
			if(a2[r]==a1[0]){
				dp[r][0] = 1;
				for(int i = 0; i< m; i++){
					dp[i][0] = 1;
				}
				break;
			}
		}
		
		//fill dp table from the 2nd row and column
		for(int r = 1; r< m; r++){
			for(int c = 1; c < n;c++){
				if(a1[r] == a2[c]){
					dp[r][c]= dp[r-1][c-1] +1;
				}else{
					dp[r][c]= max(dp[r-1][c],dp[r][c-1]);
				}			
			}
		}
		
		System.out.println("The longest common subsequence is: "+dp[m-1][n-1]);
		//print the dp table
		for(int j = 0; j<m; j++){
			for(int i = 0; i<n; i++){
				System.out.print(dp[j][i]+" ");
			}
			System.out.println();
		}
	}

	
	
	private static int max(int x, int y) {
		if(x > y){
			return x;
		}else{
			return y;
		}
	}
	
	
}
