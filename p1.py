#tc = O(n)
#sc = O(n)
#successfully run on leetcode: Yes

class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        running_sum = 0 
        ans = 0

        my_dict = {0: 1}

        for i in range(0, len(nums)):
            running_sum += nums[i]
            curr = running_sum - k # 14 = 21 -7 
            if curr in my_dict:
                ans += my_dict[curr]
            if running_sum not in my_dict:
                my_dict[running_sum] = 1
            else:
                my_dict[running_sum] += 1
        return ans
