# Time Complexity: O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No


# Your code here along with comments explaining your approach
# Instead of going through the sums of each sub-array which takes O(N^2) we can actually take a HashMap calculate the prefix_sum from the given array
# Then we check if prefix_sum - target is there in HshMap that means we already have a sub-array whose sum = traget
# Initially we add prefix_sum 0 will be 1 time (0:1)
class Solution:
    def subarraySum(self, nums: List[int], k: int):
        Sum_dict = dict()
        Sum_dict[0] = 1 # Initially sum "0" has occured once
        count = 0 # Total Sub-arrays
        prefix_sum = 0
        
        for i in nums:
            prefix_sum += i
            compliment = prefix_sum - k

            if compliment in Sum_dict:
                count += Sum_dict[compliment]

            if prefix_sum not in Sum_dict:
                Sum_dict[prefix_sum] = 0
            Sum_dict[prefix_sum] += 1

        return count