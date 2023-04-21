## Problem3 (https://leetcode.com/problems/longest-palindrome)

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def longestPalindrome(s):
        """
        :type s: str
        :rtype: int
        """
        if s == None or len(s) == 0:
            return 0

        letter_count = 0
        letter_set = set()

        for char in s:
            if char not in letter_set:
                letter_set.add(char)
            else:
                letter_count = letter_count + 2
                letter_set.remove(char)

        if (len(letter_set) == 0):
            return letter_count
        else:
            return letter_count + 1

    s = "abccccdd"
    print(longestPalindrome(s))