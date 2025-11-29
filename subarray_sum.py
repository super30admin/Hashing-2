'''
Time: O(N)
Space: O(N)
'''
class Solution:
    '''
    Concept: running sum 
    As we iterate over every element we keep adding the previous value to form 
    a new sum. Hence the name running sum 
    If the difference between k and nums[i] == k then that forms a sub array
    with the difference being starting point and nums[i] being end point of 
    sub array 
    We store the running sum as key and no of time its occured as val
    Every time we find it in the map, we increment the sub array count by 1
    '''
    def subarraySum(self, nums: List[int], k: int) -> int:
        if len(nums) == 0 or nums is None:
            return 0
        sub_array_count = 0
        sum_and_its_freq_map = dict()
        sum_and_its_freq_map [0] = 1
        sum = 0 
        for i in nums:
            sum += i
            if sum-k in sum_and_its_freq_map:
                sub_array_count += sum_and_its_freq_map[sum-k]
            if sum not in sum_and_its_freq_map:
                sum_and_its_freq_map[sum] = 1
            else:
                sum_and_its_freq_map[sum] += 1 
        return sub_array_count
         



        