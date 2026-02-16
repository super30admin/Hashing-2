# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Count frequency of each character.
# For even frequencies, use all occurrences.
# For odd frequencies, use (count - 1) to keep it even.
# If at least one odd frequency exists, we can place one character in the center.

class Solution:
    def longestPalindrome(self, s: str) -> int:
        freq_cnt = [0] * 256
        
        for i in s:
            freq_cnt[ord(i)] += 1
        
        max_cnt = 0
        has_odd = False
        
        for i in freq_cnt:
            if i % 2 == 0:
                max_cnt += i
            else:
                max_cnt += (i - 1)
                has_odd = True
        
        if has_odd:
            max_cnt += 1
        
        return max_cnt
