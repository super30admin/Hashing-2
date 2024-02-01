import java.util.HashMap;
import java.util.Map;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :    No

// Your code here along with comments explaining your approach in three sentences only

/**
 * Add the character to the map to keep track of its number of occurrences.
 * If the no. of occurrences reach >=2, subtract 2 from the value and add 2
 * to the result. At the end, if our map has any key with value one, we just
 * add 1 to the result and break the loop.
 */
public class LongestPalindrome {
    public int longestPalindrome(String s) {

        Map<Character, Integer> map = new HashMap<>();
        int result = 0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
                if(map.get(c) >= 2) {
                    map.put(c, map.get(c) - 2);
                    result += 2;
                }
            } else {
                map.put(c, 1);
            }
        }

        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1) {
                result = result + 1;
                break;
            }
        }

        return result;
    }
}
