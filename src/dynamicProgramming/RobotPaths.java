package dynamicProgramming;

public class RobotPaths {

	static int countPaths(boolean[][] table){
		int rows = table.length;
		int cols = table[0].length;
		//initiate a matrix to be filled
		int[][] map = new int[rows][cols];
		
		//check whether the exit is accessible 
		if(table[rows-1][cols-1]){//if it's limited
			map[rows-1][cols-1] = 0;
			System.out.println("No exit at all");
			return 0;
		}
		//set the exit
		map[rows-1][cols-1] = 1;
		
		for(int n=cols-2; n>=0; n--){
			if(table[rows-1][n]){
				map[rows-1][n] = 0;
			}else{
				map[rows-1][n] = map[rows-1][n+1];
			}
		}
		
		//set the last column
		for(int m=rows-2; m>=0; m--){
			if(table[m][cols-1]){
				map[m][cols-1] = 0;
			}else{
				map[m][cols-1] = map[m+1][cols-1];
			}
		}		
		
		//count the path by backtracking
		for(int m=rows-2;m>=0; m--){
			for(int n=cols-2;n>=0; n--){
				if(table[m][n]){
					map[m][n]=0;
				}else{
					map[m][n] = map[m+1][n] + map[m][n+1];
				}
			}
		}
		
		//printing the map
//		for(int m=0; m< rows; m++){
//			for(int n=0; n< cols;n++){
//				System.out.print(map[m][n]+" ");
//			}
//			System.out.println();
//		}
		
		return map[0][0];
	}

	public static void main(String[] args) {
		boolean[][] grid= new boolean[4][3];
		grid[2][1]= true; //set a limit the robot cannot go
		countPaths(grid);
		System.out.println("the amount of paths: "+countPaths(grid));
		
	}

}
