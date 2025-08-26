# Time Complexity :O(n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach: The code computes the length of the longest palindrome that can be built from the characters of a given string. It uses a set to track character pairs: if a character repeats, it contributes +2 to the palindrome length, and the character is removed from the set. At the end, if any characters remain unmatched, one can be placed in the middle of the palindrome, so +1 is added before returning the final length.

class Solution:
    def longestPalindrome(self, s: str) -> int:
        set_chars = set()
        count = 0

        for c in s:
            if c in set_chars:
                count += 2
                set_chars.remove(c)
            else:
                set_chars.add(c)
        
        if len(set_chars) > 0:
            count += 1

        return count 