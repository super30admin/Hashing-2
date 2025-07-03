# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach in three sentences only

class Solution:
    def longestPalindrome(self, s: str) -> int:
        # Initialize set
        unpaired_chars = set()

        # Counter for length of palindrome
        palindrome_length = 0

        # Iterate through each character in the input string
        for char in s:
            # If seen this character once
            if char in unpaired_chars:
                # A second occurrence makes a pair, contributing 2 to palindrome
                palindrome_length += 2
                # Remove it from the set since now used in a pair
                unpaired_chars.remove(char)
            else:
                # If it's the first occurrence, add to set for pairing
                unpaired_chars.add(char)

        # If there's at least one unpaired character left,we can place one in the middle of the palindrome
        if len(unpaired_chars) > 0:
            return palindrome_length + 1

        # Otherwise, return the full length made from pairs
        return palindrome_length
