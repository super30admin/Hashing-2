# Time Complexity: O(n)
# Space Complexity: O(n)
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        dic = {0:-1}
        currsum = 0
        longest = 0
        for i in range(len(nums)):
            if nums[i] == 0:
                currsum -= 1
            else:
                currsum += 1
            if currsum not in dic:
                dic[currsum] = i
            else:
                longest = max(longest, i - dic[currsum])
        print(dic)
        return longest