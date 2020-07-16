# Time Complexity : O(n) where n is the number of integers present in the list
# Space Complexity : O(n) that takes space to store the keys
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no


class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:

        #we intialize this to start from the zero as the first sum
        hashMap = {0: 1}
        cSum = 0
        TotalSubArrays = 0

        for num in nums:

            #We will get the cumalative sum
            cSum += num

            #if csum - k present in the key means we have a subarray of that value in the hashMap key
            if cSum - k in hashMap.keys():
                TotalSubArrays += hashMap[cSum - k]

            #finaly we will add that csum to the keys, if not already present else, we will update by adding 1 to it.
            if cSum in hashMap.keys():

                hashMap[cSum] += 1

            else:

                hashMap[cSum] = 1

        return TotalSubArrays

