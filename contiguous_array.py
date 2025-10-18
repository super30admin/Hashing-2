class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        # hashMap stores the first index where each running sum (rSum) was seen
        # rSum represents the difference between count(1) and count(0) up to that index
        hashMap = {}

        # Running sum starts from 0
        rSum = 0

        # Initialize rSum=0 at index -1 to handle subarrays starting from index 0
        hashMap[0] = -1

        # Keeps track of the maximum length of subarray with equal 0s and 1s
        maxLenArr = 0

        # Iterate through the array
        for i, num in enumerate(nums):
            # Treat 0 as -1 and 1 as +1 to balance the sum when equal numbers appear
            if num == 0:
                rSum -= 1
            else:
                rSum += 1

            # If this rSum was seen before, it means the subarray between
            # previous index and current index has equal 0s and 1s
            if rSum in hashMap:
                # Calculate the subarray length and update max if it's larger
                maxLenArr = max(maxLenArr, i - hashMap[rSum])
            else:
                # Store the first occurrence of this rSum
                # (We only store it once to get the longest possible subarray)
                hashMap[rSum] = i

        # Return the maximum length found
        return maxLenArr
