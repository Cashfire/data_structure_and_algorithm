package mathAndStats;

public class AllSubsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		for(int i = 0; i < 8; i++){
			for(int j = 0; j < 3; j++){
				int temp = (1 << j);
				System.out.println("(1<<"+j+") = "+temp);
				System.out.print(temp);
				temp = temp & i;
				System.out.println(" & " + i+ " = "+ temp);
			}
		}
	}

}
