import java.util.*;

// O(n) time, O(1) space
class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        int count = 0;
        boolean oddChar = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            int freq = e.getValue();

            if (freq % 2 == 0) {
                count += freq;
            }
            else {
                count += freq - 1;
                oddChar = true;
            }
        }
        if (oddChar) {
            return count + 1; // can choose 1 of remaining odd chars to go in middle
        }
        return count;
    }
}