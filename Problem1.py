class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        map_c = {}
        r_sum = 0
        count = 0
        map_c[0] = 1
        for i in range(len(nums)):
            r_sum += nums[i]
            comp = r_sum - k
            if (comp) in map_c:
                count += map_c[comp]
            if r_sum in map_c:
                map_c[r_sum] += 1
            else:
                map_c[r_sum] = 1
        return count
