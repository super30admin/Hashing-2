// Time Complexity : O(n)
// Space Complexity : O(1)  (since alphabet size is fixed)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, just had to count odd frequency characters.


// Your code here along with comments explaining your approach in three sentences only
// We count frequency of each character using a hash set.
// If a character appears even times, it can fully be used in palindrome, and if odd, one can be placed in center.
// Finally, we add all usable pairs and add one odd if any exists.

import java.util.*;

class Solution {
    public int longestPalindrome(String s) {

        HashSet<Character> set = new HashSet<>();
        int count = 0;

        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                set.remove(c);
                count += 2;
            } else {
                set.add(c);
            }
        }

        if (!set.isEmpty()) count += 1;

        return count;
    }
}
