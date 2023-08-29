class Solution:
    def longestPalindrome(self, s: str) -> int:
        sum=0
        mySet=set()
        for i in s:
            if i in mySet:
                sum=sum+2
                mySet.pop(i)
            else:
                mySet.add(i)
        
        return sum