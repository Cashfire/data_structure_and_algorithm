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
		int n = s1.length();
		int m = s2.length();
		//System.out.println("n:"+n+" m:"+m);
		int[][] dp= new int[m+1][n+1];//
		//the 1st row and column are Zeros by default
		//fill from the 2nd row and column
		for(int i = 1; i< m+1; i++){
			for(int j = 1; j<n+1;j++){
				if(a2[i-1] == a1[j-1]){
					dp[i][j]= dp[i-1][j-1] +1;
					if(dp[i][j] > dp[i-1][j]){
						System.out.print(a2[i-1]);
					}
				}else{
					dp[i][j]= max(dp[i-1][j],dp[i][j-1]);
				}
				//System.out.print(dp[i][j]);
			}
			//System.out.println();
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
