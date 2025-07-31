class Solution(object):
    def longestPalindrome(self, s):
        freq = {}  # Dictionary to count character frequencies
        for char in s:
            if char in freq:
                freq[char] += 1
            else:
                freq[char] = 1

        length = 0
        odd_found = False

        for count in freq.values():
            if count % 2 == 0:
                length += count           # Use all even occurrences
            else:
                length += count - 1       # Use even part of odd count
                odd_found = True

        if odd_found:
            length += 1                   # Add one central odd character

        return length