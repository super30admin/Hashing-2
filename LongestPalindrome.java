import java.util.HashMap;
/**
 * Time: O(n)
 * Space: O(n)
 * Leetcode Accepted: yes
 * Problems faced: NA
 */
public class LongestPalindrome {
	
	public static int longestPalindrome(String s) {
		if(s.length() == 1) return 1;
		HashMap <Character, Integer> hm = new HashMap<Character, Integer>();
		int max = 0;
		boolean isOddFound = false;
        for(int i=0; i<s.length(); i++) {
        		//Insert each character into HashMap with its repetition count
        		if(hm.containsKey(s.charAt(i))) {
        			hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
        		} else {
        			hm.put(s.charAt(i), 1);
        		}
        }
        //If repetition count is even simply add to max
        //Else (repetition count-1) values can be added to max if it is > 1
        // For ex: if a letter is repited 5 times, 4 chars can be used for palindrome with one extra
        for(Character key: hm.keySet()) {
        		if(hm.get(key) % 2 == 0) {
        			max+=hm.get(key);
        		} else {
        			isOddFound = true;
        			if(hm.get(key) > 1) {
        				max = max + hm.get(key)-1;
        			} 
        		}
        }
        return isOddFound?max+1:max;
    }
	public static void main(String[] args) {
		String str = "ababababa";
		System.out.println(longestPalindrome(str));
	}

}
