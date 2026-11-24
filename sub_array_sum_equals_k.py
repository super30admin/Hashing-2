#Problem:

#Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

#Analysis: We use Running Sum + Hashing. So idea is lets say we have this array

# nums = [1,1,1], k = 2

# here there are two sub arrays whose sum would be equal to k, which is 2. [1,1] and [1,1]

#Brute force is to find out every possible sub array and check the sum. in that case, time complexity is O(n^3).

#optimized approach is to use running sum + hashing.

#[3,4,7,...]

#Time complexity: O(n)

#space complexity: O(n)

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        map = {}
        map[0] = 1
        runSum = 0
        res = 0
        for i in range(len(nums)):
            runSum += nums[i]
            comp = runSum - k
            if comp in map:
                res += map[comp]
            map[runSum] = map.get(runSum, 0) + 1
        return res


