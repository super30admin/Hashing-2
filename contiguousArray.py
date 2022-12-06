#Time Complexity :  O(n)
#Space Complexity : O(n)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hashmap = {0:-1}            #initialize hashmap {rSum: index}
        result = 0
        rSum = 0
        
        for i in range(len(nums)):
            if nums[i] == 0:                        #if there is 0 in nums we decrement the rSum by 1
                rSum -= 1
            else:                                   #if there is 1 in nums we increment the rSum by 1
                rSum += 1
                
            if rSum in hashmap.keys():                      #if rSum is in hashmap
                result = max(result, i - hashmap[rSum])     #we find diff of index and hashmap[rSum]
            else:
                hashmap[rSum] = i                           #if rSum not there we add the rSum: index
                
        return result