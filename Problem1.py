# Time Complexity: O(n)

# Space Complexity: O(n) for the hash map and the cumulative sum array

# Did it run on Leetcode:

# Approach:
# Calulculate the cumulative sum at each index in the list.
# If at any point the the dofference between the current cumulative sum and cumulative sum at previous index=target, then we know that all elements
# after the previous cumulative index including the element at the index of new cumulative sum will give me summation which equals to the target
# Now we maintain a hashmap wherein if the difference between current sum and target is found,we increment the count by 1

class Solution:
    def subarraySum(self, nums, k):
        count = 0
        cumsum = [0]
        sumDict = {}
        for i in range(0, len(nums)):
            cumsum.append(cumsum[-1] + nums[i])
        for i in cumsum:
            if i - k in sumDict:
                count += sumDict[i - k]
            if (i in sumDict):
                sumDict[i] += 1
            else:
                sumDict[i] = 1
        return count


s = Solution()
print(s.subarraySum([1, 1, 1], 2))
