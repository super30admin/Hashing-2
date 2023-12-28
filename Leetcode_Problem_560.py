#problem: Subarray Sum Equals K
#time complexity: O(n)
#space complexity: O(1)
#approach: using hashmap to store the running sum and its frequency, if the running sum - k is in the hashmap, we increase the count by the frequency of running sum - k. In the end, we return the count.

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int: 
        hashmap = {0: 1}
        count = 0
        rsum = 0
        for num in nums:
            rsum += num

            if rsum - k in hashmap:
                count += hashmap[rsum - k]

            hashmap[rsum] = hashmap.get(rsum, 0) + 1

        return count