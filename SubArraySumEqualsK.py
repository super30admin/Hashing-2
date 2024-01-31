# Time Complexity = o(n) As there is only one for loop
# Space Complexity = o(n) We creating a hashmap with n length

class Solution:
    def subarraySum(self, nums: list[int], k: int) -> int:
        # logic behind this we will use running sum concept
        # We runningSum = sumArray1 + sumArray2(k)
        # so In our case runningSum - target(k) = sumArray1
        # so we check how many time subArray1 occurs before we will keep on adding that number to our count else we will runningSum to the hashMap.
        # For reference and initially we know 0 is there, it means 0 happens once
        # we initialize dictionary with 0 happens once

        count = 0
        rSum = 0
        hashMap = {0: 1}

        for i in nums:
            rSum += i
            sumArray1 = rSum - k
            if sumArray1 in hashMap:
                count += hashMap[sumArray1]
            if rSum not in hashMap:
                hashMap[rSum] = 1
            else:
                hashMap[rSum] += 1
        return count
