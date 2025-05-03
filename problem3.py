#longest-palindrome
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        char_counts = [0] * 128  # Covers all ASCII characters
        count = 0
        for c in s:
            idx = ord(c)
            if char_counts[idx]:
                count += 2
                char_counts[idx] = 0
            else:
                char_counts[idx] = 1
        if len(s) > count:
            return count + 1
        else:
            return count