/*
 * Given an input string, determine if it makes a valid number or not. 
 * For example: 4.325(true), 1.1.1(false), 22.(true), 4.325.(false), .09(true)...
 * Hint: use state machine. If we reach at UNKNOWN state at any point, the input string is not a valid number .
 * TC: O(n); SC:o(1)
 */
package mathAndStats;
 

public class ValidNumberOrNot {
	enum STATE{STRAT, INTEGER, DECIMAL, UNKNOWN};
	
	STATE get_next_state(STATE current_state, char ch){
		switch(current_state){
		case STRAT:
		case INTEGER:
			if(ch == '.'){
				return STATE.DECIMAL;
			}else if(ch >= '0' && ch <= '9'){
				return STATE.INTEGER;
			}else{
				return STATE.UNKNOWN;
			}
		case DECIMAL:
			if(ch >= '0' && ch <= '9'){
				return STATE.DECIMAL;
			}else{
				return STATE.UNKNOWN;
			}
		}
		return STATE.UNKNOWN;		
	}
	
	boolean validate(String s){
		int i = 0;
		
		
		if(s.charAt(i) == '+' || s.charAt(i) == '-'){
			i++;
		}
		STATE current_state = STATE.STRAT;
		
		while(i < s.length()){
			current_state = get_next_state(current_state, s.charAt(i));
			if(current_state == STATE.UNKNOWN){
				return false;
			}
			i++;
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mystr = "4.325.";
		ValidNumberOrNot vnon = new ValidNumberOrNot();
		System.out.println("Is "+ mystr+" a valid number or not?");
		System.out.println(vnon.validate(mystr));
	}

}
