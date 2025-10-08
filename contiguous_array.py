from collections import defaultdict
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        
        # 0 is -1 and 1 is +1

        count = defaultdict(int)
        count[0] = -1
        maxL = 0

        rsum = 0
        for i, num in enumerate(nums):
            if num == 0:
                rsum -= 1
            else:
                rsum += 1

            # store the first occurrence of each rSum
            if rsum not in count:
                count[rsum] = i
            else:
                maxL = max(maxL, i - count[rsum])
        
        return maxL
