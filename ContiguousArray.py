'''
We maintain a running sum, where we add 1 to rs if '1' else we subtract 1 from rs if '0'
When iterating overs nums, we store the index against it's rs and then when we come across
the same rs that we found earlier, then this means that we have a sub-array of equal number 
of 0's and 1's in between.
We check if this sequence length if maximum compared to prev max_seq length.  
Time Complexity: O(N) - Linear search
Space Complexity: O(N) - Hash Map for storing running sum at each index. 
'''
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        ans = 0
        rs = 0
        rs_map = {}
        rs_map[0]=-1 # 0 sum right before starting 0th index

        for i in range(len(nums)):
            if nums[i]==0:
                rs+=-1
            else:
                rs+=1
            if rs in rs_map:
                curr_len = i-rs_map[rs]
                ans = max(ans,curr_len)
                # rs_map[rs]=min(rs_map[rs],i)
            else:
                rs_map[rs]=i
        return ans