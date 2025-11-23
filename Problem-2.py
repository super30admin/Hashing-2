# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :no


# Your code here along with comments explaining your approach
# Compute a running prefix sum where 0 becomes −1 and 1 becomes +1.
# If the same prefix appears again, the subarray between those two positions has equal 0s and 1s.
# Use a hashmap to store the first occurrence of each prefix sum and track the longest valid subarray.
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        new_array = [0] 
        count = 0

        for num in nums:
            if num == 0:
                count -= 1
            else:
                count += 1
            new_array.append(count)

        result = 0
        first_occurrence = {}

        for i in range(len(new_array)):
            if new_array[i] in first_occurrence:
                result = max(result, i - first_occurrence[new_array[i]])
            else:
                first_occurrence[new_array[i]] = i

        return result