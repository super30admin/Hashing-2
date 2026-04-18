class Solution:
    def longestPalindrome(self, s: str) -> int:
        charSet = set()
        result = 0
        for c in s:
            if c in charSet:
                result += 2
                charSet.remove(c)
            else:
                charSet.add(c)
        if len(charSet) > 0:
            result += 1
        return result


s = "abccccdd"

sl = Solution()
print(sl.longestPalindrome(s))