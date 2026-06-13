# Problem2 (https://leetcode.com/problems/contiguous-array/)
# Time Complexity :O(n) we are using only one loop 
#Space Complexity :O(n) we are using one map to store rsum and index
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No


#Your code here along with comments explaining your approach
from rpds import List


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        n = len(nums)       #here we can get the no. of elements in nums
        map = {0:-1}        #we have dummy values to handle if the array starts at 0
        rsum = 0            #initilaizing rsum and maxlength to 0
        maxlength = 0

        for i in range(n):
            currentnum = nums[i]    #currentnum sotres the value at that index
            if currentnum ==0:
                rsum -= 1           #for 0 we do -1 and for 1 we do +1
            else:
                rsum +=1
            
            if rsum in map:                                   #if the rsum is present in the map then return the max length between when it first occured or the current maxlength
                maxlength = max(maxlength, i -map[rsum])
            else:
                map[rsum]=i                                   #else just add the rsum in the map along with the index
        return maxlength                                      #at the end we need the maxlength which will tell us the maxlength of contigeous subarray