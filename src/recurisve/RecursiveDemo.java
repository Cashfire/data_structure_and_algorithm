package recurisve;

public class RecursiveDemo {
	public static void main(String[] args) {
		System.out.println("Test for n as 21:");
		recursiveDemo1(21);
		System.out.println("Test for n as 32:");
		recursiveDemo1(32);
	}	

//print all even numbers from 0 to n
public static void recursiveDemo1(int n){
	if(n<0){
		return;
	}else if(n%2 ==0){
		System.out.println(n);
		recursiveDemo1(n-2);
	}else{
		recursiveDemo1(n-1);
	}
}
}