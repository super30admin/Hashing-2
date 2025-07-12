# Time Complexity : It is O(n) since we are iterating with the word.
# Space Complexity : It is O(n) since are creating the hash map.
# Did this code successfully run on Leetcode :
# Any problem you faced while coding this :

class Solution:
    def longestPalindrome(self, s: str) -> int:
        
        if s== None or len(s) ==0 :
            return 0
        
        SMap = {}
        longPalindrome =0 
        for i in range(len(s)):
            
            if s[i] not in SMap:
                SMap[s[i]] = 1
            elif s[i] in SMap and (SMap[s[i]] + 1) ==2:
                SMap.pop(s[i])
                #SMap[s[i]] =None
                longPalindrome += 2
        
        if SMap is not None and len(SMap) !=0:
            longPalindrome +=1
        return longPalindrome
        
        
        


obj = Solution()
print(obj.longestPalindrome("bb"))