# Time Complexity : O(n**2)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : No (time limit exceeded)
# Any problem you faced while coding this : Time limit exceeded

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        a ={}
        s = 0
        for i in range(len(nums)):
            a[i] = s
            s += nums[i]
        print(a)
        out = 0
        for i in a:
            if a[i] == k:
                out += 1
        for i in range(1,len(nums)):
            for j in range(0,i):
                # print(i,j)
                if a[i] - a[j] == k:
                    print(i,j)
                    out += 1
        return out