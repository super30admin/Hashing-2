# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Learnt from online solutions. Tried on own but was able to arive at solution.
class Solution():
    def longestPalindrome(self, s):
        hash = set()
        for c in s:
            if c not in hash:
                hash.add(c)
            else:
                hash.remove(c)
        return len(s) - len(hash) + 1 if len(hash) > 0 else len(s)
