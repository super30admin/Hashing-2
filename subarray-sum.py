# Iterate over the array and find the summation at each element (s). At each summation, check if 
# s-k is present in d, it is increment the counter by the value of d[s-k]. If the summation = k, 
# increment the counter by 1. Is the summation is not in d, add the key and map to 1 else increment
#  the count by 1

# Time complexity: O(n)
# Space complexity: O(n)


class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        d={}
        s=0
        c=0

        for ind,i in enumerate(nums):
            s+=i
           
            if s-k in d:
                c+=d[s-k]  
            if k== s:
                c+=1 
            if s not in d:
                d[s]=1
            else:
                d[s]=d[s]+1

        return c

