# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO


# // Your code here along with comments explaining your approach
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count = 0
        sum_val = 0
        hashmap = {0: 1}

        for num in nums:
            sum_val += num

            if sum_val - k in hashmap:
                count += hashmap[sum_val - k]

            if sum_val in hashmap:
                hashmap[sum_val] += 1
            else:
                hashmap[sum_val] = 1

        return count
