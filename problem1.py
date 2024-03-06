# Subarray Sum Equals K
# Time and space complexity is O(N)
class GetSubArraySum:
    def subarraySum(self, nums, k):
        dic = {0:1}
        ans = 0
        currentSum = 0
        
        for num in nums:
            currentSum+= num
            diff = currentSum-k
            ans+= dic.get(diff, 0)
            dic[currentSum] = 1+ dic.get(currentSum, 0)
        return ans