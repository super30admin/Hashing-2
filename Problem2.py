# Time Complexity : O(n**2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : No(time limit exceeded)
# Any problem you faced while coding this : Yes

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        a = {}
        for i in range(len(nums)):
            if i == 0:
                if nums[i] == 0:
                    a[0] = [1,0]
                else:
                    a[0] = [0,1]
            else:
                if nums[i] == 0:
                    a[i] = [a[i-1][0]+1,a[i-1][1]]
                else:
                    a[i] = [a[i-1][0],a[i-1][1]+1]
                    
        print(a)
        maxLen = 0
        for i in a:
            if a[i][0] == a[i][1]:
                maxLen = i+1
        for i in range(1,len(nums)):
            for j in range(0,i):
                if a[i][0] - a[j][0] == a[i][1] - a[j][1]:
                    if maxLen < i-j:
                        maxLen = i-j
        return maxLen