## Problem3 (https://leetcode.com/problems/longest-palindrome)

# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def longestPalindrome(self, s: str) -> int:
        charSet = set()
        palindromeLen = 0
        # add each char to the set
        # if its already present, increase palindrome len by 2
        # because when we have 2 of the same char, we can form a palindrome
        for c in s:
            if c in charSet:
                palindromeLen += 2
                charSet.discard(c)
            else:
                charSet.add(c)
        
        # if we have single chars left in the set,
        # any one of them can be our middle element so add 1
        if len(charSet):
            palindromeLen += 1
        
        return palindromeLen