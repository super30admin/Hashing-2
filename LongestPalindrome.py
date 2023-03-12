class Solution:
    #TC: O(n), SC: O(1)
    def longestPalindrome(self, s: str) -> int:
        if len(s) == 1: return 1
        palindromeSet = set()
        count = 0

        for i in range(0,len(s)):
            if s[i] not in palindromeSet:
                palindromeSet.add(s[i])
            else:
                palindromeSet.remove(s[i])
                count += 2
        return count +1 if(palindromeSet) else count

