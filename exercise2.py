# // Time Complexity :
# // Space Complexity :
# // Did this code successfully run on Leetcode :
# // Any problem you faced while coding this :


# // Your code here along with comments explaining your approach
 
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        rSum = 0
        maxnum = 0
        hashtable = {0 : -1} #defining hasmap
        
        for i in range (len(nums)):
            if nums[i]==0:
                rSum -= 1 # -1 if value is 0
            else:
                rSum += 1 # +1 if value if 1
            
            if rSum in hashtable:
                maxnum = max(maxnum, i - hashtable[rSum]) #updating hasmap values comparing it with diff of perticular index value and current key in hashmap to maxnum
            else:
                hashtable[rSum] = i #updating key in hashmap
      
        return maxnum
        