# Use a set to track characters with odd counts
        # Each time a pair is found (character seen twice), add 2 to length
        # At the end, if any odd-count character remains, add 1 for the center
class Solution:
    def longestPalindrome(self, s: str) -> int:


        chars = set()
        length = 0

        for ch in s:
            if ch in chars:
                chars.remove(ch)
                length += 2  # Found a pair, add 2 to palindrome length
            else:
                chars.add(ch)

        # If there are leftover chars with odd count, add one for the center
        if chars:
            length += 1

        return length
