class Solution:
    def longestPalindrome(self, s: str) -> int:
        final = set()
        count = 0
        for i in s:
            if i not in final:
                final.add(i)
            else:
                final.remove(i)
                count += 2
        if len(final) > 0:
            count += 1
        return count