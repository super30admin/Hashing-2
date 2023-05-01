class Solution:
    def findContinuousArray(self, arr, target):
        rSumDict = dict()        
        count = 0
        rSumDict[0] = 1
        sum = 0

        for i in arr:
            sum += i

            compliment = sum - target

            if compliment in rSumDict:
                count += rSumDict[compliment]

            if sum not in rSumDict:
                rSumDict[sum] = 0

            rSumDict[sum] += 1

        return count

nums = [23, 2, 4, 6, 7, 3, 3]
k = 6
sol = Solution();
output = sol.findContinuousArray(nums, k)
print(output)