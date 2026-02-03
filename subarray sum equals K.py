class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:

        running_sum=0

        map={}
        map[0]=1
        count=0
        for i in range(len(nums)):
            running_sum+=nums[i]
            if running_sum-k in map:
                count=count+map[running_sum-k]
            if running_sum not in map:
                map[running_sum]=1
            else:
                map[running_sum]+=1
            
        return count