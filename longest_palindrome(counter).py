#Time Complexity :O(n) (n+k)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : Yes

#Intution
#Maintain a dictionary counter of frequencies (number of times appeared). 
#When the frequency is more than one, we will increase the count and reduce the frequencies. 
#Finally, if there is at least one character left in the dictionary, it can be placed in the center, so adding one. 

from collections import Counter
class Solution:
    def longestPalindrome(self, s: str) -> int:
        dict=Counter(s)
        res=0
        for k in dict:
            while dict[k]>=2:
                res+=2
                dict[k]-=2
                print(dict)
            
        for k in dict:
            if dict[k]>0:
                res+=1
                return res
        return res