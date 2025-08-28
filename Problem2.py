# // Time Complexity : O(n)
# // Space Complexity : O(n) 
# // Did this code successfully run on Leetcode : yes
# // Any problem you faced while coding this : yes, refered the video one more time.

class Solution(object):
    def findMaxLength(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # have to find the subarry with the same number of 1's and 0's
        # brute force: create sub arrays, complexity O(n2), and then check the frequecies of 0,1 which is again O(n) total O(n*3)
        # which is not an optimze approach, the trick part is to identify from which index to which index the number of 1's and 0's can be same 
        # approach : lets keep track of the sum so when we come across 1 in the loop increment it with 1 and when 0 comes decrease to 0. 
        # and in the loop when this sum value come across at xth index then 0-xth index we found the balanced array, because the indexs at 0,x having the same sum value we found a balanced tree 
        # The next tricky part is to find the maximum-length subarray, so we should keep track of the starting index of each cumulative sum.

        cumulative_sum = 0
        hash_map = {} # storging the cumulative sum and the first index where we found this sum

        hash_map[0] = -1 # intially storing the cumulative sum 0 with index -1 and then once we keep getting the sum we can add the indexes
        max_len = 0 # intially 0

        for i in range(len(nums)): # tc O(n)
            if nums[i] == 1:
                cumulative_sum +=1
            else:
                cumulative_sum -=1

            if cumulative_sum in hash_map: # tc O(1)
                curr_len_balanced_tree = i - hash_map[cumulative_sum] 
                max_len = max(curr_len_balanced_tree, max_len)
            else:
                hash_map[cumulative_sum] = i # tc O(1), sc O(n) worst case 

        return max_len




