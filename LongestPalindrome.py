'''
TC: O(n)
SC: O(1)
'''
class Solution:
    def longestPalindrome(self, s: str) -> int:
        count = 0
        myset = set()
        for letter in s:
            if letter not in myset:
                myset.add(letter)
            else:
                myset.remove(letter)
                count += 2
        return count + 1 if myset else count

s = Solution()
print(s.longestPalindrome("abccccdd"))
print(s.longestPalindrome("a"))