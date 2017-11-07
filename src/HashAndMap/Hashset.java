package HashAndMap;
import java.util.*;

public class Hashset {
	public static void main(String[] args) {
		HashSet<String> members = new HashSet<String>();
		members.add("a");
		if (members.contains("a")) {
			System.out.println("Yes");
		}
	}
}

