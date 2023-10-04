// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class LongestPalindrom {
    class Solution {
        public int longestPalindrome(String s) {
            int count = 0;
            Set<Character> set = new HashSet<>();

            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(set.contains(c)){
                    count += 2;
                    set.remove(c);
                }
                else{
                    set.add(c);
                }
            }
            if(!set.isEmpty()) count++;

            return count;
        }
    }
}
