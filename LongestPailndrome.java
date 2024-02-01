// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No 


// Your code here along with comments explaining your approach
/**
 * Initalize a HashSet to keep track of key and count
 * If 'ch(key)' already exits increase count by two and remove the key
 * Else insert the key and if set is not empty return the count + 1 else only count
 */

import java.util.HashSet;
import java.util.Set;

class LongestPalindrome {
    public int longestPalindrome(String s) {
        int count = 0;
        Set<Character> set = new HashSet<>();
        for(char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                count += 2;
                set.remove(ch);
            } else {
                set.add(ch);
            }
        }

        if (!set.isEmpty()) {
            count++;
        }
        return count;
    }
}