# Method 1 - Hashmap
# Time Complexity - O(n), where n is the length of s
# Space Complexity - O(n) 
# We use a running sum to emulate the generation of all possible contiguous arrays.
# If running sum is in the hashmap, increase count else make a new entry with 1 as value .
# If complement present in running sum, add value at dict[complement] to count.
# key adjustment for calculations - dict[0]=1

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count=0
        running_sum=0
        running_sum_dict=defaultdict(lambda:0)
        running_sum_dict[0]=1           #key adjustment for calculations
        for i in range(len(nums)):
            running_sum+=nums[i]
            complement=running_sum-k
            if complement in running_sum_dict:
                count+=running_sum_dict[complement]
            running_sum_dict[running_sum]+=1
        return count
