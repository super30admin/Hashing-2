from collections import Counter 

class Solution:
    def longestPalindrome(self,s)->int:
        char_count=Counter(s)
        length=0
        odd_found=False

        for count in char_count.values():
            length +=(count//2)*2
            if count %2==1:
                odd_found=True
        if odd_found:
            length+=1
        return length
sol=Solution()
print(sol.longestPalindrome("abccccdd"))
print(sol.longestPalindrome("a"))