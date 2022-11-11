## Problem3 (https://leetcode.com/problems/longest-palindrome)
# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this :
import collections
class Solution:
    def longestPalindrome(self, s: str) -> int:
        k = collections.Counter(s)
        res = 0
        flag = 0
        for i in k:
            # print(k[i])
            if k[i]%2==0:
                res += k[i]
            else:
                if flag:
                    res += k[i] - 1
                else:
                    res += k[i]
                    flag = 1
        return res