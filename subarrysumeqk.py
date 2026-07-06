class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        prefix = {0: 1}
        currSum = 0
        count = 0

        for num in nums:
            currSum += num

            if currSum - k in prefix:
                count += prefix[currSum - k]

            prefix[currSum] = prefix.get(currSum, 0) + 1

        return count

    # TC O(n)
    # SC O(n)