class Solution:
    # Time Complexity: O(n)
    def findMaxLength(self, nums: List[int]) -> int:
        map_c = {}
        r_sum = 0
        max_c = 0
        map_c[0] = -1
        for i in range(len(nums)):
            if nums[i] == 0:
                r_sum -= 1
            else:
                r_sum += 1
            if r_sum in map_c:
                if i - map_c[r_sum] > max_c:
                    max_c = i - map_c[r_sum]
            else:
                map_c[r_sum] = i
        return max_c
