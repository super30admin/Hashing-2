// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach : Use Haashset, remove when even count is found and finally if set is not empty add 1 to th count


import java.util.HashSet;

class Solution {
    public int longestPalindrome(String s) {
        
        if(s == null || s.length()==0) return 0;
        
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        
        for(int i=0;i<s.length();i++){
            
            char c = s.charAt(i);
            if(set.contains(c)){
                count = count + 2;
                set.remove(c);
            }else{
                set.add(c);
            }
            
        }
        
        
        if(!set.isEmpty()){
            count++;
        }
        
        return count;
        
    }
}