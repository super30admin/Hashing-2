'''
https://leetcode.com/problems/longest-palindrome/

Time Complexity: O(n)
Space comlexity: O(n)
TIP: Count the total number of even occurences and add it to the totalSum. For odd occurences add `occurence - 1`, and set the oddPresent to true - in the end add 1 to res if oddPresent == true
Refer to optimized way in the video solution s30 to use hashset for adding count
'''
from collections import Counter
class Solution:
    def longestPalindrome(self, s: str) -> int:
        count = Counter(s)
        res = 0
        oddPresent = False
        for el in count.values():
            if el%2 == 0:
                res += el
            else:
                res += (el - 1)
                oddPresent = True            
        if oddPresent:
            res += 1
        return res