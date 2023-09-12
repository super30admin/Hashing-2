class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        dict = {}
        sum = 0
        count = 0
        dict[0] = 1
        for i in range(len(nums)):
            sum += nums[i]
            if sum-k in dict:
                count += dict[sum-k]
            if sum in dict:
                dict[sum] += 1
            else:
                dict[sum] = 1
        
        return count
    

# TC: O(n)
# SC: O(n)