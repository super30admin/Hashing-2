class Solution:
    def findMaxLength(self, nums):
        """
        Approach:
        1. Lets consider we have only [1, 0] as array and we need to return the maximum length of a contiguous subarray then we can consider following steps
           - Assume a variable initialized to 0
           - Oth element of list can be accessed by 0 + 1
           - and next element can be accessed by 0 - 1, back to 0
           - Now maximum length can be achieved by subtracting index values whose running sum is same
           - In this case it is -1 and 1 i.e. 1 - (-1) = 2
          2. To keep a track of inital index and running sum we will use a hasmap with running sum as key and initial index as value
          3. We will also use one variable to keep a track of maximum length.
          4. Whenever we will have a same running sum value we will do the index subtraction and will update the maximum length variable if its value is less than index subtraction result.
          
          Time Complexity: O(n)
          Space Complexity: O(n)
        """
        if len(nums) == 0:
            return 0
            
        max_length = 0
        running_sum = 0
        tracking_dict = {0:-1}
        for i in range(len(nums)):
            if nums[i] == 0:
                running_sum = running_sum - 1
            else:
                running_sum = running_sum + 1
            if running_sum not in tracking_dict.keys():
                tracking_dict[running_sum] = i
            if (i - tracking_dict.get(running_sum)) > max_length:
                max_length = i - tracking_dict.get(running_sum)
        return max_length

temp = Solution()
nums = [0,1]
result = temp.findMaxLength(nums)
print(result)