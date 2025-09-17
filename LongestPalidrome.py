# Time Complexity : O(n)
# Space Complexity : O(1) has the hashset can contain 26 chars only
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Basically check if the char is present in the hashset, if yes remove it and then increment count by 2.
# Finally, for an odd number palindrome check if hashset is empty or not. If not empty return result count + 1

class Solution:
    def longestPalindrome(self, s: str) -> int:
        resultCount = 0
        hashSet = set()
        for c in s:
            if c not in hashSet:
                hashSet.add(c)
            else:
                resultCount += 2
                hashSet.remove(c)

        if not hashSet:
            return resultCount
        return resultCount + 1