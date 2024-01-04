#time complexity : O(N) where N is the size of the array 
#space complexity:O(N) because we used a map

class Solution:
    def findMaxLength(self, nums: list[int]) -> int:
        count = 0
        map = {0:-1}
        max_len = 0

        for i,n in enumerate(nums):
            if n:
                count += 1
            else:
                count -= 1
            
            if count in map:
                max_len = max(max_len, (i-map[count]))
            else:
                map[count] = i
        
        return max_len

sol = Solution()
nums = [0,1,0]
print(sol.findMaxLength(nums))