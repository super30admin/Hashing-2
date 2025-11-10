# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        if nums == None or len(nums) == 0:
            return 0
        map = {0 : 1}
        cnt = 0
        rSum = 0
        for num in nums:
            rSum += num
            if (rSum - k) in map:
                cnt += map[rSum - k]
            map[rSum] = map.get(rSum, 0) + 1
        return cnt
            