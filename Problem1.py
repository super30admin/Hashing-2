#Time complexity : O(n)
#Space complexity : O(n)
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        ans = 0
        prefixSum = 0
        dict1 = {}
        dict1[0] = 1
        for i in nums:
            prefixSum = prefixSum + i
            target = prefixSum - k
            if(target in dict1.keys()):
                ans += dict1[target]
            if(prefixSum in dict1.keys() ):
                    dict1[prefixSum] += 1
            else:
                dict1[prefixSum] = 1
        return ans

            
            