# Time Complexity : o(n)
# Space Complexity : o(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
# Your code here along with comments explaining your approach

class Solution:
    def longestPalindrome(self, s: str) -> int:
        S = set()
        count = 0
        for i in s:
            if i not in S:
                S.add(i)
            else:
                count+=2
                S.remove(i)
        # print(S)
        if len(S)==0:
            return count
        else:
            return count+1
