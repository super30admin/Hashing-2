"""
I implemented this using the technique taught in the session, where I add a dummy entry for the 0th index in the hashmap. For the rest, I track the running sum and check if it has occurred earlier, then use the corresponding index to calculate the length.
Time Complexity: O(n)
Space Complexity: O(n)
"""
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hashMap = {}
        hashMap[0] = -1
        rSum = 0
        maxArr = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                rSum -= 1
            else:
                rSum += 1
            if rSum in hashMap:
                maxArr = max(maxArr, i - hashMap.get(rSum))
            else:
                hashMap[rSum] = i
        return maxArr 