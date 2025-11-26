# For each element in the array, increment the counter when the element is 1 and decrement when 
# it is 0. If the summation is not in d, add it in d with its index else find the max of the length. 
# Return the max length.

# Time complexity: O(n)
# Space complexity: O(n)


class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        l=len(nums)
        # arr = [None for i in l]
        c=0
        d={}
        max_len=0
        for ind, i in enumerate(nums):
            if i==1:
                c+=1
            else:
                c-=1
            if c == 0:
                max_len=ind+1
            if c not in d:
                d[c]=ind
            else:
                max_len=max(max_len,ind-d[c])
        return max_len

            
        

        