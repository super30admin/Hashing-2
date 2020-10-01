// Time Complexity :O(N)
// Space Complexity : O(N), N is no of chars in string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet <Character>();
        int count =0;
        
        for (int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            
            if (set.contains(c)){
                set.remove(c);
                count = count+2;
            }
            else{
                set.add(c);
            }
        }
        
        count = set.isEmpty() ? count:count+1;
        return count;
    }
}