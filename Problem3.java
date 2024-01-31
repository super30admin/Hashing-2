// Time Complexity : O(n)
// Space Complexity : O(1); max number of elements can be 52.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/** Your code here along with comments explaining your approach:*
* Store the count of each character in the array in a hashmap or a boolean array of 52
* If the value is even, we can use all characters; if value is odd we can use value - 1 number of characters
* Add the extra 1 at the end if an odd frequency character is found which can be used in the middle   
*/

import java.util.HashMap;
import java.util.Map;

class Problem3 {
    public int longestPalindrome(String s) {
        int res = 0;
        boolean oddNumberFound = false;

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                map.compute(c, (k, v) -> v + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (Integer value : map.values()) {
            // even number
            if ((value % 2) == 0) {
                res += value;
            } else {
                // value - 1 means making use of even number of values; for eg if value = 3, we
                // use 2 of them
                res += value - 1;
                // setting variable to true if even a single odd number is found
                oddNumberFound = true;
            }
        }

        // adding the extra one which one be used in the middle if an odd number of
        // value existed
        if (oddNumberFound)
            res++;
        return res;
    }
}