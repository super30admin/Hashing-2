class Solution:
    '''
    Time complexity: O(n)
    Space complexity: O(n)
    '''
    def findMaxLength(self, nums: List[int]) -> int:
        # use a dict to hold {curr_sum: index}
        d = {0:0}
        
        # cummulative sum and max length (res)
        res = running_sum = 0
        
        # you need to enumerate so you can get the correct position
        for i, num in enumerate(nums, 1):
            if num == 0:
                running_sum -= 1
            else:
                running_sum += 1
            
            # get the lengths
            if running_sum in d:
                res = max(res, (i - d[running_sum]))
            else:  
                d[running_sum] = i
        return res
                