# Time Complexity: O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No


# Your code here along with comments explaining your approach
# From the given string, first we will store the frequency of each character in a dict
# and for even count characters we can use all of them, and if there is only one character we can use that in the middle
# We just need to return length of longest palindrome, so return length of even count characters + odd single character in the middle

class Solution:
    def longestPalindrome(self, s):
        char_dict = dict()
        for i in s:
            if i not in char_dict:
                char_dict[i] = 0
            char_dict[i] += 1 # Here we are calculating frequency of each character
            odd_char = 0
            max_length = 0
            for count in char_dict.values():
                if count % 2 == 0:
                    max_length += count
                else:
                    max_length += (count-1)
                    odd_char = 1
        return max_length + odd_char