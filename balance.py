class Solution:
    def longestPalindrome(self, s: str) -> int:
        
        letters = set()
        count=0
        
        for i in s:
            if i in letters:
                count+=2
                letters.remove(i)
            else:
                letters.add(i)
                
        if len(letters) >0:
            count+=1
            
        return count
                
        