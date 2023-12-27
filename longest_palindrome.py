class Solution:
    def longestPalindrome(self, s: str) -> int:
          
        count = {}
        
        for char in s:
            if char not in count:
                count[char] = 1
            else:
                count[char] += 1
                
        ans = 0
        
        for i in count:
            if count[i] % 2 == 0:
                ans = ans + count[i]
                count[i] = 0
            else:
                ans = ans + count[i] - 1
                count[i] = 1
                
        for i in count:
            if count[i] == 1:
                return ans + 1
                
        return ans
