class Solution:
    def longestPalindrome(self, s: str) -> int:
        s_1=set()
        count=0
        for i in range(len(s)):
            if s[i] not in s_1:
                s_1.add(s[i])
            else:
                count=count+2  
                s_1.remove(s[i]) 
        if len(s_1)!=0:
            return count+1
        return count
#Time Complexity O(n)
#Space O(n)

