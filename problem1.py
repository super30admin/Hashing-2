#  Time Complexity : O(n)
#  Space Complexity : O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : Was returning count+smap[k] before setting smap[0]=1 by default. Works, same complexity. But this was simpler and couldnt think of it right away. 
class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        smap={0:1}
        cur_sum=0
        count=0

        for n in nums:
            cur_sum +=n
            check = cur_sum-k   

            if check in smap:
                count+=smap[check]
            if cur_sum in smap:
                smap[cur_sum]+=1
            else:
                smap[cur_sum]=1
            
        return count
            
        