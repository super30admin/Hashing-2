# Time Complexity: O(n)
# Space Complexity: O(1)
 
class Solution:
    def longestPalindrome(self, s: str) -> int:
        hSet = set()
        count = 0
        for i in range(len(s)):
            ch = s[i]
            if ch in hSet:
                count+=2
                hSet.remove(ch)
            else:
                hSet.add(ch)
        if len(hSet)>0:
            count+=1
        return count