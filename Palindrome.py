# TC = O(n)
# SC = O(1)


class Solution:
    def longestPalindrome(self, s: str) -> int:
        pal = set()
        count = 0
        for i in range(len(s)):
            if s[i] not in pal:
                pal.add(s[i])
            else:
                pal.remove(s[i])
                count += 2
        return count + 1 if len(pal) != 0 else count
