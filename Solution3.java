/*Leetcode Problem - https://leetcode.com/problems/longest-palindrome/description/ */
// Time Complexity : O(n) where n = length of string
// Space Complexity : O(1) - size of HashSet. O(1) because HashSet can hold atmost all ASCII characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
 * I create a HashSet which I use to store characters in the string. I iterate through every character and check if it is already present in
 * the hashset, if so I remove it from the hashset and increment 2 to the count variable. If not, I simply add it to the hashset. At the end
 * if the hashset is not empty, I add 1 to the count variable. 
 * In order to create a palindrome, we need even number of occurrences of every character in the string OR even number of occurrences
 * of certain characters and 1 odd occurrence of another character.
 */
class Solution {
    public int longestPalindrome(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            if(set.contains(c))
            {
                set.remove(c);
                count+=2;
            }
            else
            {
                set.add(c);
            }
        }
        if(!set.isEmpty())
        {
            count+=1;
        }
        return count;
    }
}