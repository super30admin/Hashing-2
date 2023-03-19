#Time complexity : O(n)
#Space complexity : O(n)

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        max_len = 0
        dict1 = {}
        dict1[0] = -1
        c = 0
        for i in range(len(nums)):
            if(nums[i] ==0):
                c-=1
            else:
                c+=1
            if(c in dict1.keys()):
                cur_len = i - dict1[c]
                if(cur_len>max_len):
                    max_len = cur_len
            else:
                dict1[c] = i
        return max_len