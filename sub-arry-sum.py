class Solution:
    '''
    Time: O(N)
    Space: O(N)
    '''
    def subarraySum(self, nums: List[int], k: int) -> int:
        if len(nums) == 0 or nums is None:
            return 0
        sub_array_count = 0
        sum_and_its_freq_map = dict()
        sum_and_its_freq_map [0] = 1 # if the diff of curr sum and k result in 0 with currsum being 1st element, then it needs to be stored ahead
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
         



        