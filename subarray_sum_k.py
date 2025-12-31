"""
time - o(n)
space - o(n)
We maintain a dictionary and track the running sum, if running sum 
is the same across two indices, the numbers inbetween add up to zero
similarly, if the sum is k, then we increment subarray count.
Finally, to remember the number of times we see the same running
sum we store it in a dictionary, so the next time we see the same
running sum we increment result by the freq
"""
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        running_sum = 0
        sum_map = {0:1}
        result = 0
        for i in range(len(nums)):
            running_sum+=nums[i]
            if running_sum - k in sum_map:
                result += sum_map[running_sum-k]
            if running_sum not in sum_map:
                sum_map[running_sum]=1
            else:
                sum_map[running_sum]=sum_map[running_sum]+1
            
        return result


                
        