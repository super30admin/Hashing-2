# https://leetcode.com/problems/longest-palindrome/description/

# Time Complexity: O(n)
# Space Complexity: O(1)

# This problem returns longest palindrome length. For this solution, we use a dictionary to store the frequency of each character 
# in the string in the first pass. Then we iterate through the dictionary to check if the frequency of a character is even. If so,
# we add the frequency value to our resultant length, if it's an odd value then, we subtract the frequency value by 1 and also have a 
# boolean variable "odd" set to True. At the end we check if the boolean odd is True, if so then add 1 to the resultant length and return. 

class Solution:
    def longestPalindrome(self, s: str) -> int:

        res = 0 
        hm = {}
        odd = False 

        for i in s:
            if i in hm:
                hm[i] += 1
            else:
                hm[i] = 1

        for i in hm:
            if hm[i] % 2 == 0:
                res = res + hm[i]
            else:
                res = res + (hm[i] - 1)
                odd = True 
        
        if odd == True:
            res = res + 1

        return res