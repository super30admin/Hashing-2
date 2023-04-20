"""
Time Complexity : O(N) where N = length of s
Space Complexity : O(N) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :
No

Your code here along with comments explaining your approach
1. Use a hashset. Iterate over s, if s[i] in hashset, add (+2) to result. else, add the s[i]
 to hashset. and at the end, if len(hashset) > 0, this means there was a elem which did not find a pair. So add (+1) to the final answer and return
 """

class Solution:
    def longestPalindrome(self, s: str) -> int:
        oddChars = set()
        count = 0
        for ch in s:
            if ch in oddChars:
                count += 2
                oddChars.remove(ch)
            else:
                oddChars.add(ch)
        if len(oddChars) > 0:
            count += 1
        return count