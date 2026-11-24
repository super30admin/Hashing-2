#Analysis: Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.

# We are basically using a frequency map here to count the characters. so when the frequency is even then we use all the characters when the frequency is odd then we just use it once.

# Time complexity: 

class Solution:
    def longestPalindrome(self, s: str) -> int: