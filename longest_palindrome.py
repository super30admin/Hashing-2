class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        hashset = set()
        result = 0
        for i in range(len(s)):
            if s[i] in hashset:
                result += 2
                hashset.remove(s[i])
            else:
                hashset.add(s[i])
        if len(hashset) != 0: result += 1
        return result