# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on LeetCode : Yes
# Any problem you faced while coding this :
# - Easy to forget the final +1 when any character has an odd count (center of palindrome)
# - Remember: a pair contributes 2 to the length

class Solution:
    def longestPalindrome(self, s: str) -> int:
        m = set()          # tracks chars seen an odd number of times so far
        c = 0              # length of palindrome built from complete pairs

        for ch in s:       # look at each character
            if ch in m:    # we had an odd count for this char; now it's a pair
                c += 2     # each pair adds 2 (one on each side of the palindrome)
                m.remove(ch)  # toggle back to "even" by removing from the odd set
            else:
                m.add(ch)  # first/third/etc. time seeing this char -> odd count

        if len(m) > 0:     # if any chars have odd counts left,
            c += 1         # we can place exactly one of them in the center

        return c
