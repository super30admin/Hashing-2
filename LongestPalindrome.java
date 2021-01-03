/**

Leetcode problem #409

Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here. 


counting the occurences of the character


Input: s = "abccccdd"
Output: 7

Collabedit: http://collabedit.com/ktab5

keep the count of pairs and if there exists the characters which does not exist 
in pair then add oneto the result

Time Complexity : O(N)
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

**/

class Solution 
{
    public int longestPalindrome(String s) 
    {
        if( s == null || s.length() == 0) return 0;
        
        if( s.length() == 1) return 1;
        
        Map<Character, Integer> hashMap = new HashMap<>();
        
        for(int i =0 ; i < s.length(); i++)
        {
            if( hashMap.containsKey(s.charAt(i) ) )
            {
                // get the previous count from the map and increment and store it back to map
                int current = hashMap.get(s.charAt(i));
                current++;
                
                hashMap.put( s.charAt(i), current);
            }
            else
            {
                hashMap.put( s.charAt(i), 1);
            }
        } // end of for loop
        
        
        int pairs  = 0;
        int singles = 0;
        
        for( char a: hashMap.keySet() )
        {
            int count = hashMap.get(a);
            pairs = pairs + (count/2)*2;
            singles = singles + count%2;
        
        }
        
        if( singles != 0)
            pairs++;
            
        return pairs;
    }
}





