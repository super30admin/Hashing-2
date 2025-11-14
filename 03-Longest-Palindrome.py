# Problem 3: Longest Palindrome (https://leetcode.com/problems/longest-palindrome/)
# Time Complexity: O(N) where N is the number of characters in the input string.
# Space Complexity: O(1) since the character set is fixed (ASCII).
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No
# Your code here along with comments explaining your approach
# 1. Use a set to track characters that have appeared an odd number of times.
# 2. For each character, if it is already in the set, it means we have found a pair, so we increase the count by 2 and remove it from the set.


class Solution:
    def longestPalindrome(self, s: str) -> int:
        if s == None or len(s) ==0:
            return -1
        
        count = 0
        myset = set()
        for c in s:
            if c in myset:
                count = count + 2
                myset.remove(c)
            else:
                myset.add(c)

        if myset:
            count = count + 1
            
        return count