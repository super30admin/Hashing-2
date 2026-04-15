# Time Complexity : O(N) N:length of string.
# Space complexity :O(1) -> atmost 52 characters.
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No.

# Your code here along with comments explaining your approach
# use set to store characters; if a character is in the Set then pair is found add 2 to count and remove that character.
# Any character that doesn't find a partner stays in the Set by the end of the loop.
# If the Set isn't empty then there is atleast one leftover letter, so add 1 to the final result.

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: int
        """
        mapping = set()
        count = 0

        if len(s) == 1:
            return 1

        for i in range(len(s)):
            if s[i] in mapping:
                count += 2
                mapping.discard(s[i])
            else:
                mapping.add(s[i])
        
        if len(mapping) > 0:
            return count + 1
        return count