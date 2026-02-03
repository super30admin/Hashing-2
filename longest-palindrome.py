''' 
Time Complexity : O(n)
Space Complexity : O(n) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :  No
'''
class Solution:
    def longestPalindrome(self, s: str) -> int:
        freq = {}
        for ch in s:
            freq[ch] = freq.get(ch, 0) + 1

        length = 0
        has_odd = False

        for count in freq.values():
            if count % 2 == 0:
                length += count
            else:
                length += count - 1
                has_odd = True

        if has_odd:
            length += 1

        return length
