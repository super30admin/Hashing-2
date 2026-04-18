// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


import java.util.HashSet;

class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int slen = s.length();
        int count =0;
        for( int i =0; i<slen;i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                count = count + 2;
                set.remove(ch);
            }
            else{
                set.add(ch);
            }
        }
        if (set.size() > 0) return count + 1;
        return count;
    }
}