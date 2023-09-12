# Time Complexity: O(n) where n is the number of elements in the list.
# Space Complexity: O(n)

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        rSum = 0
        rSumMap = {0: 1}
        count = 0

        for num in nums:
            rSum += num
            complement = rSum - k
            
            if complement in rSumMap.keys():
                count += rSumMap[complement]

            if rSum not in rSumMap:
                rSumMap[rSum] = 1
            else:
                rSumMap[rSum] += 1

        return count    