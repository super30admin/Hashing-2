// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Had to look up for Hashset functions



class Solution {
    public int longestPalindrome(String s){
        
        int count = 0;
        
        HashSet<Character> hs = new HashSet<>(); 
        
        for (int i=0;i<s.length();i++){
            
            char ch = s.charAt(i);
            
            if(hs.contains(ch)){
                hs.remove(ch);
                count += 2;
            }
            else{
                hs.add(ch);
            }
        }
        if(!hs.isEmpty()) return count + 1;
        else
            return count;
    }
}