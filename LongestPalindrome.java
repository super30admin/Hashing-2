// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

import java.util.*;

public class LongestPalindrome {
        public int longestPalindrome(String s) {
            Set<Character> set = new HashSet<>();
            int cnt = 0;
    
            for (char ch : s.toCharArray()){
                if (set.contains(ch)){
                    cnt= cnt+2;
                    set.remove(ch);
                } else {
                    set.add(ch);
                }
            }
            
            if (set.size() >= 1) return cnt+1;
            else return cnt;
            
        }
    
}
