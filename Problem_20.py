# Time Complexity: O(n)
# Space Complexity: O(n)

class Solution:
    def longestPalindrome(self, s: str) -> int:
        hashset = set()
        count = 0
        for i in s:
            if i in hashset:
                hashset.remove(i)
                count += 2
            else:
                hashset.add(i)
        if len(hashset) > 0:
            count += 1

        return count