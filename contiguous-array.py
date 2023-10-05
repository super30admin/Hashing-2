# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : YES
# // Any problem you faced while coding this : NO


# // Your code here along with comments explaining your approach
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        count = 0
        maxlen = 0
        hashmap = {0: -1}

        for i in range(len(nums)):
            count += 1 if nums[i] == 1 else -1

            if count in hashmap:
                maxlen = max(maxlen, i - hashmap[count])
            else:
                hashmap[count] = i

        return maxlen
