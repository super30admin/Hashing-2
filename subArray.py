"""
We use currSum and store counts of prefix sums in a hash map.
For an index, check if (currSum - k) exists — it means a subarray summing to k ends here.
Update the hash map with the current prefix sum.
"""
"""
Time Complexity: O(n) — A single pass through array
Space Complexity: O(n) — To store prefix sums in the hash map
"""

class subArray:
    def subarraySum(self, nums: list[int], k: int) -> int:
        n = len(nums)

        seenPrefix = {}

        seenPrefix[0] = 1
        currSum = 0
        count = 0

        for i in range(n):
            currSum += nums[i]
            if currSum - k in seenPrefix:
                count += seenPrefix.get(currSum - k)
            seenPrefix[currSum] = seenPrefix.get(currSum, 0)+1
        
        return count

if __name__=="__main__":
    nums = [1,2,3]
    k = 3
    obj = subArray()
    print(obj.subarraySum(nums,k))
        