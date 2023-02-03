#tc = O(n)
#sc = O(n)
#successfully run on leetcode: Yes

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        count = 0
        my_dict = {0:-1}
        ans = 0

        for i in range(0, len(nums)):
            if nums[i] == 1:
                count += 1 
            elif nums[i] == 0:
                count -= 1
            #count is not in the dict yet
            if count not in my_dict:
                my_dict[count] = i
                
            #same count already exists 
            #then check the distance between two indexes
            else:
                curr_distance = i - (my_dict[count])
                if curr_distance > ans:
                    ans = curr_distance
                
        return ans 