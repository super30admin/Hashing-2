# key thing to note WHEN THE ONGOING SUM HAS INCREASED BY K, WE'VE FOUND A K!

class Solution:
    '''
    Time complexity: O(n)
    Space complexity: O(n)
    '''
    def subarraySum(self, nums: List[int], k: int) -> int:
        
        # keep track of first sum
        d = {0:1}
        
        # keep track of res counter and current sum
        res = curr_sum = 0
        
        for n in nums:
            curr_sum += n
            res += d.get(curr_sum-k, 0) # if sums-k exists get the count, otherwise 0
            d[curr_sum] = d.get(curr_sum, 0) +1 # increment count of current sum by 1
        
        return res
        