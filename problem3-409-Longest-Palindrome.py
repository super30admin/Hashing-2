--space 0(1)
-- time o(n)
class Solution:
    def longestPalindrome(self, s: str) -> int:

        if s == None or len(s) == 0:
           return 0
        count = 0
        myset = set()

        for item in s:
            if item in myset:
               count+=2
               myset.remove(item)
            else:
               myset.add(item)

        return  count+1 if len(myset) > 0 else count