#time complexity : O(N) where N is the size of the array 
#space complexity:O(N) because we used a map


class Solution:
    def subarraySum(self, nums: list[int], k: int) -> int:
        n = len(nums)
        map1 = {}

        sum_num = 0
        count = 0

        map1[0] = 1

        for i in range(0, n):
            sum_num += nums[i]
            result = sum_num - k
            count += map1.setdefault(result, 0)
            map1[sum_num] = map1.get(sum_num, 0) + 1

        return count

sol = Solution()
nums = [1, 2, 3]
k = 3

result = sol.subarraySum(nums, k)
print("The number of subarrays is:", result)