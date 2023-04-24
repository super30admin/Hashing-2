"""
## Problem3 (https://leetcode.com/problems/longest-palindrome)

Approach:
1. Loop through the input string s and check if the letter in s is present in set.
2. If it is present then increase the palindrome length by 2 and pop the respective letter from the set
3. If not then add the letter to the set
4. At the end if set is not empty then add 1 to the length of the palindrome and return the length

Time Complexity: O(n) where n is the length of input string(s)
Space Complexity: O(1) as the maximum length of s can be 2000
"""


class Solution:
    def longestPalindrome(self, s: str) -> int:
        count = 0
        letters = set()

        for letter in s:
            if letter in letters:
                count += 2
                letters.remove(letter)
            else:
                letters.add(letter)

        if len(letters) > 0:
            count += 1

        return count
