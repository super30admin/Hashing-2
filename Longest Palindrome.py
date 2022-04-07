class Solution:
    def longestPalindrome(self, s: str) -> int:
        if len(s)==0 or s==None:return 0
        set1=set()
        count=0
        for i in range(len(s)):
            c=s[i]
            if(c in set1):
                count=count+2
                set1.remove(c)
            else:
                set1.add(c)  
        if(len(set1)!=0):
            count=count+1
            return count
        else:
            return count
