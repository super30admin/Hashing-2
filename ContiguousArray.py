#Time Complexity : O(n) where n is the length of the nums list
#Space Complexity : O(n) since we use a dictionary whos max kength can be n in worst case.
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this :No

#Approach: We use the running sum approach and store the same in a dictionary (key = rSum, value = index i). We use a dummy sum as 0 at index -1 to handle 
# the edge cases. We add 1 to rSum if the number is 1 else if it is 0 we add -1 to it. Then we check if the rSum is present in 
# the dictionary. If it is not present we add that rSum and the corresponding index in the dictionary. If present, we calculate
# the maximum length subtracting the index of the rSum from the dictionary with the current index. Return the max length in the end


class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        mapl = {}
        mapl[0] = -1
        rSum = 0
        maxl = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                rSum -= 1
            else:
                rSum += 1
            if rSum in mapl:
                maxl = max(maxl, i - mapl[rSum])
            else:
                mapl[rSum] = i
        return maxl
