"""
// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
## Problem3 (https://leetcode.com/problems/longest-palindrome)

every pair forms a palindrome, and at most one unpaired character can go in the center.

"""

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        char_set = set()
        length = 0

        for c in s:
            if c in char_set:
                char_set.remove(c)
                length += 2
            else:
                char_set.add(c)

        return length + 1 if char_set else length
