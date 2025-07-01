/*
 * TC: O(n)
 * SC: O(n) 
 */
import java.util.HashMap;

class longestPalindrome {
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int len = 0;
        boolean hasOdd = false;

        for (int freq : map.values()) {
            if (freq % 2 == 0) {
                len += freq;
            } else {
                len += freq - 1;
                hasOdd = true;
            }
        }

        if (hasOdd) len += 1;

        return len;
    }
}
