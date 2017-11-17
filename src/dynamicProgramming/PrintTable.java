package dynamicProgramming;
/**
 * get a brief review of the 2 Strings before dynamic programming 
 * @author Mao
 *
 */
public class PrintTable {
	public static void main(String[] args){
		String s1 = "random";
		String s2 = "android";
		for(int i = 0; i< s1.length();i++){
			char c1= s1.charAt(i);
			for(int j = 0; j< s2.length();j++){
				char c2 = s2.charAt(j);
				if(c1 == c2){
					System.out.print(1+" ");
				}else{
					System.out.print(0+" ");
				}
			}
			System.out.println();
		}		
	}
}

