import java.util.Set;
import java.util.HashSet;
// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int longestPalindrome(String s) {
        int result = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++)
        {
            if(set.contains(s.charAt(i)))
            {
                result += 2;
                set.remove(s.charAt(i));
            }
            else
            {
                set.add(s.charAt(i));
            }
        }
        if(!set.isEmpty())
        {
            result += 1;
        }
        return result;
    }
}