# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#Approach:
# We use the running sum technique and store the running sum in a dictionary (key = rSum, value = count)
# We use a dummy rSum as 0 with count as 1 to handle edge case. [7]
# We iterate through the nums list and calculate the rSum at each index.
# We then calculate the rSum - k and check if the value is present in the dictionary.if present
# then we take the resp.key's value and add it to total.
# we then check if the rSum is present in the dictionary.
# If present, we increment the value of the corresponding key(rSum). else, we set the rSum to the dictionary's key and its value to 1


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        if not nums or len(nums) == 0:
            return 0

        rsum = 0
        total = 0
        subarr = dict()
        subarr[rsum] = 1

        for i in range(len(nums)):
            rsum += nums[i]

            if subarr.get(rsum - k) != None:
                total += subarr[rsum - k]

            if subarr.get(rsum) != None:
                subarr[rsum] += 1
            else:
                subarr[rsum] = 1
        #print(subarr)
        return total

