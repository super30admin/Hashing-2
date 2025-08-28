## Problem2 (https://leetcode.com/problems/contiguous-array/)

# Method1: Brute Force
# Create all the subarrays and check if they have equal number of 1s and 0s

# Time Complexity : O(N^3) - Brute force
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : TLE
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# Create all the subarrays using nested loops. Then for each subarray we check if that has equal number of 1s and 0s. If yes then we
# keep the max length of those subarrays. As it is brute force approach, the complexity is very high

class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n = len(nums)
        maxxLength = 0
        for i in range(n):
            for j in range(i, n):# O(n^2)
                count0 = 0
                count1 = 0
                for k in range(i, j + 1): # O(n^3)
                    if(nums[k] == 0):
                        count0 += 1
                    else:
                        count1 += 1
                if(count0 == count1):
                    # balanced sub array
                    maxxLength = max(maxxLength, j - i + 1)
        
        return maxxLength
    
sol = Solution()
print("Method1: Brute Force: Check all subarrays using nested loops")
print(sol.findMaxLength([0,1]))
print(sol.findMaxLength([0,1,0]))
print(sol.findMaxLength([0,1,1,1,1,1,0,0,0]))
print(sol.findMaxLength([0]))
print(sol.findMaxLength([1]))
print(sol.findMaxLength([1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0]))


# Method2: Optimal
# Maintain a running sum for each index.

# Time Complexity : O(N)
# Space Complexity : O(N) -- we can have N distinct sum possible. Eg: [1,1,1,1,1,1,....]
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach in three sentences only
# We use the concept of running sum. If we know running sums at two different indices say x an y, then to get running sum for 
# elements between those two indices for that subarray, we dont need to iterate over them. We would get it by x-y = z. Using this concept
# if we know same running at two different indices in the array, it means that the netsum for the subarray between them is 0 as x and y
# are equal. This helps to elimiinate the nested loops for creating the subarrays. We make a dummy entry of {0:-1} into the hashmap
# to check the subarrays starting from index=0 as well.


class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # map to store the running summ with dummy entry of {0 : -1}
        # This helps to check subArrays starting from index=0
        # storing (runnSum, index)
        subArrRunningSumMap = {0:-1}

        # global max for longest length
        maxBalancedSubArrLen = 0

        # running sum
        runnSum = 0

        for i in range(len(nums)):
            if(nums[i] == 1):
                runnSum += 1
            else:
                # if nums[i] == 0
                runnSum -= 1

            if(runnSum in subArrRunningSumMap):
                # we have a balanced sub array
                # between earliest index and current index
                # as netsum = x-y = z = 0 as x and y subarray sum
                # becomes equal
                # length would be
                maxBalancedSubArrLen = max(maxBalancedSubArrLen, i - subArrRunningSumMap[runnSum])

            else:
                # if new entry of running sum
                subArrRunningSumMap[runnSum] = i

        return maxBalancedSubArrLen


        
sol = Solution()
print("Method2: Maintain a running sum for each index and check if it existed before")
print(sol.findMaxLength([0,1]))
print(sol.findMaxLength([0,1,0]))
print(sol.findMaxLength([0,1,1,1,1,1,0,0,0]))
print(sol.findMaxLength([0]))
print(sol.findMaxLength([1]))
print(sol.findMaxLength([1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0]))

        
