// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

public class Solution {
    public int LongestPalindrome(string s) {
        int result = 0;
        
        if(s == null || s.Length == 0)
            return result;
        
        Dictionary<Char, int> sMap = new Dictionary<Char,int>();
        
        for(int i = 0; i < s.Length; i++)
        {
            Char sChar = s[i];
            
            if(sMap.ContainsKey(sChar))
            {
                sMap.Remove(sChar);
                result += 2;
            }
            else{
                sMap[sChar] = 1;
            }
        }
        
        if(sMap.Count != 0)
            result++;
        
        return result;
        
    }
}
