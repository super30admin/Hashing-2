# Time Complexity: O(N)
# Space Complexity: O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Here we Check at every index that if the current (running_sum - k) is present in the dictionary
# if it is present it means that the elements in between the indices give a sum = k
# if multiple (running_sum - k) exists we add the count of how many times it occurs to the final_count
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        sum_dict = dict() # to store the running sum of the elements
        count = 0
        sum_dict[0] = 1 #dummy to take care of cases where the sum is k but it includes the first index
        running_sum = 0


        for i in range(len(nums)):
            running_sum += nums[i]
            if((running_sum - k) in sum_dict):
                count += sum_dict[running_sum - k]

            if running_sum in sum_dict:
                sum_dict[running_sum] += 1
            else:
                sum_dict[running_sum] = 1

        return count