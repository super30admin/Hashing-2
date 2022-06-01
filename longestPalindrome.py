class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        letters = set()
        count = 0
        for letter in s:
            if letter in letters:
                letters.remove(letter)
                count+=2
            else:
                letters.add(letter)
        
        if letters:
            return count+1
        else:
            return count
