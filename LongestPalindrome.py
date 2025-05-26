# Time Complexity: O(n), n is the number of characters in string s
# Space Complexity: O(n), n is the number of characters in string s
# Did this code successfully run on Leetcode: Yes


class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        length = 0
        char_set = set()

        for char in s:
            if char in char_set:
                length += 2
                char_set.remove(char)
            else:
                char_set.add(char)
            
        
        if len(char_set):
            length += 1
        
        return length
