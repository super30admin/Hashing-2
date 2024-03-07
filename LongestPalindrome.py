# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : No
# Any problem you faced while coding this : No

class Solution:
    def longestPalindrome(self, s: str) -> int:
        if len(s)==1:
            return 1
        freq_set = set()
        count = 0
        for char in s:
            if char not in freq_set:
                freq_set.add(char)
            else:
                freq_set.remove(char)
                count+=2
        if len(freq_set)==0:
            return count
        else:
            return count+1