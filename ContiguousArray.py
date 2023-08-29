class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        maxLen=0
        # Map to store first occurence of running sum
        firstOcc = {0:-1}
        runningSum=0
        rSum=0
        for i in range(len(nums)):
            if nums[i] == 0:
                rSum-=1
            else:
                rSum+=1
            if rSum not in firstOcc:
                firstOcc[rSum]=i
            else:
                maxLen= max(maxLen,i-firstOcc[rSum])
        return maxLen