#Time Complexity : O(n), where n is the number of elements in the s
#Space Complexity : O(n) where n is the number of elements in the s
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : Nothing any speicfic

class Solution:
    def longestPalindrome(self, s: str) -> int:
        count={}
        for i in s:
            if(i in count):
                count[i]+=1
            else:
                count[i]=1
        print(count)
        
        out=0
        odd_occurance=False
        for j in count.values():
            if(j%2==0):
                #Here it is even value
                out+=j
            else:
                #Here it is odd value, Then one of its can't never stay in palindrome string
                odd_occurance=True
                out+=(j-1)
        
        if(odd_occurance):
            out+=1
        return out
        
