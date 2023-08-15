# Problem2 (https://leetcode.com/problems/contiguous-array/)
# // Time Complexity :O(n)
# // Space Complexity :O(n)
# // Did this code successfully run on Leetcode :Yes
# // Any problem you faced while coding this :No


# // Your code here along with comments explaining your approach
class Solution:
    def findMaxLength(self, nums):
        # Brute Force
        # max_len = 0
        # for i in range(len(nums)):
        #     one_count = zero_count = 0
        #     for j in range(i, len(nums)):
        #         if nums[j] == 0:
        #             zero_count += 1
        #         else:
        #             one_count += 1
        #         if zero_count == one_count:
        #             max_len = max(max_len, j - i + 1)
        # return max_len

        # hashmap for storing running sum and its index (rsum:idx)
        hmap = {}
        # variable for running sum and max balanced string
        rsum = max_len = 0
        # dummy value to not miss the first array
        hmap[0] = -1
        for i in range(len(nums)):
            # Creating running sum
            # Subtracting 1 for 0
            if nums[i] == 0:
                rsum -= 1
            # Adding 1 for 1
            else:
                rsum += 1
            # Adding rsum withits idx if not present in hmap
            if rsum not in hmap:
                hmap[rsum] = i
            else:
                # update max_len
                max_len = max(max_len, (i - hmap.get(rsum)))
        return max_len


sol = Solution()
nums = [0, 1]
print(sol.findMaxLength(nums))
