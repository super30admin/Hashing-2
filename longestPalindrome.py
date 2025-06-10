# // Time Complexity :O(N)
# // Space Complexity :O(1) only 52 letters 
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
# get frequency for each element , if its even frequency will contribute of its odd freq-1 will contribute ,but 1st odd frequency will contribute entire frequency which can middle char





class Solution:
    def longestPalindrome(self, s: str) -> int:
        flag=True
        d=defaultdict(int)
        for i in s:
            d[i]+=1
        ans=0
     
        for i in d:
            
            if d[i]%2==0:
                ans+=d[i]
            elif flag:
                
                ans+=d[i]
                flag=False
            else:
                ans+=d[i]-1
           
               
        return ans
