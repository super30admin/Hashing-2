# Problem 3 - Longest Palindrome (https://leetcode.com/problems/longest-palindrome/)
# We track characters that appear an odd number of times using a set: when we see a character the first time we add it; the second time we remove it and add 2 to the length
# After processing all characters, if any remain in the set (odd counts), we can place exactly one in the palindrome center, adding 1
# This yields the maximum palindrome length in O(n) time an O(m) space 
class Solution:
    def longestPalindrome(self, s: str) -> int:
        if s == None or len(s) == 0:
            return 0
        count = 0
        myset = set()
        for i in range(len(s)):
            c = s[i]
            if c in myset:
                count = count + 2
                myset.remove(c)
            else:
                myset.add(c)
        
        if myset:
            count = count + 1

        return count