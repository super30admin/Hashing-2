# // Time Complexity : O(n) 
# // Space Complexity : O(1) 

class Solution:
    def longestPalindrome(self, s: str) -> int:
        hashMap = {}
        lenPalin = 0
        for i in range(len(s)):
            if(s[i] in hashMap):
                if(hashMap[s[i]] % 2 == 1):
                    lenPalin += 2
                hashMap[s[i]] += 1
            else:
                hashMap[s[i]] = 1
        if(len(s) == lenPalin):
            return lenPalin
        return lenPalin+1
