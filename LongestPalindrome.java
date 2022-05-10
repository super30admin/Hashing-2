/**

Time Complexity : O(N) N = input size
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


**/
class Solution 
{
    public int longestPalindrome(String s) 
    {
        char input[] = s.toCharArray();
        
        Set<Character> set = new HashSet<>();
        int result = 0;
        
        for(char ch: input)
        {
            if(set.contains(ch))
            {
                result = result + 2;
                set.remove(ch);
            }
            else
            {
                set.add(ch);
            }
        }
        
        if(!set.isEmpty())
            result++;
        
        return result;
        
    }
}