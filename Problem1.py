#Subarray Sum Equals K

#we'll save the map having the sum til index i of array saved in the map, with the value be the occuresnces of that sum
# if the complemnet number i.e sum-targt is in the map that means the k can be achieved from that complement index onwards till the current index
# so we'll add the occurences of the complement to our result
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        runinSumMapFreq = {}
        runinSumMapFreq[0] = 1
        currentSum = 0
        result = 0

        for num in nums:
            currentSum = currentSum + num
            if (currentSum - k) in runinSumMapFreq:
                result+=runinSumMapFreq[currentSum - k]
            if currentSum in runinSumMapFreq:
                runinSumMapFreq[currentSum]+=1
            else:
                runinSumMapFreq[currentSum] = 1
        
        return result