import java.util.*;


// Time Complexity : O(n) where n is the length of the string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Add elements to the HashSet from left to right
// If the same character is encountered, remove that character
// from the set and increment count by 2. else just add the character to the set

class Solution3 {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        int n = s.length();
        for(int i = 0; i < n; i++) {
            char a = s.charAt(i);
            if( set.contains(a) ) {
                count = count + 2;
                set.remove(a);
            } else {
                set.add(a);
            }
        }
        if( set.isEmpty() ) {
            return count;
        } else {
            return count+1;
        }
    }
}