// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.HashSet;
import java.util.Set;

class LongestPalindromeSolution {
    public int longestPalindrome(String s) {
        
        if(s == null || s.length() == 0) {
            return 0;
        }
        int length = 0;
        Set<Character> set = new HashSet<>();
        //Created an hashset for characters
        for(int i = 0; i < s.length(); i += 1) {
            char c = s.charAt(i);
            //If character is not present then add it.
            if(!set.contains(c)) {
                set.add(c);
            } else {
                //If character is present then we can form a pair so update length by 2 since it is pair and remove it.
                length = length + 2;
                set.remove(c);
            }
        }
        //If characters are left out then it is odd characters so increment the length by 1
        if(set.size() > 0) {
            length = length + 1;
        }
        return length;
    }
}