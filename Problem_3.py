"""
 Time Complexity : O(N), where N is number of elements in array
 Space Complexity : O(1)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No


Problem 1: Longest Palindrome, Given a string s which consists of lowercase or uppercase letters,
           return the length of the longest palindrome that can be built with those letters.
           Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
"""

class Solution:
    def longestPalindrome(self, s: str) -> int:
        """
        using hashset or set to store the letters of the array and then removing the letters once,
        we found the pair.
        """
        char_set = set()
        count  = 0
        
        for i in range(len(s)):
            if s[i] in char_set:
                count += 2
                char_set.remove(s[i])
            else:
                char_set.add(s[i])
                
        if char_set:
            count += 1
            
        return count
        