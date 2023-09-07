# Time Complexity: O(n)
# Space Complexity: O(1)
 
class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        dic = {0:1}
        count = 0
        x = 0
        running_sum = 0

        for i in range(0,len(nums)):
            running_sum += nums[i]
            x = running_sum-k

            if x in dic:
                count += dic[x]

            if running_sum not in dic:
                dic[running_sum] = 1
            else:
                dic[running_sum] += 1

        return count
        
