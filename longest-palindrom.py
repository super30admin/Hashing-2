# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

"""
createhashset. itereate list, if the element is not in hashset add. if it is present add 2 to length and remove element from set.
"""

class Solution:
    def longestPalindrome(self, s: str) -> int:

        tracking = set()
        total = 0
        for ele in s:
            if ele in tracking:
                total+=2
                tracking.remove(ele)
            else:
                tracking.add(ele)
        if tracking:
            return total + 1
        return total
