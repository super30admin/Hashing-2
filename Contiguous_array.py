class Solution:
    def findMaxLength(self, nums: List[int]) -> int:

        running_sum=0
        map={}
        max_length=0

        map[0]=-1

        for i in range(len(nums)):
            if nums[i]==0:
                running_sum=running_sum-1
            else:
                running_sum+=1
            if running_sum not in map:
                map[running_sum]=i
            else:
                max_length=max(max_length, i-map[running_sum])
        return max_length
        