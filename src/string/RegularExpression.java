/*Given a text and a pattern, determine if the pattern matches with text completely or not using regex matching. 
 * For simplicity assume that the pattern may contain only two operators i.e. '.' and '*'. 
 * Operator '*' in pattern means that the character preceding '*' may not appear or may appear any number of times in text. 
 * Operator '.' matches with any character in text exactly once.
 * Hint: recursion, backtracking, pruning
 * TC: exponential; SC: Exponential. Worst case like text = "aaa" and pattern = "a*a*a".
 */
package string;

public class RegularExpression {
	public boolean isMatch(String text, String pattern) {
		//if the 2nd last execution is: isMatch("c","c"), 
		//its first_match is true and returns: first_match && match("c".substring(1),"c".substring(1))
		//Because "c".substring(1) == "", 
		//the last execution is match("",""), and return "".isEmpty(), which is true.
        if (pattern.isEmpty()) return text.isEmpty();
        boolean first_match = (!text.isEmpty() &&
                               (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));
        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
        	//situations: "b*c" means "c","bc","bbc" and so on. 
        	//isMatch(text, pattern.substring(2)) is that: b* means no "b" situation.
            return (isMatch(text, pattern.substring(2)) ||
            		//isMatch(text.substring(1), pattern) is that: b* means one "b" situation.
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String mytext = "fabbbc";
		String mypattern =  ".ab*c";
		RegularExpression re = new RegularExpression();
		System.out.println(re.isMatch(mytext, mypattern));
	}

}
