# Time Complexity : O(N)
# Space Complexity : O(N)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
#I have used HashMap to keep rSum and if the rSum has occured then we increase the count by 1
#So we check if the complement that is rSum - k is in HashMap and then get the count how many times it has occurred.


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        if not nums:
            return None
        rSum = 0
        dict = {0:1}
        result = 0
        for i in range(len(nums)):
            rSum += nums[i]
            comp = rSum - k
            if comp in dict:
                result += dict[comp]
            if rSum in dict:
                dict[rSum] += 1
            else:
                dict[rSum] = 1

        return result

