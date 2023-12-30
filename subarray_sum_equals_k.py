"""
The idea here is that we take prefix sum
generally for the array
             [3,1,2,4]
prefix_sum = [3,4,6,10], k = 6
generally the sum(0,3) = sum(0,1) + sum(2,3)
Hence if we need to know if sum 6 is present or not, we see if the prefix_sum(10) has a subarray which has sum 6 or not we see if any of the other subarrays have sum 4. If they do, we know there is a subarray with sum 6. How do we know if we have another subarray of sum 4? That is why we keep track of the prev prefix sum. To enable O(1) lookup, storing it in a hashMap makes sense. Also we store the count of occurence of prefix_sum, as that increases the no of subarrays that can give the required sum.
TC - O(N), SC - O(N)
"""
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        p_sum_map = {}
        #Add [0,1] to consider a single subarray like ele is 3, and sum is 3. 
        p_sum_map[0] = 1
        prefix_sum = 0
        count = 0
        for i in range(len(nums)):
            prefix_sum += nums[i]
            if prefix_sum-k in p_sum_map:
                #Instead of doing count += 1, we are adding the val
                count += p_sum_map[prefix_sum-k]
            p_sum_map[prefix_sum] = p_sum_map.get(prefix_sum, 0) + 1
        return count
        
            

        

