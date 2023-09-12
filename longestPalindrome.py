class Solution:
    def longestPalindrome(self, s: str) -> int:
        if len(s) == 1:
            return 1
        res = 0
        arr = []
        for  c in s:
            if c in arr:
                res += 2
                arr.remove(c)
            else:
                arr.append(c)

        if len(arr) != 0:
            return res+1
        return res
# TC: O(n) 
# SC: O(n)