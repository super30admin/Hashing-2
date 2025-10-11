class Solution(object):
    def subarraySum(self, nums, k):
        sum_count_map = {}
        sum_count_map[0] = 1   # prefixSum : frequency
        prefix_sum = 0
        result = 0

        for num in nums:
            prefix_sum += num

            # check if there exists a prefix sum such that (prefix_sum - k)
            if prefix_sum - k in sum_count_map:
                result += sum_count_map[prefix_sum - k]

            # update the count of current prefix_sum
            sum_count_map[prefix_sum] = sum_count_map.get(prefix_sum, 0) + 1

        return result