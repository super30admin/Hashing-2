#TC: O(n), n is length of nums
#SC: O(n), n is unique Rsum, there can be n unique Rsums, think of [1,1,1,1,1,1...]
#Did this code successfully run on Leetcode : yes, 525
# Any problem you faced while coding this : NA
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        Rsum = 0
        hmap = {}
        maxLength = 0
        
        #This is to imply that sum is 0 at index -1
        #think of input [0,1], where Rsum is 0, but max len is 2.
        hmap[0] = -1
            
        for i in range(0,len(nums)):
            
            if nums[i] == 0:
                Rsum -=1
            else:
                Rsum += 1
            
            # dont update the hashmap, as we want to store the last time where this sum happened.
            if Rsum not in hmap:
                hmap[Rsum] = i
                
            # Think of rolling sum, i - hmap[Rsum] will give length of contiguous subarray with an equal number of 0 and 1
            
            # we need the max length of such array
            maxLength = max(maxLength, i - hmap[Rsum])    
        return maxLength
                