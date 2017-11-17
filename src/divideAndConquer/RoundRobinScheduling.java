package divideAndConquer;

public class RoundRobinScheduling {

	void scheduleTable(int[][] table, int n){
		if(n==1){
			table[0][0] = 1;
		}else{
			int m = n/2;
			//fill the upper left.
			scheduleTable(table, m);
			
			//fill the upper right
			for(int i = 0; i < m; i++){
				for(int j = m; j<n;j++){
					table[i][j]= table[i][j-m] + m;
				}
			}
			//fill the lower left
			for(int i= m; i< n; i++){
				for(int j = 0; j<m; j++){
					table[i][j]= table[i-m][j] + m;
				}
			}
			//fill the lower right
			for(int i = m; i < n; i++){
				for(int j = m; j< n; j++){
					table[i][j]= table[i-m][j-m];
				}
			}			
		}	
	}
	
	public static void main(String[] args){
		int[][] table = new int[4][4];
		int n = 4; //n should be a Exponentiation of base 2 = 2^x.
		RoundRobinScheduling rrs = new RoundRobinScheduling();
		rrs.scheduleTable(table, n);
		//print the table
		for(int i = 0; i<n; i++){
			for(int j = 0; j<n; j++){
				System.out.print(table[i][j]+ " ");
			}
			System.out.println();
		}
		
	}
}
//computer process: get t[0][0] = 1, then get the upper left by plus m: [0][1]= t[0][1-1]+ 1 = t[0][0] = 2