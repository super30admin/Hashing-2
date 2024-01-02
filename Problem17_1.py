'''
Time complexity: O(n)
Space complexity: O(1)
'''
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        
        rSum, HashMap = 0, {0: 1}
        count = 0

        for i in range(len(nums)):
            rSum+=nums[i]
            if (rSum - k) in HashMap:
                count += HashMap[rSum-k]
            if rSum not in HashMap:
                HashMap[rSum] = 0
            HashMap[rSum] = HashMap[rSum] + 1

        return count