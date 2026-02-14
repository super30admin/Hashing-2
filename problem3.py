## Problem3 (https://leetcode.com/problems/longest-palindrome)

class Solution:
    def longestPalindrome(self, s: str) -> int:
        my_set = set()
        count = 0
        for i in s:
            if i in my_set:
                count+=2
                my_set.remove(i)
            else:
                my_set.add(i)
        if len(my_set) > 0:
            return count+1
        return count