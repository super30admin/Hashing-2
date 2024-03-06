## continuous array
# Time and space complexity is O(N)
class ContinuousArray:
    def FindContinuousArray(self, nums):
        dic = {0: -1}
        currentSum = 0
        ans = 0
        
        for i, num in enumerate(nums):
            if num is 0:
                currentSum-= 1
            else:
                currentSum+= 1
            
            if currentSum in dic:
                ans = max(ans, i-dic[currentSum])
            else:
                dic[currentSum] = i
                
        return ans