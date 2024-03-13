"""
T.C.: O(n)
S.C.: O(1)


"""

class Solution:
    def longestPalindrome(self, s: str) -> int:
        hashSet = set()
        count = 0
        for char in s:
            if char in hashSet:
                count += 2
                hashSet.remove(char)
            else:
                hashSet.add(char)

        if len(hashSet) != 0:
            count += 1
        
        return count
