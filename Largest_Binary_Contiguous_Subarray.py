### TC: O(N)
### SC: O(1)
class Solution:
    def findMaxLength(nums:list[int])->int:
        sum_map = {0:-1}
        max_len = 0
        distance = 0
        partial_sum = 0
        
        for i,num in enumerate(nums):
            if num == 1:
                partial_sum+=1
            else:
                partial_sum-=1
            if partial_sum in sum_map:
                distance = i - sum_map[partial_sum]
                max_len = max(max_len, distance)
            else:
                sum_map[partial_sum] = i
        return max_len
    
    
print(Solution.findMaxLength([0,1,0,0,1,1,0]))
