"""

T.C.: O(n)
S.C.: O(n)

"""

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        hashDic = {}
        hashDic[0] = -1
        ans = 0
        rSum = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                rSum -= 1
            else:
                rSum += 1
            if rSum in hashDic.keys():
                ans = max(ans, i - hashDic[rSum])
            else:
                hashDic[rSum] = i

        return ans
                
                

        


