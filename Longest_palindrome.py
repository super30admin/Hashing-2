class Solution:
    def longestPalindrome(self, s: str) -> int:
        letters={}

        for char in s:
            letters.update({char:s.count(char)})
            
        result=0
        odd=False

        for key,value in letters.items():
            
                if value%2==0:
                    result+=value
                else:
                    result+= value-1
                    odd = True
            

        if odd:
            return result+1
        else:
            return result