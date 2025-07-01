# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes

class Solution(object):
    def subarraySum(self, nums, k):
        if len(nums) == 0:
            return 0
        r_sum = 0
        count = 0
        val_freq_map = {}
        val_freq_map[0] = 1
        for i in range(len(nums)):
            r_sum = r_sum + nums[i]
            print(r_sum)
            if (r_sum-k) in val_freq_map:
                count = count + val_freq_map.get(r_sum-k)
            if r_sum in val_freq_map:
                val_freq_map[r_sum] = val_freq_map.get(r_sum) + 1
            else:
                val_freq_map[r_sum] = 1
        print(val_freq_map)
        return count
    
#obj = Solution()
#sol1 = obj.subarraySum([1,1,1], 2)
#print(sol1)
#sol2 = obj.subarraySum([1,2,3], 3)
#print(sol2)  
#sol3 = obj.subarraySum([1,-1,0], 0)
#print(sol3)