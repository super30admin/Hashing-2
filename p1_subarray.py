class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        res = 0
        for i in range(0, len(nums)):
            count = nums[i]
            if count == k:
                res += 1
            for j in range(i+1, len(nums)):
                count += nums[j]
                if count == k:
                    res += 1

        return res
        # r_sum = 0
        # r_dict = dict([(0, 1)])
        # count = 0
        # for i in nums:
        #     r_sum += i
        #     if r_sum - k in r_dict:
        #         count += r_dict[r_sum - k]

        #     if r_sum not in r_dict:
        #         r_dict[r_sum] = 1
        #     else:
        #         r_dict[r_sum] += 1
        # return count