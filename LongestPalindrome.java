import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestPalindrome {

//	Time Complexity: o(n) as we iterating through characters
//	Space Complexity : o(1) as character in set will be 52 at max

//	Your code here along with comments explaining your approach
//	iterate through each character: for first occurrence add to set 
//	and for second occurrence remove for set and increase count by 2
//	and finally increase count by 1 if set is not empty

	public int longestPalindromeWithSet(String s) {

		HashSet<Character> set = new HashSet<>();
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (set.contains(c)) {
				set.remove(c);
				count += 2;
			} else {
				set.add(c);
			}
		}

		if (!set.isEmpty()) {
			count++;
		}

		return count;
	}

//	Time Complexity: o(n) --> 
//	o(n)  + o(n) ; as we iterating through characters + we are iterating through map, at max length will be 52 so it can be written as 0(1)    
//	Space Complexity : o(1) as character in map will be 52 at max

//	Your code here along with comments explaining your approach
//	iterate through each character: for every occurrence increase the count by 1 
//	and finally increase count by 1 if map is not empty

	public int longestPalindromeWithMap(String s) {

		HashMap<Character, Integer> map = new HashMap<>();

		int count = 0;
		int oddCount = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			map.put(c, (map.containsKey(c)) ? map.get(c) + 1 : 1);
		}

		for (Map.Entry<Character, Integer> m : map.entrySet()) {

			int v = m.getValue();

			if (v % 2 == 0) {
				count = count + v;
			} else {
				oddCount = 1;
				count = count + v - 1;
			}
		}

		return count + oddCount;
	}

	// follow up question
//	Time Complexity: o(n)
//	Space Complexity : o(1)
	public static String longestPalindromeStringWithSet(String s) {

		HashSet<Character> set = new HashSet<>();
		StringBuilder longP = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (set.contains(c)) {
				longP.append(c);
				longP.reverse();
				longP.append(c);
				set.remove(c);
			} else {
				set.add(c);
			}
		}

		if (!set.isEmpty()) {
			Character next = set.iterator().next();
			longP.insert(longP.length() / 2, next);

		}

		return longP.toString();
	}

	public static void main(String args[]) {
		System.out.println(longestPalindromeStringWithSet("abcccdcabcdd"));
	}

}
