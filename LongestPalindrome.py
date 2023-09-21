# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Approach:
# Longest palindrome can be formed by either odd number of characters or even number of characters i.e. length of
# string is either even or odd. Maintain a set and add the character to set if it is not present in set.
# At every index, we first check whether character already exist or not in the set, if you find
# that in set we increment counter by 2, and remove the character from set, else add the character to set and continue.
# After iterating through whole string, if the length of set is 0 i.e. we find pair for each and every character, so
# return count, else there is atleast one character that has no pair, so add 1 to count and then return count

class Solution:
    def longestPalindrome(self, s: str) -> int:
        if s == None or len(s) == 0:
            return 0
        res = set()
        total = 0

        for i in range(len(s)):
            if s[i] not in res:
                res.add(s[i])
            else:
                total += 2
                res.remove(s[i])

        if len(res) != 0:
            total += 1

        return total

