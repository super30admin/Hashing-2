"""
Time Complexity: O(n)
Space Complexity: O(1) --> Although hashset under the hood is a boolean array, it does not necessarily mean that this
hashset will also be of size 52 like a boolean array as we have not explicitly set the size as such. But the initial
memory will be a constant, so space complexity will be constant.

This works on Leetcode.
I did not run into any errors.

"""


class Solution:
    def longestPalindrome(self, s: str) -> int:
        hashSet = set()
        count = 0

        for letter in range(len(s)):
            if s[letter] in hashSet:
                count += 2
                hashSet.remove(s[letter])
            else:
                hashSet.add(s[letter])

        if len(hashSet) != 0:
            count += 1

        return count
