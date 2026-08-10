# https://leetcode.com/problems/contiguous-array/

# Time complexity: O(n) 
# Space complexity: O(n)
# Explanation: Maintain a hashmap which tracks sum upto current index (prefix sum);
# whenever there is a match, check if the current length is greater vs. existing length, otherwise add to hashmap

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hashmap = {}
        ans, count = 0, 0
        hashmap[0] = -1

        for i in range(len(nums)):
            if nums[i] == 1:
                count += 1
            else:
                count -= 1
            
            if count in hashmap:
                ans = max(ans, i - hashmap[count])
            else:
                hashmap[count] = i
            
        return ans
