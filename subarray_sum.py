#Time Complexity: O(N)
#Space Complexity: O(N)



class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        count_hash = {0: 1}  
        sum_v = 0
        count = 0
        
        for num in nums:
            sum_v += num  
           
            if (sum_v - k) in count_hash:
                count += count_hash[sum_v - k]
            
            # Update count_hash with the new sum_v
            count_hash[sum_v] = count_hash.get(sum_v, 0) + 1

        return count
