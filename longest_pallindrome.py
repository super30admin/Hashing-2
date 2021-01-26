'''
Implementation: Make a set to store the letters. While inserting check if letter already present
in the set. If yes, remove the letter from the set. If no, add the letter to the set.
In the end, 
if set size = 1, the string is a pallindrome with 1 middle letter.
if set size = 0, the string is a pallindrome with no middle letter
if set size > 1, pallindrome length = len(s) - len(set) + 1

Time complexity: O(n)
Space complexity: O(n)
'''
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        letters_set = set()
        for i in range(len(s)):
            if s[i] in d:
                letters_set.remove(s[i])
            else:
                letters_set.add(s[i])
        if len(letters_set) <= 1: # No element or center element remains i.e. pallindrome
            return len(s)
        else:
            return len(s) - len(letters_set) + 1