# Time Complexity : O(n) where n is the number of integers present in list
# Space Complexity : O(n) to store the keys
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution:

    def findMaxLength(self, nums: List[int]) -> int:
        count = 0
        maxLength = 0
        hashMap = {0: 0}

        for index, num in enumerate(nums, 1):

            # if num 0 we will add -1 to the count else we will add + 1 to the count
            if num == 0:
                count -= 1
            else:
                count += 1

            # if count == 0 we will update maxlength,  with either the current max or current position - hashmap
            # current count value which is greater.
            if count in hashMap:
                maxLength = max(maxLength, index - hashMap[count])
            else:
                # else: we will add that position to the hashMap count
                hashMap[count] = index

        return maxLength
