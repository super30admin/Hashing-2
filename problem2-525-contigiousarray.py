#time - o(n)
#space -- o(n)
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:

        mydict = {}
        mydict[0] = -1
        max_length = 0
        rsum = 0
        for i in range(len(nums)):
            if nums[i] == 1:
               rsum+=1
            else:
               rsum-=1
            if  rsum in mydict:
                max_length = max(max_length, i - mydict[rsum])
            else:
                mydict[rsum] = i
        return max_length