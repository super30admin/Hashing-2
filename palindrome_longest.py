# // Time Complexity : O(N)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach

class Solution:
    def longestPalindrome(self, s: str) -> int:
        l=len(s)
        pal_size=0
        hash=[False for i in range(62)]
        for i in range(l):
            asci_val=ord(s[i])-ord('A')
            if(hash[asci_val]):
                pal_size+=2
                hash[asci_val]=False
            else:
                hash[asci_val]=True
        for i in range(62):
            if(hash[i]==True):
                pal_size+=1
                break
        return pal_size
