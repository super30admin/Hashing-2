''' 
TimeComplexity: O(N)
SpaceComplexity: O(N)

Approach: 
The problem is solved using a special case of prefix sum technique.
We iterate through the array keeping the count of 1s and 0s in the array 
For every 1 we increment the count and for every 0 we decrement the count. 
We check if the curr count has occurred previously and for this we use a hashmap 
If it has occured previously we calculate the length and store it if it's greater than the max length 

The reason we check if the curr count has occured previously is because for the same preivous count, our calcaluated effective subarray will be balanced
Which is technically why the prefix sum count has NOT changed 
'''

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        curr_count = 0
        ps = []
        maxLength = 0
        ps_dict = {}
        ps_dict[0] = -1
        for idx, num in enumerate(nums):
            if num == 1:
                curr_count += 1
            else:
                curr_count -= 1
            ps.append(curr_count)
            if curr_count in ps_dict:
                maxLength = max(maxLength, idx - ps_dict[curr_count])
            else:
                ps_dict[curr_count] = idx

        return maxLength
