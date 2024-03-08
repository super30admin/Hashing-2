// Time Complexity: O(n)
// Space Complexity: O(1) - Considering the character set is limited (uppercase and lowercase English letters)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

// Approach:
// 1. Initialize a HashSet to store characters.
// 2. Iterate through the characters of the input string.
// 3. For each character, check if it exists in the HashSet.
//    - If it does, increment the count by 2 (as it can be used to form a palindrome).
//    - Remove the character from the HashSet (since it's paired now).
//    - If it doesn't exist, add it to the HashSet.
// 4. If there are any characters left in the HashSet after the loop, it means they can be used as the middle character of the palindrome, so increment the count by 1.
// 5. Return the final count, which represents the length of the longest palindrome that can be formed using characters from the input string.

import java.util.HashSet;

class LongPalindrome {
    public int longestPalindrome(String s) {
        int count =0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++)
        {
            char c= s.charAt(i);
            if(set.contains(c))
            {
                count+=2;
                set.remove(c);
            }
            else
            {
                set.add(c);
            }
        }

        if(!set.isEmpty())
        {
            count++;
        }
        return count;
    }
    }
