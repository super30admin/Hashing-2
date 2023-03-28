#Used a hashmap. Runningsum is obtained and checked if the difference between the current running sum and the given value gives anyof the previous runningsum value.
#If it is found, then it means that there is a subarray that sums up to the given value. Number of total subarrays count is updated.
#Time complexity is O(n) and space complexity is O(n).

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        if nums==None or len(nums)==0:
            return 0
        runningSum=0
        hashmap={}
        total=0
        hashmap[runningSum]=1
        for i in range(len(nums)):
            runningSum=runningSum+nums[i]
            temp=runningSum-k
            if temp in hashmap.keys():
                total=total+hashmap[temp]
            if runningSum in hashmap.keys():
                hashmap[runningSum]=hashmap[runningSum]+1
            else:
                hashmap[runningSum]=1
        return total
