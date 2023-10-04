// Time Complexity :O(n)
// Space Complexity : O(1) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int longestPalindrome(String s) {

        HashSet set = new HashSet<>();
        int length=0; 
        
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);

            if(set.contains(c)){
            length = length + 2;
            set.remove(c);
            }
            else 
            set.add(c);
        }

            if(!set.isEmpty())
            length += 1;
        return length;


    }
}
