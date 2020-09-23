// Time Complexity : O(n ^ 2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : No //I tried the bruteforce approach and some testcases are failing
// Any problem you faced while coding this : Yes.


// Your code here along with comments explaining your approach


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        temp_sum = 0
        for i in range(len(nums)):
            temp_sum = 0
            temp_sum += nums[i]
            if temp_sum == k:
                count += 1
            else:
                j = i + 1
                while (j < len(nums)):
                    if temp_sum + nums[j] > k :
                        break
                    elif temp_sum + nums[j] == k :
                        count += 1
                        break
                    else:
                        temp_sum += nums[j]
                        j += 1
        return count

                