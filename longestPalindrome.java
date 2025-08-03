/** 
 * Time complexity: O(n)
 * Space complexity: O(n)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: No
 */

/** The longest palindrome is found by counting the frequency of each character in the string.
 * If a character appears an even number of times, it can contribute fully to the palindrome length.
 * If a character appears an odd number of times, it can contribute all but one of its occurrences to the palindrome length.
 */
import java.util.HashSet;

class longestPalindrome {
    public int longestPalindrome(String s) {
        HashSet <Character> oddcharacters= new HashSet<>();
        int len=s.length();
        int count=0;
        for(int i=0;i<len;i++)
        {
            char c=s.charAt(i);
            if(oddcharacters.contains(c))
            {
                count=count+2;
                oddcharacters.remove(c);
            }
            else
            {
                oddcharacters.add(c);
            }
        }
        if(!oddcharacters.isEmpty()) return count+1;
        else return count;

        
    }
}