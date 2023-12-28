'''
Time complexity: O(n)
Space complexity: O(1)
'''
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        rSum, HashMap = 0, {0: -1}
        Res, diff = 0, 0

        for i in range(len(nums)):
            if (nums[i]==0):
                rSum-=1
            else:
                rSum+=1
            if rSum in HashMap:
                diff = i-HashMap[rSum]
                if diff > Res:
                    Res = diff
            else:
                HashMap[rSum] = i # Store earliest index as happened for first time

        return Res
        