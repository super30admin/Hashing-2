# Time Complexity: O(n) where n is the number of elements in the list.
# Space Complexity: O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class Solution:
    def longestPalindrome(self, s: str) -> int:
        temp = set()
        l = 0
        for i in s:
            if i in temp:
                temp.remove(i)
                l += 2
            else:
                temp.add(i)
        if len(temp) != 0:
            l += 1
        return l
