#Time Complexity : O(n) where n is the length of the nums list
#Space Complexity : O(n) since we use a dictionary whos max kength can be n in worst case.
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

#Approach: We again use the running sum (rSum) approach. We use a dictionary to store these running sum (key = rSum, value = count)
# We use a dummy rSum as 0 with count as 1. We iterate through the nums list and calulate the rSum at each step. We then calculate
# the complement (rSum - k) and check if the complement is present in the dictionary. if present then we take the corresponding
# value (count) and add to the result count. Then we check if the rSum is present in the dictionary. If present, we increment the
# value of the corresponding key (rSum). If not present, we add the rSum to the dictionary with value (count) as 1

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        mapp = {}
        count = 0
        rSum = 0
        mapp[0] = 1
        for i in range(len(nums)):
            rSum += nums[i]
            comp = rSum - k
            if comp in mapp:
                count += mapp[comp]
            if rSum in mapp:
                mapp[rSum] = mapp[rSum] + 1
            else:
                mapp[rSum] = 1
        return count