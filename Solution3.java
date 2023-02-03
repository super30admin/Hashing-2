import java.util.HashSet;
// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * I iterate through each character of string and add it to a set of characters. if set already has the character, it means two occurrences of it are present, so I increment count by 2 and remove the
 * character from the set. If the set is not empty at the end, I increment count by 1 since if we take one of the characters of the set, we can still make a palindrome.
 */
class Solution3 {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i=0;i<s.length();i++)
        {
            if(set.contains(s.charAt(i)))
            {
                set.remove(s.charAt(i));
                count+=2;
            }
            else
            {
                set.add(s.charAt(i));
            }
        }
        if(!set.isEmpty())
        {
            count+=1;
        }
        return count;
    }
}