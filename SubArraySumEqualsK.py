#RUNNING SUM:z=x-y :HashMap
#TC: O(n)
#SC: O(1)

# This approach uses the prefix sum (running sum) technique along with a hash map to store how many times each prefix sum has occurred. For each element in the array, it checks if (runningSum - target) exists in the map. If it does, that means a subarray ending at the current index sums to the target. The map helps track how many such subarrays exist without re-checking all previous elements.

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
    
        runningSumDict = dict()  # Stores frequency of each running sum
        count = 0  # Total number of valid subarrays found
        runningSumDict[0] = 1  # Initialize with sum 0 to handle subarrays starting from index 0
        runningSum = 0  # Keeps the cumulative sum

        for i in nums:
            runningSum += i  #Update running sum with current element
            
            #runningSum - k  Compute needed sum to form a valid subarray
            if (runningSum - k) in runningSumDict:
                count += runningSumDict[runningSum - k]  #Add number of times the compliment has occurred

            #Initialize current running sum count if it hasn't been seen before
            if runningSum not in runningSumDict:
                runningSumDict[runningSum] = 0

            runningSumDict[runningSum] += 1  #Record current running sum

        return count
