# Calculating prefix sum along the loop
# At every point checking is prefixsum-k is present before
# if yes we add the total number of subarrays the result
# Else we will store the result to use in next iterations
# Taking a dictionary  with 0:1 to handle for the first time we get the target

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        currsum=0
        result=0
        freq_map={0:1}
        for i in nums:
            currsum+=i
            if currsum-k in freq_map:
                result+=freq_map[currsum-k]
            freq_map[currsum]=freq_map.get(currsum,0)+1
        return result

            
            
        