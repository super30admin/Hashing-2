"""
I implemented the solution using the technique taught in the session, where I maintain a running sum and store its earliest occurrence index in a hashmap. By checking if the current running sum minus the target has appeared before, I can find subarrays that sum to the target efficiently. This approach allows constant-time lookups and updates as we iterate through the array once.
Time Complexity: O(n)
Space Complexity: O(n)
"""
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        hashMap = {}
        currentSum = 0
        count = 0
        hashMap[0] = 1

        for i in range(len(nums)):
            currentSum += nums[i]
            
            if (currentSum - k) in hashMap:
                count += hashMap[currentSum - k]

            if currentSum in hashMap:
                newCount = hashMap[currentSum]
                newCount += 1
                hashMap[currentSum] = newCount
            else:
                hashMap[currentSum] = 1

        return count