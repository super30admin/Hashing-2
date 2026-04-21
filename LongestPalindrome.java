// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// This code pairs matching characters to build a symmetrical string, adding 2 to the count for each pair found. 
// If any unpaired characters remain, it adds 1 more to the total to allow for a single character in the middle.

import java.util.HashSet;
import java.util.Set;

class LongestPalindrome {

    public int longestPalindrome(String s) {
        int count = 0;
        Set<Character> hashSet = new HashSet<>();
        for (char charec: s.toCharArray()) {
            if (hashSet.contains(charec)) {
                hashSet.remove(charec);
                count = count + 2;
            } else {
                hashSet.add(charec);
            }
        }

        if (!hashSet.isEmpty()) {
            count = count + 1;
        }

        return count;
    }   
}