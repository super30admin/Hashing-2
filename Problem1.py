'''
We use cumSum to keep track of weather a subarray has sum = k.
Then use hashmap to keep count of the cumSums so we know how many times
the cumSum has occured which eventually can be used to count subarrays.

For every cumSum we check if cumSum-k has occured and how many times in the hashmap.
Then we increment the count of cumSum in hashmap.

Time Complexity: O(n)
Space Complexity: O(n)
'''

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        # If the first number is k
        cumSumMap = {0: 1}
        result = 0
        cumSum = 0

        for num in nums:
            cumSum += num
            if (cumSum-k) in cumSumMap:
                result += cumSumMap[cumSum-k]
                            
            if cumSum not in cumSumMap:
                cumSumMap[cumSum] = 0

            cumSumMap[cumSum] += 1

            

        return result