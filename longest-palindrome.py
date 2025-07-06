"""
https://leetcode.com/problems/longest-palindrome/description/'

Brute Force: Try every permutation of the characters and check if it's a palindrome --> O(n!)
Optimal: Count frequency of each character. For each character:
If it occurs an even number of times, great — use all.
If odd, use count - 1 (the even part). At most one odd character can sit in the center of the palindrome.
Palindromes are mirrored. Each char needs a matching pair — i.e., even count.
If you have x odd counts, only one can be centered. The rest? Drop one char from each (to make it even). Eg: If a character appears an odd number of times (say 7), we can still use 6 of them (3 on the left, 3 on the right). The extra 1 could be the center—but only one such “lonely” character is allowed in the entire palindrome.

Edge case:
empty array
One element
No palindrome exists

Time Complexity: O(n)
Space Complexity: O(1). Space is O(1) because we’re dealing with a limited character set (ASCII).
"""
from collections import Counter

class Solution:
    def longestPalindrome(self, s):
      freq = Counter(s)
      length = 0
      odd_found = False
      
      for count in freq.values():
        if count % 2 == 0:
          length += count
        else:
          length += count - 1 # For an odd count: count - 1 is the largest even portion you can safely mirror. Example: 'e' × 7 → use 6, leave 1 available for the center.
          odd_found = True # The very first time we run into an odd count, we mark that we now have a spare character we could put in the center. Hitting another odd count later? We still set length += (count - 1) but odd_found is already True. We do not put all odd chars in the middle—only one character can sit there.
      return length + 1 if odd_found else length # If at least one odd count existed (odd_found is True), we can place exactly one leftover character in the center, so we add 1 to the final length. If no odd counts were present, the palindrome is already fully mirrored—no extra center char is needed.
    
s = "abccccdd"
sol = Solution()
print(sol.longestPalindrome(s))  