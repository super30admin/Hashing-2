# Time Complexity : O(n) 
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


class Solution:
    def longestPalindrome(self, s: str) -> int:
        palindromeMap = {}
        count = 0
        flag = False
        for char in s:
            if char in palindromeMap:
               palindromeMap[char] = palindromeMap.get(char)+1
            else:
                palindromeMap[char] =  1
        
        for char in palindromeMap.keys():
            freq = palindromeMap.get(char)
            if freq % 2 == 0:
                count += freq
            else:
                count += freq-1    
                flag = True

        if flag: return count+1
        return count
    
    # class Solution:
    #     def longestPalindrome(self, s: str) -> int:
    #         palindromeMap = set()
    #         count = 0
    #         for char in s:
    #             if char in palindromeMap:
    #                 palindromeMap.remove(char)
    #                 count += 2
    #             else:
    #                 palindromeMap.add(char)
            
    #         if len(palindromeMap) != 0: return count+1
    #         return count