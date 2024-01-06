""" Explanation: palindrome_dict is a Counter that stores the count of each character in the given string s.
                 palindrome_length is the variable to accumulate the length of the longest palindrome.
                 The boolean variable odd is used to track whether an odd count has been encountered.
                 Time Complexcity: O(n)
                 Space Complexcity: O(k), where K is the number of unique characters
"""


from collections import Counter
class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        palindrome_dict = Counter([char for char in s])
        palindrome_length = 0
        odd = False

        for char,string in palindrome_dict.items():
            if not odd and string %2 != 0:
                palindrome_length += string
                odd = True
            else:
                palindrome_length += int(string/2)*2
        return palindrome_length
            
    