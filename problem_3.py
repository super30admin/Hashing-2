# Time Complexity: O(n)
# Space Complexity: O(1)



class Solution:
    def longestPalindrome(self, s: str) -> int:
        dictionary = {}
        count = 0
        
        for i in range(len(s)): 
           if s[i] in dictionary:
               count += 2 
               del dictionary[s[i]]
           else :
               dictionary[s[i]] = 1 
        if dictionary:
            count+= 1 
        return count


