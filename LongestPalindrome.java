// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No	


class Solution {
    public int longestPalindrome(String s) {
        if(s==null||s.length()==0)
            return 0;
        HashSet<Character> set = new HashSet<>();
        int len = 0;
        for(int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                len+=2;
                set.remove(c);
            }
            else{
                set.add(c);
            }
        }
        if(!set.isEmpty())
            return len+1;
        return len;
    }
}