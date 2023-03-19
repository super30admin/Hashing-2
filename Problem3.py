#Time complexity : O(n)
#Space complexity : O(n)

class Solution:
    def longestPalindrome(self, s: str) -> int:
        dict1 = {}
        ans = 0
        odd = 0
        c = 0
        if(len(s)==1):
            return 1
        for char in s:
            if(char in dict1.keys()):
                dict1[char] += 1
            else:
                dict1[char] = 1
        for i in dict1.values():
            if(i%2==0):
                c += i
            else:
                if(i>odd):
                    odd = i
                c += (i//2)*2
        if(odd==0):
            return c
        else:
            return c+1